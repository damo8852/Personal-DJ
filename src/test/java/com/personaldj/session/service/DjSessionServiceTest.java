package com.personaldj.session.service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationEventPublisher;

import com.personaldj.domain.entity.DjSession;
import com.personaldj.domain.entity.User;
import com.personaldj.engine.observer.event.SessionStartedEvent;
import com.personaldj.provider.repository.DjSessionRepository;

@ExtendWith(MockitoExtension.class)
public class DjSessionServiceTest {

    @Mock
    private DjSessionRepository sessionRepository;

    @Mock
    private ApplicationEventPublisher eventPublisher;

    private DjSessionService djSessionService;

    @BeforeEach
    public void setUp() {
        djSessionService = new DjSessionService(sessionRepository, eventPublisher);
    }

    @Test
    public void testStartSession() {
        User user = new User();
        String mood = "Happy";

        DjSession savedSession = new DjSession();
        savedSession.setUser(user);
        savedSession.setMood(mood);
        savedSession.setStartedAt(LocalDateTime.now());

        when(sessionRepository.save(any(DjSession.class))).thenReturn(savedSession);

        DjSession result = djSessionService.startSession(user, mood);

        assertNotNull(result);
        assertEquals(mood, result.getMood());
        assertNotNull(result.getStartedAt());
        verify(sessionRepository, times(1)).save(any(DjSession.class));
        verify(eventPublisher, times(1)).publishEvent(any(SessionStartedEvent.class));
    }

    @Test
    public void testEndSession() {
        Long sessionId = 1L;
        DjSession session = new DjSession();
        session.setStartedAt(LocalDateTime.now());

        when(sessionRepository.findById(sessionId)).thenReturn(Optional.of(session));

        djSessionService.endSession(sessionId);

        assertNotNull(session.getEndedAt());
        verify(sessionRepository, times(1)).findById(sessionId);
        verify(sessionRepository, times(1)).save(session);
    }

    @Test
    public void testEndSessionWhenSessionNotFound() {
        Long sessionId = 999L;
        when(sessionRepository.findById(sessionId)).thenReturn(Optional.empty());

        djSessionService.endSession(sessionId);

        verify(sessionRepository, times(1)).findById(sessionId);
        verify(sessionRepository, never()).save(any());
    }

    @Test
    public void testGetSessionsForUser() {
        Long userId = 1L;
        DjSession session1 = new DjSession();
        session1.setStartedAt(LocalDateTime.now().minusHours(2));

        DjSession session2 = new DjSession();
        session2.setStartedAt(LocalDateTime.now().minusHours(1));

        List<DjSession> sessions = Arrays.asList(session2, session1); // Ordered by startedAt desc

        when(sessionRepository.findByUserIdOrderByStartedAtDesc(userId)).thenReturn(sessions);

        List<DjSession> result = djSessionService.getSessionsForUser(userId);

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(sessionRepository, times(1)).findByUserIdOrderByStartedAtDesc(userId);
    }

    @Test
    public void testGetSessionsForUserWithNoSessions() {
        Long userId = 1L;
        when(sessionRepository.findByUserIdOrderByStartedAtDesc(userId)).thenReturn(List.of());

        List<DjSession> result = djSessionService.getSessionsForUser(userId);

        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(sessionRepository, times(1)).findByUserIdOrderByStartedAtDesc(userId);
    }
}

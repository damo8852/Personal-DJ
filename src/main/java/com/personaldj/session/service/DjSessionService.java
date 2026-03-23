package com.personaldj.session.service;

import com.personaldj.domain.entity.DjSession;
import com.personaldj.domain.entity.User;
import com.personaldj.engine.observer.event.SessionStartedEvent;
import com.personaldj.provider.repository.DjSessionRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DjSessionService {

    private final DjSessionRepository sessionRepository;
    private final ApplicationEventPublisher eventPublisher;

    public DjSessionService(DjSessionRepository sessionRepository,
                            ApplicationEventPublisher eventPublisher) {
        this.sessionRepository = sessionRepository;
        this.eventPublisher = eventPublisher;
    }

    @Transactional
    public DjSession startSession(User user, String mood) {
        DjSession session = new DjSession();
        session.setUser(user);
        session.setMood(mood);
        session.setStartedAt(LocalDateTime.now());
        DjSession saved = sessionRepository.save(session);
        eventPublisher.publishEvent(new SessionStartedEvent(this, saved));
        return saved;
    }

    @Transactional
    public void endSession(Long sessionId) {
        sessionRepository.findById(sessionId).ifPresent(session -> {
            session.setEndedAt(LocalDateTime.now());
            sessionRepository.save(session);
        });
    }

    public List<DjSession> getSessionsForUser(Long userId) {
        return sessionRepository.findByUserIdOrderByStartedAtDesc(userId);
    }
}

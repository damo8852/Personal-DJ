package com.personaldj.domain.entity;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class DjSessionTest {

    @Test
    public void testSetAndGetMood() {
        DjSession session = new DjSession();
        session.setMood("Happy");

        assertEquals("Happy", session.getMood());
    }

    @Test
    public void testSetAndGetStartedAt() {
        DjSession session = new DjSession();
        LocalDateTime now = LocalDateTime.now();
        session.setStartedAt(now);

        assertEquals(now, session.getStartedAt());
    }

    @Test
    public void testSetAndGetEndedAt() {
        DjSession session = new DjSession();
        LocalDateTime now = LocalDateTime.now();
        session.setEndedAt(now);

        assertEquals(now, session.getEndedAt());
    }

    @Test
    public void testSetAndGetUser() {
        DjSession session = new DjSession();
        User user = new User();
        session.setUser(user);

        assertEquals(user, session.getUser());
    }

    @Test
    public void testRulesInitializedEmpty() {
        DjSession session = new DjSession();

        assertNotNull(session.getRules());
        assertTrue(session.getRules().isEmpty());
    }

    @Test
    public void testIdIsNullBeforePersist() {
        DjSession session = new DjSession();

        assertNull(session.getId());
    }
}

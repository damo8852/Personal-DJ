package com.personaldj.domain.entity;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

public class UserFeedbackTest {

    @Test
    public void testSetAndGetFeedbackType() {
        UserFeedback feedback = new UserFeedback();
        feedback.setFeedbackType("LIKE");

        assertEquals("LIKE", feedback.getFeedbackType());
    }

    @Test
    public void testSetAndGetTrack() {
        UserFeedback feedback = new UserFeedback();
        Track track = new Track();
        feedback.setTrack(track);

        assertEquals(track, feedback.getTrack());
    }

    @Test
    public void testSetAndGetSession() {
        UserFeedback feedback = new UserFeedback();
        DjSession session = new DjSession();
        feedback.setSession(session);

        assertEquals(session, feedback.getSession());
    }

    @Test
    public void testSetAndGetRecordedAt() {
        UserFeedback feedback = new UserFeedback();
        LocalDateTime now = LocalDateTime.now();
        feedback.setRecordedAt(now);

        assertEquals(now, feedback.getRecordedAt());
    }

    @Test
    public void testIdIsNullBeforePersist() {
        UserFeedback feedback = new UserFeedback();

        assertNull(feedback.getId());
    }
}

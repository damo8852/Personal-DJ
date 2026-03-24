package com.personaldj.engine.observer.event;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

import com.personaldj.domain.entity.DjSession;

public class SessionStartedEventTest {

    @Test
    public void testGetSession() {
        DjSession session = new DjSession();
        session.setMood("Happy");
        Object source = new Object();

        SessionStartedEvent event = new SessionStartedEvent(source, session);

        DjSession result = event.getSession();

        assertNotNull(result);
        assertEquals(session, result);
        assertEquals("Happy", result.getMood());
    }

    @Test
    public void testSessionStartedEventConstructor() {
        DjSession session = new DjSession();
        Object source = new Object();

        SessionStartedEvent event = new SessionStartedEvent(source, session);

        assertNotNull(event);
        assertEquals(source, event.getSource());
        assertEquals(session, event.getSession());
    }
}

package com.personaldj.engine.observer.event;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

import com.personaldj.domain.entity.UserFeedback;

public class FeedbackReceivedEventTest {

    @Test
    public void testGetFeedback() {
        UserFeedback feedback = new UserFeedback();
        Object source = new Object();

        FeedbackReceivedEvent event = new FeedbackReceivedEvent(source, feedback);

        UserFeedback result = event.getFeedback();

        assertNotNull(result);
        assertEquals(feedback, result);
    }

    @Test
    public void testFeedbackReceivedEventConstructor() {
        UserFeedback feedback = new UserFeedback();
        Object source = new Object();

        FeedbackReceivedEvent event = new FeedbackReceivedEvent(source, feedback);

        assertNotNull(event);
        assertEquals(source, event.getSource());
        assertEquals(feedback, event.getFeedback());
    }
}

package com.personaldj.engine.observer.event;

import com.personaldj.domain.entity.UserFeedback;
import org.springframework.context.ApplicationEvent;

/**
 * Observer pattern — event published when a user submits feedback (like/skip/dislike) on a track.
 */
public class FeedbackReceivedEvent extends ApplicationEvent {

    private final UserFeedback feedback;

    public FeedbackReceivedEvent(Object source, UserFeedback feedback) {
        super(source);
        this.feedback = feedback;
    }

    public UserFeedback getFeedback() {
        return feedback;
    }
}

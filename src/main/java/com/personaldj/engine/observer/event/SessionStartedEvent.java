package com.personaldj.engine.observer.event;

import com.personaldj.domain.entity.DjSession;
import org.springframework.context.ApplicationEvent;

/**
 * Observer pattern — event published when a new DJ session begins.
 */
public class SessionStartedEvent extends ApplicationEvent {

    private final DjSession session;

    public SessionStartedEvent(Object source, DjSession session) {
        super(source);
        this.session = session;
    }

    public DjSession getSession() {
        return session;
    }
}

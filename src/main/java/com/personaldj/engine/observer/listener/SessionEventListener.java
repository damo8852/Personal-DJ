package com.personaldj.engine.observer.listener;

import com.personaldj.engine.observer.event.SessionStartedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class SessionEventListener {

    private static final Logger log = LoggerFactory.getLogger(SessionEventListener.class);

    @EventListener
    public void onSessionStarted(SessionStartedEvent event) {
        log.info("Session started: sessionId={} mood={}",
                event.getSession().getId(),
                event.getSession().getMood());
        // TODO: initialize rule pipeline for the session
    }
}

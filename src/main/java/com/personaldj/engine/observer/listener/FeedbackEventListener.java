package com.personaldj.engine.observer.listener;

import com.personaldj.engine.observer.event.FeedbackReceivedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class FeedbackEventListener {

    private static final Logger log = LoggerFactory.getLogger(FeedbackEventListener.class);

    @EventListener
    public void onFeedbackReceived(FeedbackReceivedEvent event) {
        log.info("Feedback received: type={} trackId={}",
                event.getFeedback().getFeedbackType(),
                event.getFeedback().getTrack().getId());
        // TODO: update preference profile based on feedback
    }
}

package com.personaldj.engine.strategy;

import com.personaldj.domain.entity.DjSession;
import com.personaldj.domain.entity.Track;
import org.springframework.stereotype.Component;

/**
 * Strategy that scores tracks based on how closely their valence matches the session mood.
 */
@Component
public class MoodMatchStrategy implements ScoringStrategy {

    @Override
    public double score(Track candidate, DjSession session) {
        // TODO: implement mood/valence-based scoring using AudioFeatures
        return 0.0;
    }
}

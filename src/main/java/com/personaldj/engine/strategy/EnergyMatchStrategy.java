package com.personaldj.engine.strategy;

import com.personaldj.domain.entity.DjSession;
import com.personaldj.domain.entity.Track;
import org.springframework.stereotype.Component;

/**
 * Strategy that scores tracks based on how closely their energy level matches the session target.
 */
@Component
public class EnergyMatchStrategy implements ScoringStrategy {

    @Override
    public double score(Track candidate, DjSession session) {
        // TODO: implement energy-based scoring using AudioFeatures
        return 0.0;
    }
}

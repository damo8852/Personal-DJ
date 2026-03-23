package com.personaldj.engine.strategy;

import com.personaldj.domain.entity.DjSession;
import com.personaldj.domain.entity.Track;
import org.springframework.stereotype.Component;

/**
 * Strategy that scores tracks based on the user's preferred genres derived from session history.
 */
@Component
public class GenreAffinityStrategy implements ScoringStrategy {

    @Override
    public double score(Track candidate, DjSession session) {
        // TODO: implement genre affinity scoring using user preference profile
        return 0.0;
    }
}

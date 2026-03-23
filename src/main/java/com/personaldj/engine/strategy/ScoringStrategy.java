package com.personaldj.engine.strategy;

import com.personaldj.domain.entity.DjSession;
import com.personaldj.domain.entity.Track;

/**
 * Strategy pattern — defines the contract for scoring a candidate track within a DJ session.
 * <p>
 * Implementations apply different heuristics (energy match, mood match, genre affinity, etc.)
 * to produce a score that the engine uses to rank and select the next track.
 */
public interface ScoringStrategy {

    /**
     * Scores a candidate track in the context of an active session.
     *
     * @param candidate the track being evaluated
     * @param session   the active DJ session providing context (mood, history, rules)
     * @return a relevance score; higher is better
     */
    double score(Track candidate, DjSession session);
}

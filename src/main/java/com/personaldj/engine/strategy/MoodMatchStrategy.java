package com.personaldj.engine.strategy;

import com.personaldj.domain.entity.AudioFeatures;
import com.personaldj.domain.entity.DjSession;
import com.personaldj.domain.entity.Track;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
  scores tracks based on how closely their valence matches the session mood
  valence is Spotify's measure of musical positivity, 0.0 is dark/sad, 1.0 is happy
 */
@Component
public class MoodMatchStrategy implements ScoringStrategy {

    // maps mood strings to a target valence value in [0.0, 1.0]
    private static final Map<String, Double> MOOD_TARGETS = Map.of(
        "happy",     0.85,
        "euphoric",  1.0,
        "chill",     0.55,
        "neutral",   0.5,
        "melancholy",0.3,
        "sad",       0.15,
        "angry",     0.2,
        "energetic", 0.75
    );

    private static final double DEFAULT_TARGET = 0.5;

    @Override
    public double score(Track candidate, DjSession session) {
        AudioFeatures features = candidate.getAudioFeatures();
        if (features == null) {
            return 0.0; 
        }

        double target = resolveTarget(session.getMood());
        return 1.0 - Math.abs(features.getValence() - target);
    }

    private double resolveTarget(String mood) {
        if (mood == null) return DEFAULT_TARGET;
        return MOOD_TARGETS.getOrDefault(mood.toLowerCase(), DEFAULT_TARGET);
    }
}
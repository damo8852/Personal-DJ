package com.personaldj.engine.strategy;

import com.personaldj.domain.entity.AudioFeatures;
import com.personaldj.domain.entity.DjSession;
import com.personaldj.domain.entity.Track;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * scores tracks based on how closely their energy matches the session mood
 * energy is Spotify's perceptual measure of intensity and activity, 0.0 is quiet/calm, 1.0 is loud/fast/noisy
 */
@Component
public class EnergyMatchStrategy implements ScoringStrategy {

    // maps mood strings to a target energy value in [0.0, 1.0]
    private static final Map<String, Double> ENERGY_TARGETS = Map.of(
        "happy",     0.75,
        "euphoric",  0.95,
        "chill",     0.35,
        "neutral",   0.5,
        "melancholy",0.25,
        "sad",       0.2,
        "angry",     0.9,
        "energetic", 0.95
    );

    private static final double DEFAULT_TARGET = 0.5;

    @Override
    public double score(Track candidate, DjSession session) {
        AudioFeatures features = candidate.getAudioFeatures();
        if (features == null) {
            return 0.0;
        }

        double target = resolveTarget(session.getMood());
        return 1.0 - Math.abs(features.getEnergy() - target);
    }

    private double resolveTarget(String mood) {
        if (mood == null) return DEFAULT_TARGET;
        return ENERGY_TARGETS.getOrDefault(mood.toLowerCase(), DEFAULT_TARGET);
    }
}
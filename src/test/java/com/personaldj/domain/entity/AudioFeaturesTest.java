package com.personaldj.domain.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class AudioFeaturesTest {

    @Test
    public void testDefaultValues() {
        AudioFeatures features = new AudioFeatures();

        assertEquals(0.0, features.getEnergy());
        assertEquals(0.0, features.getValence());
        assertEquals(0.0, features.getDanceability());
        assertEquals(0.0, features.getTempo());
        assertEquals(0.0, features.getAcousticness());
    }

    @Test
    public void testSetAndGetEnergy() {
        AudioFeatures features = new AudioFeatures();
        features.setEnergy(0.8);

        assertEquals(0.8, features.getEnergy());
    }

    @Test
    public void testSetAndGetValence() {
        AudioFeatures features = new AudioFeatures();
        features.setValence(0.6);

        assertEquals(0.6, features.getValence());
    }

    @Test
    public void testSetAndGetDanceability() {
        AudioFeatures features = new AudioFeatures();
        features.setDanceability(0.75);

        assertEquals(0.75, features.getDanceability());
    }

    @Test
    public void testSetAndGetTempo() {
        AudioFeatures features = new AudioFeatures();
        features.setTempo(128.0);

        assertEquals(128.0, features.getTempo());
    }

    @Test
    public void testSetAndGetAcousticness() {
        AudioFeatures features = new AudioFeatures();
        features.setAcousticness(0.3);

        assertEquals(0.3, features.getAcousticness());
    }

    @Test
    public void testSetAndGetTrack() {
        AudioFeatures features = new AudioFeatures();
        Track track = new Track();
        features.setTrack(track);

        assertEquals(track, features.getTrack());
    }
}

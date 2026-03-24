package com.personaldj.domain.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

public class TrackTest {

    @Test
    public void testSetAndGetSpotifyId() {
        Track track = new Track();
        track.setSpotifyId("abc123");

        assertEquals("abc123", track.getSpotifyId());
    }

    @Test
    public void testSetAndGetTitle() {
        Track track = new Track();
        track.setTitle("Bohemian Rhapsody");

        assertEquals("Bohemian Rhapsody", track.getTitle());
    }

    @Test
    public void testSetAndGetArtist() {
        Track track = new Track();
        track.setArtist("Queen");

        assertEquals("Queen", track.getArtist());
    }

    @Test
    public void testSetAndGetAlbum() {
        Track track = new Track();
        track.setAlbum("A Night at the Opera");

        assertEquals("A Night at the Opera", track.getAlbum());
    }

    @Test
    public void testSetAndGetDurationMs() {
        Track track = new Track();
        track.setDurationMs(354000);

        assertEquals(354000, track.getDurationMs());
    }

    @Test
    public void testSetAndGetAudioFeatures() {
        Track track = new Track();
        AudioFeatures features = new AudioFeatures();
        track.setAudioFeatures(features);

        assertEquals(features, track.getAudioFeatures());
    }

    @Test
    public void testIdIsNullBeforePersist() {
        Track track = new Track();

        assertNull(track.getId());
    }
}

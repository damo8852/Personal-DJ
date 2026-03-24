package com.personaldj.domain.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class PlaylistTest {

    @Test
    public void testSetAndGetName() {
        Playlist playlist = new Playlist();
        playlist.setName("My Playlist");

        assertEquals("My Playlist", playlist.getName());
    }

    @Test
    public void testSetAndGetDescription() {
        Playlist playlist = new Playlist();
        playlist.setDescription("A chill playlist");

        assertEquals("A chill playlist", playlist.getDescription());
    }

    @Test
    public void testSetAndGetUser() {
        Playlist playlist = new Playlist();
        User user = new User();
        playlist.setUser(user);

        assertEquals(user, playlist.getUser());
    }

    @Test
    public void testTracksInitializedEmpty() {
        Playlist playlist = new Playlist();

        assertNotNull(playlist.getTracks());
        assertTrue(playlist.getTracks().isEmpty());
    }

    @Test
    public void testIdIsNullBeforePersist() {
        Playlist playlist = new Playlist();

        assertNull(playlist.getId());
    }
}

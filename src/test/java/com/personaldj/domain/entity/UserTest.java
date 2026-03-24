package com.personaldj.domain.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    public void testSetAndGetUsername() {
        User user = new User();
        user.setUsername("john");

        assertEquals("john", user.getUsername());
    }

    @Test
    public void testSetAndGetEmail() {
        User user = new User();
        user.setEmail("john@example.com");

        assertEquals("john@example.com", user.getEmail());
    }

    @Test
    public void testSetAndGetPasswordHash() {
        User user = new User();
        user.setPasswordHash("hashed_password");

        assertEquals("hashed_password", user.getPasswordHash());
    }

    @Test
    public void testSessionsInitializedEmpty() {
        User user = new User();

        assertNotNull(user.getSessions());
        assertTrue(user.getSessions().isEmpty());
    }

    @Test
    public void testPlaylistsInitializedEmpty() {
        User user = new User();

        assertNotNull(user.getPlaylists());
        assertTrue(user.getPlaylists().isEmpty());
    }

    @Test
    public void testIdIsNullBeforePersist() {
        User user = new User();

        assertNull(user.getId());
    }

    @Test
    public void testSetAndGetId() {
        User user = new User();
        user.setId(42L);

        assertEquals(42L, user.getId());
    }
}

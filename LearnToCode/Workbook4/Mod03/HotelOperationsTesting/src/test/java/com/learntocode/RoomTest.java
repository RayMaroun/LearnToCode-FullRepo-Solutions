package com.learntocode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    @Test
    public void checkIn_shouldOccupiedAndDirty() {
        // Arrange
        Room room = new Room(2, 100.0);

        // Act
        room.checkIn();

        // Assert
        assertTrue(room.isOccupied());
        assertTrue(room.isDirty());
    }

    @Test
    public void checkout_shouldNotOccupied() {
        // Arrange
        Room room = new Room(1, 50.0);
        room.checkIn();

        // Act
        room.checkout();

        // Assert
        assertFalse(room.isOccupied());
    }

    @Test
    public void checkIn_shouldNotBeforeCleaned() {
        // Arrange
        Room room = new Room(2, 100.0);
        room.checkIn();
        room.checkout();

        // Act
        room.checkIn();

        // Assert
        assertFalse(room.isOccupied());
    }

    @Test
    public void cleanRoom_shouldNotIfOccupied() {
        // Arrange
        Room room = new Room(2, 100.0);
        room.checkIn();

        // Act
        room.cleanRoom();

        // Assert
        assertTrue(room.isOccupied());
        assertTrue(room.isDirty());
    }

    @Test
    public void cleanRoom_shouldNotBeDirty() {
        // Arrange
        Room room = new Room(1, 50.0);
        room.checkIn();
        room.checkout();

        // Act
        room.cleanRoom();

        // Assert
        assertFalse(room.isDirty());
    }


}
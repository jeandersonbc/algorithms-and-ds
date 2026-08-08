package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FixedSizeQueueTest extends QueueTest {
    @BeforeEach
    void setup() {
        queue = new FixedSizeQueue<>(10);
    }

    @Test
    void enqueueReturnsFalseAtCapacity() {
        // given
        assertTrue(queue.isEmpty());

        // when
        for (int c = 0; c < queue.capacity(); c++) {
            assertTrue(queue.enqueue(1));
        }
        assertEquals(queue.capacity(), queue.size());

        // then
        assertFalse(queue.enqueue(123));
    }

    @Test
    void failsToInitializeInvalidCapacity() {
        assertThrows(IllegalArgumentException.class, () -> new FixedSizeQueue<>(-1));
    }

    @Test
    void allowsZeroCapacity() {
        assertDoesNotThrow(() -> new FixedSizeQueue<>(0));
    }
}

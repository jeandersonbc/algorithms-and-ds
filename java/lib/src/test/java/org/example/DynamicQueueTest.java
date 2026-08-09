package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DynamicQueueTest extends QueueTest {
    @BeforeEach
    public void setUp() {
        queue = new DynamicQueue<>(10);
    }
    @Test
    void failsToInitializeInvalidCapacity() {
        assertThrows(IllegalArgumentException.class, () -> new DynamicQueue<>(-1));
    }

    @Test
    void allowsZeroCapacity() {
        assertDoesNotThrow(() -> new DynamicQueue<>(0));
    }

    @Test
    void shouldDoubleCapacityWhenTooManyEnqueues() {
        for (int trial = 0; trial < 3; trial++) {
            // given
            int capacity = queue.capacity();

            // when
            fillQueue(capacity);

            // then
            assertEquals(capacity * 2, queue.capacity());
        }
    }

    @Test
    void shouldHalveCapacityWhenTooManyDequeues() {
        throw new RuntimeException("Not implemented yet");
    }

    void fillQueue(int n) {
        for (int i = 0; i < n; i++) {
            queue.enqueue(i);
        }
    }
}

package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DynamicQueueTest extends QueueTest {
    @BeforeEach
    public void setUp() {
        // 32 because we are halving/doubling, and it's convenient to use a multiple of 2
        queue = new DynamicQueue<>(32);
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
        for (int trial = 0; trial < 10; trial++) {
            // given
            int prevCapacity = queue.capacity();

            // when filling up to capacity
            fillQueue(prevCapacity - queue.size());

            // then
            assertEquals(prevCapacity * 2, queue.capacity());
            assertEquals(queue.size(), queue.capacity() / 2);
        }
    }

    @Test
    void shouldHalveCapacityWhenTooManyDequeues() {
        // given queue at 25% of capacity (prefill)
        int prevCapacity = queue.capacity();
        fillQueue(queue.capacity() / 4);

        for (int trial = 0; trial < 5; trial++) {
            // when enough removals happened
            while (queue.size() >= prevCapacity * 0.25) {
                queue.dequeue();
            }
            // then
            assertEquals(prevCapacity / 2, queue.capacity());
        }
    }

    void fillQueue(int n) {
        for (int i = 0; i < n; i++) {
            queue.enqueue(i);
        }
    }
}

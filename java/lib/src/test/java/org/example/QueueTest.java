package org.example;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;

abstract class QueueTest {

    protected Queue<Integer> queue;

    @Test
    void peekAlwaysPointToTheFrontAfterManyEnqueues() {
        // given
        assertTrue(queue.isEmpty());

        // when
        int element = 1;
        int total = queue.capacity();
        for (int trials = total; trials > 0; trials--) {
            assertTrue(queue.enqueue(element++));

            // then
            assertEquals(1, queue.peek());
        }
        assertFalse(queue.isEmpty());
        assertEquals(total, queue.size());
    }

    @Test
    void peekAlwaysPointToTheFrontAfterManyDequeues() {
        // given
        assertTrue(queue.isEmpty());

        // when
        int element = 1;
        for (int trials = queue.capacity(); trials > 0; trials--) {
            assertTrue(queue.enqueue(element));

            // then
            assertEquals(element, queue.peek());
            assertEquals(element, queue.dequeue());
            element++;
        }
        assertTrue(queue.isEmpty());
    }

    @Test
    void failsToPeekEmptyQueue() {
        assertTrue(queue.isEmpty());
        assertThrows(NoSuchElementException.class, queue::peek);
    }

    @Test
    void failsToDequeEmptyQueue() {
        assertTrue(queue.isEmpty());
        assertThrows(NoSuchElementException.class, queue::dequeue);
    }
}

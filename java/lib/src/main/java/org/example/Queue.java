package org.example;

import java.util.NoSuchElementException;

/**
 * A sequential data structure with First-In-First-Out (FIFO) policy.
 *
 * @param <T> the type of the elements to be hold
 */
public interface Queue<T> {

    /**
     * Adds an element at the end of the queue (FIFO policy).
     *
     * @param element The element to be added
     * @return <code>true</code> if the element was added to the queue.
     * The element might be rejected (i.e., <code>false</code>) if the concrete class is at full capacity (resizing not supported).
     * @throws NullPointerException if element is null.
     */
    boolean enqueue(T element) throws NullPointerException;

    /**
     * Removes front element from the queue (FIFO policy).
     *
     * @return the next element from the queue
     * @throws NoSuchElementException if attempting to dequeue from an empty Queue.
     */
    T dequeue() throws NoSuchElementException;

    /**
     * Retrieves the next element (front) from the Queue.
     *
     * @return the next element from the queue
     * @throws NoSuchElementException if attempting to peek an empty Queue.
     */
    T peek() throws NoSuchElementException;

    /**
     * Indicates the number of elements in this queue.
     *
     * @return the size of the queue
     */
    int size();

    /**
     * A helper to indicate current capacity of this Queue.
     *
     * @return the maximum number of elements this Queue can hold.
     */
    int capacity();

    /**
     * Checks if this queue is empty.
     *
     * @return <code>true</code> if this queue is empty
     */
    boolean isEmpty();
}

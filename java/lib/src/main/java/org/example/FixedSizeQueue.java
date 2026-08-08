package org.example;

import java.util.NoSuchElementException;

public class FixedSizeQueue<T> implements Queue<T> {

    private final Object[] elements;

    // keeps track of the rear and front position
    private int rear;
    private int front;

    // keeps track of the elements added
    private int count;

    /**
     * Initializes a fixed size queue.
     *
     * @param capacity The maximum numbers this Queue can hold
     * @throws IllegalArgumentException if capacity is less than zero
     */
    public FixedSizeQueue(int capacity) throws IllegalArgumentException {
        if (capacity < 0) {
            throw new IllegalArgumentException("capacity must be greater than zero");
        }
        this.elements = new Object[capacity];
        this.front = 0;
        this.rear = 0;
        this.count = 0;
    }

    @Override
    public boolean enqueue(T element) throws NullPointerException {
        if (size() == capacity()) {
            return false;
        }
        this.elements[rear] = element;

        // make it circular for better memory usage
        this.rear = (rear + 1) % capacity();
        this.count++;
        return true;
    }

    @SuppressWarnings("unchecked") // only objects  of type T are added to elements
    @Override
    public T dequeue() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T element = (T) elements[front];
        elements[front] = null;
        // make it circular for better memory usage
        this.front = (front + 1) % capacity();
        this.count--;
        return element;
    }

    @SuppressWarnings("unchecked") // because the underlying array is guaranteed to hold only elements of type T
    @Override
    public T peek() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return (T) this.elements[front];
    }

    @Override
    public int size() {
        return this.count;
    }

    @Override
    public int capacity() {
        return this.elements.length;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
}

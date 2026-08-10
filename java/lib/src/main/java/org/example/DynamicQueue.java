package org.example;

import java.util.NoSuchElementException;

public class DynamicQueue<T> implements Queue<T> {

    private Object[] elements;
    private int front;
    private int rear;
    private int count;

    public DynamicQueue(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException();
        }
        this.elements = new Object[capacity];
        this.front = 0;
        this.rear = 0;
        this.count = 0;
    }

    @Override
    public boolean enqueue(T element) throws NullPointerException {
        if (element == null) {
            throw new NullPointerException();
        }
        if (size() >= capacity() * 0.75) {
            Object[] newElements = new Object[capacity() * 2];
            System.arraycopy(elements, 0, newElements, 0, size());
            elements = newElements;
        }
        this.elements[rear] = element;
        rear = (rear + 1) % capacity();
        count++;

        return true;
    }

    @SuppressWarnings("unchecked") // guaranteed to hold only elements of T
    @Override
    public T dequeue() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (size() <= capacity() * 0.25) {
            Object[] newElements = new Object[capacity() / 2];
            System.arraycopy(elements, 0, newElements, 0, size());
            elements = newElements;
        }
        T element = (T) elements[front];
        elements[front] = null;
        count--;
        front = (front + 1) % capacity();

        return element;
    }

    @SuppressWarnings("unchecked") // guaranteed to hold only elements of type T
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

package com.bandtec.mais.consulta.models;

import java.util.Arrays;
import java.util.List;

public class QueueObj<T> {

    private int size;
    private T[] queue;
    private int capacity;

    public QueueObj(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.queue = (T[]) new Object[capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private boolean isFull() {
        return size == capacity;
    }

    public void insert(T element) {
        if (isFull()) {
            System.out.println("Queue is full");
        }
        queue[size] = element;
        size++;
    }

    public T peek() {
        return queue[0];
    }

    // remove primeiro elemento e desloca fila
    public T poll() {

        // armazena elemento que sera removido
        T element = peek();

        if (!isEmpty()) {

            moveQueue();

            // torna ultimo elemento null
            queue[size - 1] = null;

            // decrementa tamanho
            size--;
        }

        return element;
    }

    public void addList(List<T> list) {
        if (isFull()) {
            System.out.println("Queue is full");
        }
        if (list.size() < (capacity - size))
            list.forEach(it -> {
                queue[size] = it;
                size++;
            });
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Empty queue");
        }

        for (int i = 0; i < size; i++) {
            System.out.println(queue[i]);
        }

    }

    // desloca fica removendo o primeiro elemento
    private void moveQueue() {
        for (int i = 0; i < size - 1; i++) {
            queue[i] = queue[i + 1];
        }
    }

    @Override
    public String toString() {
        return "FilaObj{" +
                "tamanho=" + size +
                ", fila=" + Arrays.toString(queue) +
                ", capacidade=" + capacity +
                '}';
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public T[] getQueue() {
        return queue;
    }

    public void setQueue(T[] queue) {
        this.queue = queue;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
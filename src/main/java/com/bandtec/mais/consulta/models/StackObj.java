package com.bandtec.mais.consulta.models;

public class StackObj<T> {

    private final T[] stack;
    private int top;
    private final int capacity;

    public StackObj(int capacity) {
        stack = (T[]) new Object[capacity];
        top = -1;
        this.capacity = capacity;
    }

    public Boolean isEmpty() {
        return top == -1;
    }

    public Boolean isFull() {
        return top == stack.length - 1;
    }

    public void push(T element) {
        if (isFull()) {
            System.out.println("Stack is full!");
        } else {
            stack[++top] = element;
        }
    }

    public void multiPush(StackObj<T> stackObj) {

        for (int i = 0; i < stackObj.capacity; i++) {
            push(stackObj.pop());
        }

    }

    public T pop() {
        if (isEmpty()) {
            return null;
        }
        return stack[top--];
    }

    public StackObj<T> multiPop() {

        StackObj<T> newStack = new StackObj<>(capacity);

        for (int i = 0; i < capacity; i++) {
            newStack.push(this.pop());
        }

        return newStack;
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return stack[top];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Empty Stack");
        } else {
            for (int i = top; i >= 0; i--) {
                System.out.println(stack[i]);
            }
        }
    }
}


package com.bandtec.mais.consulta.models;

import java.util.Arrays;

public class PilhaObj<T> {

    private final T[] pilha;
    private int topo;
    private final int capacidade;

    public PilhaObj(int capacidade) {
        pilha = (T[]) new Object[capacidade];
        topo = -1;
        this.capacidade = capacidade;
    }

    public Boolean isEmpty() {
        return topo == -1;
    }

    public Boolean isFull() {
        return topo == pilha.length - 1;
    }

    public void push(T elemento) {
        if (isFull()) {
            System.out.println("Pilha cheia!");
        } else {
            pilha[++topo] = elemento;
        }
    }

    public void multiPush(PilhaObj<T> pilhaObj) {

        for (int i = 0; i < pilhaObj.capacidade; i++) {
            push(pilhaObj.pop());
        }

    }

    public T pop() {
        if (isEmpty()) {
            return null;
        }
        return pilha[topo--];
    }

    public PilhaObj<T> multiPop() {

        PilhaObj<T> novaPilha = new PilhaObj<>(capacidade);

        for (int i = 0; i < capacidade; i++) {
            novaPilha.push(this.pop());
        }

        return novaPilha;
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return pilha[topo];
    }

    public void exibe() {
        if (isEmpty()) {
            System.out.println("Pilha vazia");
        } else {
            for (int i = topo; i >= 0; i--) {
                System.out.println(pilha[i]);
            }
        }
    }
}


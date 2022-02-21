package com.bandtec.mais.consulta.models;

import java.util.Arrays;
import java.util.List;

public class FilaObj<T> {

    private int tamanho;
    private T[] fila;
    private int capacidade;

    public FilaObj(int capacidade) {
        this.tamanho = 0;
        this.capacidade = capacidade;
        this.fila = (T[]) new Object[capacidade];
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }

    private boolean isFull() {
        return tamanho == capacidade;
    }

    public void insert(T elemento) {
        if (isFull()) {
            System.out.println("Fila esta cheia");
        }
        fila[tamanho] = elemento;
        tamanho++;
    }

    public T peek() {
        return fila[0];
    }

    // remove primeiro elemento e desloca fila
    public T poll() {

        // armazena elemento que sera removido
        T elemento = peek();

        if (!isEmpty()) {

            deslocaFila();

            // torna ultimo elemento null
            fila[tamanho - 1] = null;

            // decrementa tamanho
            tamanho--;
        }

        return elemento;
    }

    public void addList(List<T> list) {
        if (isFull()) {
            System.out.println("Fila esta cheia");
        }
        if (list.size() < (capacidade - tamanho))
        list.forEach(it -> {
            fila[tamanho] = it;
            tamanho++;
        });
    }

    public void exibe(){
        if (isEmpty()){
            System.out.println("Fila vazia");
        }

        for (int i = 0; i < tamanho; i++){
            System.out.println(fila[i]);
        }

    }

    // desloca fica removendo o primeiro elemento
    private void deslocaFila() {
        for (int i = 0; i < tamanho - 1; i++) {
            fila[i] = fila[i + 1];
        }
    }

    @Override
    public String toString() {
        return "FilaObj{" +
                "tamanho=" + tamanho +
                ", fila=" + Arrays.toString(fila) +
                ", capacidade=" + capacidade +
                '}';
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public T[] getFila() {
        return fila;
    }

    public void setFila(T[] fila) {
        this.fila = fila;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }
}
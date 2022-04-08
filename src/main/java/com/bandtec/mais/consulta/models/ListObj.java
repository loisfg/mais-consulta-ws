package com.bandtec.mais.consulta.models;

public class ListObj<T> {
    // Atributos
    private T[] vector;    // vetor onde será armazenado os elementos da lista
    private int elementNumber;    // representa a quantidade de elementos da lista e tb
    // o índice do vetor onde será colocado o próximo elemento

    // Construtor
    // Recebe o tamanho máximo da lista
    public ListObj(int size) {
        vector = (T[]) new Object[size];    // Cria o vetor com o tamanho máximo recebido
        elementNumber = 0;             // Zera o número de elementos
    }

    // Métodos

    // Método adiciona - recebe o valor a ser inserido na lista
    public boolean add(T value) {
        if (elementNumber >= vector.length) {          // Verifica se a lista está cheia
            System.out.println("List is full");
            return false;
        } else {
            vector[elementNumber++] = value;           // Se não está, coloca o valor no vetor,
            // na posição nroElem e incrementa nroElem
            return true;
        }
    }

    // Método exibe - exibe os elementos da lista
    public void display() {
        System.out.println("\nDisplaying list elements:");
        for (int i = 0; i < elementNumber; i++) {        // Percorre enquanto i < nroElem
            System.out.println(vector[i]);
        }
        System.out.println();
    }

    // Método busca - recebe um valor e verifica se esse valor está na lista
    // Se estiver, retorna o índice onde ele se encontra, senão retorna -1
    public int search(T value) {
        for (int i = 0; i < elementNumber; i++) {   // Percorre o vetor enquanto i < nroElem
            if (vector[i].equals(value)) {        // Se elemento do vetor é o valor procurado
                return i;                   // então retorna seu índice
            }
        }
        return -1;          // se percorreu o vetor inteiro e não encontrou, retorna -1
    }

    // Método removePeloIndice - recebe o índice do valor a ser removido
    public boolean removeByIndex(int index) {
        if (index < 0 || index >= elementNumber) {  // se índice for inválido
            return false;                       // retorna false
        } else {
            // Percorre o vetor a partir do indice recebido, sobrescrevendo
            // os valores
            for (int i = index; i < elementNumber - 1; i++) {
                vector[i] = vector[i + 1];
            }
            /* outra forma de fazer
            for (int i=indice+1; i < nroElem; i++) {
                vetor[i-1] = vetor[i];
            } */
            elementNumber--;      // decrementa nroElem
            return true;    // retorna true
        }
    }

    public void addAtTop(T value) {

        if (elementNumber <= vector.length) {
            int aux = elementNumber;

            for (int index = aux; index >= elementNumber; index--) {
                vector[elementNumber] = vector[elementNumber - index];
            }
            vector[0] = value;
            elementNumber++;
        }
    }

    public boolean removeElement(T value) {
        return removeByIndex(search(value));
    }

    public T[] getElement() {
        return vector;
    }

    public T getElement(int index) {
        if (index < 0 || index >= elementNumber) {  // se índice for inválido
            return null;                       // retorna false
        } else {
            return vector[index];
        }
    }

    public void clean() {
        elementNumber = 0;
    }

    public boolean isEmpty() {
        return elementNumber == 0;
    }
}

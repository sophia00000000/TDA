/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab1_listaenlazada;

/**
 *
 * @author laura
 * @param <T>
 */

public class Lista<T> {
  private Nodo inicio;
  private int elemento; //numero de elementos en la lista

  // constructor
  public Lista() {
    inicio = null;
    elemento = 0;
  }

  public boolean esVacia() {
    return inicio == null;
  }

  // Devuelve el size de la lista
  public int getElemento() {
    return elemento;
  }
  
  public Nodo getInicio(){
    return inicio;
  }
  
  public void agregarAlFinal(T dato) {
    // valor del nuevo nodo que se quiere agregar
    Nodo nuevo = new Nodo();
    nuevo.setDato(dato);
    // si esta vacía, el nuevo nodo es de inicio
    if (esVacia()) {
      inicio = nuevo;
    }
    // se recorre la lista hasta q el nodo sea null, luego agrega el nuevo nodo
    else {
      Nodo auxiliar = inicio;
      while (auxiliar.getSiguiente() != null) {
        auxiliar = auxiliar.getSiguiente();
      }
      auxiliar.setSiguiente(nuevo);
    }
    elemento++;
  }

  public void agregarAlInicio(T dato) {
    Nodo nuevo = new Nodo(); // Se crea un nuevo nodo
    nuevo.setDato(dato); // Se asigna el dato al nodo

    if (esVacia()) {
      inicio = nuevo; // Si la lista está vacía, el nuevo nodo es el inicio
    } else {
      nuevo.setSiguiente(inicio); // El nuevo nodo apunta al inicio actual
      inicio = nuevo; // El nuevo nodo se convierte en el inicio de la lista
    }
    elemento++; // Se incrementa el contador de elementos
  }

  // Agrega un nodo en un índice específico
  public void agregarEnIndice(int indice, T dato) {
    if (indice < 0 || indice > elemento) {
      throw new IndexOutOfBoundsException("Índice fuera de rango");
    }

    if (indice == 0) { // Si el índice es 0, el nuevo nodo se coloca al inicio
      agregarAlInicio(dato);
    }
    Nodo nuevo = new Nodo();
    nuevo.setDato(dato);
    Nodo actual= inicio;
    int i=0;
    while(actual!=null && i<indice-1){
        actual= actual.siguiente;
        i++;
    }
    if(actual==null){
        System.out.println("Posicion invalida");
    }else{
        nuevo.siguiente =actual.siguiente;
        actual.siguiente = nuevo;
    }
    elemento++;
  }
  
  public T buscaPorIndice(int indice){
    if (indice < 0 || indice >= elemento) {
      throw new IndexOutOfBoundsException("Índice fuera de rango");
    }

    if (indice == 0) { // Si el índice es 0 se devuelve el del inicio
      return (T)inicio.getDato();
    }
    else{
        Nodo actual= inicio;
        int i=0;
        while( i<indice){
            actual= actual.siguiente;
            i++;
        }
        return (T)actual.getDato();
    }
  }


  // Devuelve el dato del primer nodo de la lista
  public T obtenerPrimero() {
    if (esVacia()) {
      return null;
    }
    return (T) inicio.getDato(); // Cast de Nodo a T
  }

  // Devuelve el dato del último nodo de la lista
  public T obtenerUltimo() {
      if (esVacia()) {
          return null;
      }
      Nodo auxiliar = inicio; // Nodo auxiliar para recorrer la lista

      while (auxiliar.getSiguiente() != null) {
          auxiliar = auxiliar.getSiguiente(); // Se recorre la lista hasta el último nodo
      }
      return (T) auxiliar.getDato();  // Cast de Nodo a T
  }

  // Actualiza el dato de un nodo en un índice específico
  public void actualizarNodo(int indice, T dato) {
      if (indice < 0 || indice >= elemento) {
          throw new IndexOutOfBoundsException("Índice fuera de rango");
      }

      Nodo auxiliar = inicio; // Nodo auxiliar para recorrer la lista

      for (int i = 0; i < indice; i++) {
          auxiliar = auxiliar.getSiguiente(); // Se recorre la lista hasta encontrar el nodo
      }
      auxiliar.setDato(dato); // Se actualiza el dato del nodo
  }

  // Borra el nodo en un índice específico
  public void borrarEnIndice(int indice) {
      if (indice < 0 || indice >= elemento) {
          throw new IndexOutOfBoundsException("Índice fuera de rango");
      }

      if (indice == 0) {
          inicio = inicio.getSiguiente(); // Si es el primer nodo, se actualiza el inicio
      } else {
          Nodo auxiliar = inicio; // Nodo auxiliar para recorrer la lista

          for (int i = 0; i < indice - 1; i++) {
              auxiliar = auxiliar.getSiguiente(); // Se recorre la lista hasta el nodo anterior al que se va a borrar
          }
          auxiliar.setSiguiente(auxiliar.getSiguiente().getSiguiente()); // Se elimina el nodo actualizando el enlace
      }
      elemento--; // Se decrementa el contador de elementos
  }


  // Borra un nodo que contiene un dato específico
  public void borrarNodo(T dato) {
      if (esVacia()) {
          return;
      }

      if (inicio.getDato().equals(dato)) {
          inicio = inicio.getSiguiente(); // Si el dato está en el primer nodo, se actualiza el inicio
          elemento--;
          return;
      }

      Nodo auxiliar = inicio; // Nodo auxiliar para recorrer la lista

      while (auxiliar.getSiguiente() != null && !auxiliar.getSiguiente().getDato().equals(dato)) {
          auxiliar = auxiliar.getSiguiente(); // Se recorre la lista buscando el nodo con el dato
      }

      if (auxiliar.getSiguiente() != null) {
          auxiliar.setSiguiente(auxiliar.getSiguiente().getSiguiente()); // Se elimina el nodo actualizando el enlace
          elemento--;
      }
  }
  
  
  // Muestra todos los nodos de la lista
  public void mostrar() {
      if (esVacia()) {
          System.out.println("La lista está vacía.");
      }
      Nodo actual = inicio; // Nodo auxiliar para recorrer la lista
      while (actual != null) {
          System.out.print("[" + actual.getDato() + "]"); // Se imprime el dato de cada nodo
          actual = actual.getSiguiente(); // Se pasa al siguiente nodo
      }
      System.out.println();
  }

}
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
public class Nodo<T>{
  T dato;
  Nodo siguiente;

  public Nodo(){
    dato= null;
    siguiente= null;
  }
    public T getDato() {
            return dato;
    }
    public void setDato(T dato) {
            this.dato = dato;
    }
    public Nodo getSiguiente() {
            return siguiente;
    }
    public void setSiguiente(Nodo siguiente) {
            this.siguiente = siguiente;
    }  
}
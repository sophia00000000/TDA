/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab1_listaenlazada;

/**
 *
 * @author laura
 */
public class ListaContigua {
  int[] lista;
  int tamaño;
  int capacidad;

  // Constructor
  public ListaContigua() {
      this.capacidad = 1000;
      this.lista = new int[capacidad];
      this.tamaño = 0;
  }

  // 1. Verificar si la lista está vacía
  public boolean estaVacia() {
      return tamaño == 0;
  }

  // 2. Devolver el número de elementos en la lista
  public int obtenerTamaño() {
      return tamaño;
  }

  // 3. Insertar un elemento al final de la lista
  public void insertarFinal(int dato) {
      if (tamaño == capacidad) {
          System.out.println("La lista está llena. No se puede insertar más elementos.");
      } else {
          lista[tamaño] = dato;
          tamaño++;
      }
  }

  // 4. Borrar un elemento al final de la lista
  public void eliminarFinal() {
      if (estaVacia()) {
          System.out.println("La lista está vacía. No hay elementos para eliminar.");
      } else {
          tamaño--;
      }
  }

  // 5. Mostrar los datos de la lista
  public void mostrarLista() {
      if (estaVacia()) {
          System.out.println("La lista está vacía.");
      } else {
          for (int i = 0; i < tamaño; i++) {
              System.out.print(lista[i] + " ");
          }
          System.out.println();
      }
  }
}

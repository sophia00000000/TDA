/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab1_listaenlazada;

/**
 *
 * @author laura
 */
public class Ejer4 {
    public static void ejecutar() {

        ListaEncadenada lista = new ListaEncadenada();
         // Verificar si la lista está vacía
        System.out.println("¿La lista está vacía?: " + lista.estaVacia());

         // Insertar elementos en la lista
        lista.insertarFinal(10);
        lista.insertarFinal(20);
        lista.insertarFinal(30);
        lista.mostrarLista();  // Debería imprimir: 10 20 30

         // Obtener el tamaño de la lista
        System.out.println("Número de elementos en la lista: " + lista.obtenerTamaño());

         // Eliminar el último elemento
        lista.eliminarFinal();
        lista.mostrarLista();  // Debería imprimir: 10 20

         // Insertar más elementos
        lista.insertarFinal(40);
        lista.insertarFinal(50);
        lista.insertarFinal(60);  // No se debe poder insertar, la lista está llena
        lista.mostrarLista();  // Debería imprimir: 10 20 40 50

         // Eliminar más elementos
        lista.eliminarFinal();
        lista.eliminarFinal();
        lista.mostrarLista();  // Debería imprimir: 10 20
    }
}

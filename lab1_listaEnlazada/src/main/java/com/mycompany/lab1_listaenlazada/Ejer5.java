/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab1_listaenlazada;

import static com.mycompany.lab1_listaenlazada.Ejer3.insertarOrdenado;
import static com.mycompany.lab1_listaenlazada.Ejer3.listaNumeros;

/**
 *
 * @author laura
 */
public class Ejer5 {
    static Lista<Integer> listaNumeros1;
    static Lista<Integer> listaNumeros2;
    static ListaEncadenada listaNumeros3;
    static int tamanio1;
    static int tamanio2;
    
    public Ejer5() {
        listaNumeros1 = new Lista();
        listaNumeros2 = new Lista();
        listaNumeros3 = new ListaEncadenada();
        tamanio1=(int)(Math.random() * 21) + 10;
        tamanio2=(int)(Math.random()* 36) + 5;

    }
    
    
    
    public static void ejecutar(){
        llenarListas();
        System.out.println("Lista 1:");
        listaNumeros1.mostrar();

        System.out.println("Lista 2:");
        listaNumeros2.mostrar();
        
        System.out.println("Lista 3:");
        crearLista3(listaNumeros1, listaNumeros2, 0, listaNumeros3);
        listaNumeros2.mostrar();
    }
    
    
    public static void llenarListas(){
        tamanio1= (int)(Math.random() * 21) + 10;
        tamanio2= (int)(Math.random()* 36) + 5 ;

        llenarLista(listaNumeros1 , tamanio1);
        llenarLista(listaNumeros2, tamanio2);

        
    }
    
    public static void llenarLista(Lista<Integer> lista, int tamanio){
        for(int i=0; i< tamanio ; i++){
          int n=(int)(Math.random() * 501) + 50;
          insertarOrdenado(lista , n);
        }
    }
 
    
    public static void insertarOrdenado(Lista<Integer> lista, int n){
        if (lista.esVacia()){
            lista.agregarAlInicio(n);
        }else{
            int i=0;
            while (i < lista.getElemento() && lista.buscaPorIndice(i) <= n) {
                i++;
            }
            lista.agregarEnIndice(i, n);
        }
    }
    
    public ListaEncadenada crearLista3(Lista<Integer> lista1, Lista<Integer> lista2, int indice, ListaEncadenada lista3) {
        // Condición base: si se recorren ambas listas completamente
        if (indice >= lista1.obtenerTamaño() && indice >= lista2.obtenerTamaño()) {
            return lista3;
        }

        // Revisar la lista 1 para los números impares que no están en la lista 2
        if (indice < lista1.obtenerTamaño()) {
            int num1 = lista1.obtenerElemento(indice);
            if (num1 % 2 != 0 && !existeEnLista(num1, lista2)) {
                lista3.insertarFinal(num1); // Insertar en lista3 si es impar y no está en lista2
            }
        }

        // Revisar la lista 2 para los números pares que no están en la lista 1
        if (indice < lista2.obtenerTamaño()) {
            int num2 = lista2.obtenerElemento(indice);
            if (num2 % 2 == 0 && !existeEnLista(num2, lista1)) {
                lista3.insertarFinal(num2); // Insertar en lista3 si es par y no está en lista1
            }
        }

        // Llamada recursiva con el siguiente índice
        return crearLista3(lista1, lista2, indice + 1, lista3);
    }

    // Método auxiliar para verificar si un número está en la lista
    private boolean existeEnLista(int num, ListaEncadenada lista) {
        for (int i = 0; i < lista.obtenerTamaño(); i++) {
            if (lista.obtenerElemento(i) == num) {
                return true;
            }
        }
        return false;
    }
}

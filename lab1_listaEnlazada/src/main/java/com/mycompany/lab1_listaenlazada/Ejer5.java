/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab1_listaenlazada;

/**
 *
 * @author laura
 */
public class Ejer5 {
    static ListaContigua listaNumeros1;
    static ListaContigua listaNumeros2;
    static Lista<Integer> listaNumeros3;
    static int tamanio1;
    static int tamanio2;
    
    public Ejer5() {
        listaNumeros1 = new ListaContigua();
        listaNumeros2 = new ListaContigua();
        listaNumeros3 = new Lista();
        tamanio1=(int)(Math.random() * 21) + 10;
        tamanio2=(int)(Math.random()* 36) + 5;
    }
        
    
    public static void ejecutar(){
        llenarListas();
        System.out.println("Lista 1:");
        listaNumeros1.mostrarLista();

        System.out.println("Lista 2:");
        listaNumeros2.mostrarLista();
        
        System.out.println("Lista 3:");
        crearLista3(listaNumeros1, listaNumeros2, 0, listaNumeros3);
        listaNumeros3.mostrar();
    }
    
    
    public static void llenarListas(){
        tamanio1= (int)(Math.random() * 21) + 10;
        tamanio2= (int)(Math.random()* 36) + 5 ;

        llenarLista(listaNumeros1 , tamanio1);
        llenarLista(listaNumeros2, tamanio2);     
    }
    
    
    public static void llenarLista(ListaContigua lista, int tamanio){
        for(int i=0; i< tamanio ; i++){
          int n=(int)(Math.random() * 501) + 50;
          lista.insertarFinal(n);
        }
    }
 
    
    public static Lista<Integer> crearLista3(ListaContigua lista1, ListaContigua lista2, int indice, Lista<Integer> lista3) {
        // Condición base: si se recorren ambas listas completamente
        if (indice >= lista1.obtenerTamaño() && indice >= lista2.obtenerTamaño()) {
            return lista3;
        }

        // Revisar la lista 1 para los números impares que no están en la lista 2
        if (indice < lista1.obtenerTamaño()) {
            int num1 = lista1.lista[indice];
            if (num1 % 2 != 0 && !existeEnLista(num1, lista2)) {
                lista3.agregarAlFinal(num1); // Insertar en lista3 si es impar y no está en lista2
            }
        }

        // Revisar la lista 2 para los números pares que no están en la lista 1
        if (indice < lista2.obtenerTamaño()) {
            int num2 = lista2.lista[indice];
            if (num2 % 2 == 0 && !existeEnLista(num2, lista1)) {
                lista3.agregarAlFinal(num2); // Insertar en lista3 si es par y no está en lista1
            }
        }

        // Llamada recursiva con el siguiente índice
        return crearLista3(lista1, lista2, indice + 1, lista3);
    }

    // Método auxiliar para verificar si un número está en la lista
    private static boolean existeEnLista(int num, ListaContigua lista) {
        for (int i = 0; i < lista.obtenerTamaño(); i++) {
            if (lista.lista[i] == num) {
                return true;
            }
        }
        return false;
    }
}

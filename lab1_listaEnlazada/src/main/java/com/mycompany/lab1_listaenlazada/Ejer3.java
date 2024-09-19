/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab1_listaenlazada;

public class Ejer3 {
    static Lista<Integer> listaNumeros;
    
    public Ejer3(){
        listaNumeros = new Lista();
}

    
    public static void ejecutar(){
        llenarLista();
        System.out.println("Lista original:");
        System.out.println(listaNumeros.getElemento());
        listaNumeros.mostrar();
        procesarLista();
        System.out.println("Lista despues del procesamiento:");
        listaNumeros.mostrar();
    }
    public static void llenarLista(){
    for(int i=0; i<5; i++){
      int n= (int) (Math.random()*10);
      insertarOrdenado(n);
    }
  }
  
  public static void insertarOrdenado(int n){
    if (listaNumeros.esVacia()){
        listaNumeros.agregarAlInicio(n);
    }else{
        int i=0;
        while (i < listaNumeros.getElemento() && listaNumeros.buscaPorIndice(i) <= n) {
            i++;
        }
        listaNumeros.agregarEnIndice(i, n);
    }
  }
  
    public static int[] sumaParesImpares(){
        int sumPar=0;
        int sumImpar=0;
        for (int i=0;i<listaNumeros.getElemento();i++){
          if (i%2==0){
            sumPar+= listaNumeros.buscaPorIndice(i);
          }else{
            sumImpar+= listaNumeros.buscaPorIndice(i);
          }
        }
        return new int[] {sumPar,sumImpar};
    }
    static public void ceroEnPares() {
        int posicion = 0;  // Índice de la posición del nodo, comenzamos en 0 (para indexar pares e impares)

        for (int i = listaNumeros.getElemento() - 1; i >= 0; i--) {
            if (posicion % 2 == 0) {  // Si la posición es par
                listaNumeros.actualizarNodo(i,0); 
            }
            posicion++;
        }
    }
    
    static public void ceroEnImpares() {
        int posicion = 0;  // Índice de la posición del nodo, comenzamos en 0
    
 
        for (int i = listaNumeros.getElemento() - 1; i >= 0; i--) {
            if (posicion % 2 != 0) {  // Si la posición es impar
                listaNumeros.actualizarNodo(i,0); 
            }
            posicion++;
        }
    }   
    
    
    static public void procesarLista() {
        if (listaNumeros.esVacia()) {
            System.out.println("Lista vacía.");
            return;
        }

        if (listaNumeros.getElemento() == 1) {
            System.out.println("Lista con unico nodo.");
            return;
        }

        // Sumar los valores en posiciones pares e impares
        int[] sumas = sumaParesImpares();
        int sumaPares = sumas[0];
        int sumaImpares = sumas[1];

        System.out.println("Suma Pares: " + sumaPares);
        System.out.println("Suma Impares: " + sumaImpares);

        // Decidir en q posiciones se incertan ceros
        if (sumaPares != sumaImpares) {
            System.out.println("Insertando dato 0 en posiciones pares...");
            ceroEnPares(); 
        } else {
            System.out.println("Insertando dato 0 en posiciones impares...");
            ceroEnImpares();  
        }
    }
}


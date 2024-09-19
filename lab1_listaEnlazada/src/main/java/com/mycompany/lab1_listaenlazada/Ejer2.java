/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab1_listaenlazada;

/**
 *
 * @author laura
 */
public class Ejer2 {
    static Lista<Integer> listaNumeros;
    
    public Ejer2(){
    this.listaNumeros = new Lista();
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
    static public void borrarPares() {
        int posicion = 0;  // Índice de la posición del nodo, comenzamos en 0 (para indexar pares e impares)
        
        // Recorremos de manera inversa para evitar problemas de desplazamiento de índices al borrar
        for (int i = listaNumeros.getElemento() - 1; i >= 0; i--) {
            if (posicion % 2 == 0) {  // Si la posición es par
                listaNumeros.borrarEnIndice(i);  // Borra el nodo en esa posición
            }
            posicion++;
        }
    }
    
    static public void borrarImpares() {
        int posicion = 0;  // Índice de la posición del nodo, comenzamos en 0
    
        // Recorremos de manera inversa para evitar problemas de desplazamiento de índices al borrar
        for (int i = listaNumeros.getElemento() - 1; i >= 0; i--) {
            if (posicion % 2 != 0) {  // Si la posición es impar
                listaNumeros.borrarEnIndice(i);  // Borra el nodo en esa posición
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

        // Decidir si se eliminan pares o impares según la suma
        if (sumaPares != sumaImpares) {
            System.out.println("Eliminando nodos en posiciones pares...");
            borrarPares();  // Si la suma de pares e impares es diferente, elimina los pares
        } else {
            System.out.println("Eliminando nodos en posiciones impares...");
            borrarImpares();  // Si son iguales, elimina los impares
        }
    }
}

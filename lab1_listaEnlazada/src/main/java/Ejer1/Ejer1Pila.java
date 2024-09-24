 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejer1;

import java.util.ArrayList;
import java.util.Stack;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author laura
 */
public class Ejer1Pila {
    public static ArrayList<Integer> lista =new ArrayList<>();
    public static Stack<Integer> pila = new Stack<>();
    
    public static void llenarLista(){
        int dato;
        for(int i=0; i<30;i++){
            
            dato= ThreadLocalRandom.current().nextInt(1,100);
            if (lista.isEmpty()){
                lista.add(dato);
            }else{
                int j;
                for(j=0;j<lista.size();j++){
                    if(dato>lista.get(j)){
                        lista.add(j,dato);
                        break;
                    }
                }
                if (j==lista.size()){
                    lista.add(dato);
                }
            }
        }

    }
    public static void pasarDatosListaPila(){
        for(int i=0;i<lista.size();i++){
            if(lista.get(i)%2==0)
                pila.push(lista.get(i));
        }
    }
    
    public static void sumaDatosPila(){
        int suma=0;
        while(!pila.isEmpty())
            suma+=pila.pop();
        System.out.println("La suma es:" +suma);
    }
    
    public static void main(String[] args) {
        llenarLista();
        System.out.println(lista.toString());
        pasarDatosListaPila();
        System.err.println(pila.toString());
        sumaDatosPila();
    }

}


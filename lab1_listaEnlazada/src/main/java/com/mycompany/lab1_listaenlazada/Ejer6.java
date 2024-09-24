/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab1_listaenlazada;

import java.util.Random;

/**
 *
 * @author laura
 */
public class Ejer6 {
    
    
    public static void ejecutar() {
        Lista<Robot> listaRobots = crearListaRobots();
        listaRobots.mostrar();
        mostrarRobotsConVidaMayorA60(listaRobots);
        int numRobotsAfectados = disminuirVidaDeRobots(listaRobots);
        System.out.println("Número de robots a los que se disminuyó el porcentaje de vida: " + numRobotsAfectados);
    }
    
    public static Lista<Robot> crearListaRobots() {
        Lista<Robot> listaRobots = new Lista<>();
        Random rand = new Random();
        int numRobots = rand.nextInt(31) + 10; // Número aleatorio entre 10 y 40

        for (int i = 0; i < numRobots; i++) {
            int porcentajeVida = rand.nextInt(91) + 10; // Número aleatorio entre 10 y 100
            Robot robot = new Robot(i, porcentajeVida);

            // Insertar el robot de acuerdo con el porcentaje de vida
            if (porcentajeVida < 50) {
                listaRobots.agregarAlInicio(robot); // Menores porcentajes al inicio
            } else {
                listaRobots.agregarAlFinal(robot); // Mayores porcentajes al final
            }
        }
        return listaRobots;
        }
    
        public static void mostrarRobotsConVidaMayorA60(Lista<Robot> lista) {
        int contador = 0;
        Nodo<Robot> actual = lista.getInicio();
        
        System.out.println("Robots con vida mayor a 60%:");
        while (actual != null) {
            Robot robot = actual.getDato();
            if (robot.getPorcentajeVida() > 60) {
                System.out.println(robot);
                contador++;
            }
            actual = actual.getSiguiente();
        }
        System.out.println("Número de robots con vida mayor a 60%: " + contador);
    }
        
     
        
        public static int disminuirVidaDeRobots(Lista<Robot> lista) {
        return disminuirVidaRecursivamente(lista.getInicio(), 0);
    }

    private static int disminuirVidaRecursivamente(Nodo<Robot> actual, int contador) {
        if (actual == null) {
            return contador;
        }

        Robot robot = actual.getDato();
        if (robot.getPorcentajeVida() >= 30 && robot.getPorcentajeVida() <= 50) {
            robot.setPorcentajeVida(robot.getPorcentajeVida() - 15);
            contador++;
        }

        return disminuirVidaRecursivamente(actual.getSiguiente(), contador);
    }
        
}

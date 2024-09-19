/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab1_listaenlazada;

/**
 *
 * @author laura
 */
public class Robot {
    private int id;
    private int porcentajeVida;

    // Constructor
    public Robot(int id, String tipo, int porcentajeVida) {
        this.id = id;
        this.porcentajeVida = (int)(Math.random() * 91) + 10;
    }

    // Getters
    public int getId() {
        return id;
    }



    public int getPorcentajeVida() {
        return porcentajeVida;
    }

    // Método para representar el robot como una cadena
    @Override
    public String toString() {
        return "ID: " + id + ", Vida: " + porcentajeVida + "%";
    }
}


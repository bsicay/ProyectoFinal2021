/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyectofinal.bean;

/**
 *
 * @author brand
 */
public class Estudiante extends Persona{
    private int codigoEstudiante; 
    private boolean discapacidadVisual;

    public Estudiante() {
    }

    public Estudiante(int codigoEstudiante, boolean discapacidadVisual) {
        this.codigoEstudiante = codigoEstudiante;
        this.discapacidadVisual = discapacidadVisual;
    }

    public Estudiante(int codigoEstudiante, boolean discapacidadVisual, int codigoUsuario, String nombre, String telefono, String direccion, int edad, int cantidadCursos) {
        super(codigoUsuario, nombre, telefono, direccion, edad, cantidadCursos);
        this.codigoEstudiante = codigoEstudiante;
        this.discapacidadVisual = discapacidadVisual;
    }

    public int getCodigoEstudiante() {
        return codigoEstudiante;
    }

    public void setCodigoEstudiante(int codigoEstudiante) {
        this.codigoEstudiante = codigoEstudiante;
    }

    public boolean isDiscapacidadVisual() {
        return discapacidadVisual;
    }

    public void setDiscapacidadVisual(boolean discapacidadVisual) {
        this.discapacidadVisual = discapacidadVisual;
    }
    
    
    
    
    
}

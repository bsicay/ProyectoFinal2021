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
public class Profesor extends Persona{
    private int codigoProfesor; 
    private boolean ensenanzaEspecialidada;

    public Profesor() {
    }

    public Profesor(int codigoProfesor, boolean ensenanzaEspecialidada) {
        this.codigoProfesor = codigoProfesor;
        this.ensenanzaEspecialidada = ensenanzaEspecialidada;
    }

    public Profesor(int codigoProfesor, boolean ensenanzaEspecialidada, int codigoUsuario, String nombre, String telefono, String direccion, int edad, int cantidadCursos) {
        super(codigoUsuario, nombre, telefono, direccion, edad, cantidadCursos);
        this.codigoProfesor = codigoProfesor;
        this.ensenanzaEspecialidada = ensenanzaEspecialidada;
    }

    public int getCodigoProfesor() {
        return codigoProfesor;
    }

    public void setCodigoProfesor(int codigoProfesor) {
        this.codigoProfesor = codigoProfesor;
    }

    public boolean isEnsenanzaEspecialidada() {
        return ensenanzaEspecialidada;
    }

    public void setEnsenanzaEspecialidada(boolean ensenanzaEspecialidada) {
        this.ensenanzaEspecialidada = ensenanzaEspecialidada;
    }
    
    
    
    
    
    
}

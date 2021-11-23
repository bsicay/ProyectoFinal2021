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
    private boolean discapacidadVisual;

    public Estudiante() {
    }

    public Estudiante(boolean discapacidadVisual) {
        this.discapacidadVisual = discapacidadVisual;
    }

    public Estudiante(boolean discapacidadVisual, int codigoUsuario, String nombre, String usuario, String contrasena, String telefono, String direccion, int edad, String sexo, int cantidadCursos, int codigoTipoUsuario) {
        super(codigoUsuario, nombre, usuario, contrasena, telefono, direccion, edad, sexo, cantidadCursos, codigoTipoUsuario);
        this.discapacidadVisual = discapacidadVisual;
    }

    public boolean isDiscapacidadVisual() {
        return discapacidadVisual;
    }

    public void setDiscapacidadVisual(boolean discapacidadVisual) {
        this.discapacidadVisual = discapacidadVisual;
    }
    
}

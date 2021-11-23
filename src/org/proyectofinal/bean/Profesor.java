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

    private boolean ensenanzaEspecialidada;

    public Profesor() {
    }

    public Profesor(boolean ensenanzaEspecialidada) {
        this.ensenanzaEspecialidada = ensenanzaEspecialidada;
    }

    public Profesor(boolean ensenanzaEspecialidada, int codigoUsuario, String nombre, String usuario, String contrasena, String telefono, String direccion, int edad, String sexo, int cantidadCursos, int codigoTipoUsuario) {
        super(codigoUsuario, nombre, usuario, contrasena, telefono, direccion, edad, sexo, cantidadCursos, codigoTipoUsuario);
        this.ensenanzaEspecialidada = ensenanzaEspecialidada;
    }

    public boolean isEnsenanzaEspecialidada() {
        return ensenanzaEspecialidada;
    }

    public void setEnsenanzaEspecialidada(boolean ensenanzaEspecialidada) {
        this.ensenanzaEspecialidada = ensenanzaEspecialidada;
    }
    
}

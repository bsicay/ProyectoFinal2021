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
public class Persona {
    private int codigoUsuario;
    private String nombre;
    private String usuario;
    private String contrasena;
    private String telefono;
    private String direccion;
    private int edad;
    private String sexo;
    private int cantidadCursos;
    private int codigoTipoUsuario;

    public Persona() {
    }

    public Persona(int codigoUsuario, String nombre, String usuario, String contrasena, String telefono, String direccion, int edad, String sexo, int cantidadCursos, int codigoTipoUsuario) {
        this.codigoUsuario = codigoUsuario;
        this.nombre = nombre;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.telefono = telefono;
        this.direccion = direccion;
        this.edad = edad;
        this.sexo = sexo;
        this.cantidadCursos = cantidadCursos;
        this.codigoTipoUsuario = codigoTipoUsuario;
    }

    public int getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(int codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getCantidadCursos() {
        return cantidadCursos;
    }

    public void setCantidadCursos(int cantidadCursos) {
        this.cantidadCursos = cantidadCursos;
    }

    public int getCodigoTipoUsuario() {
        return codigoTipoUsuario;
    }

    public void setCodigoTipoUsuario(int codigoTipoUsuario) {
        this.codigoTipoUsuario = codigoTipoUsuario;
    }
    
    
    
}

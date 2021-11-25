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
public class Curso {
    
    private int codigoCurso;
    private int codigoProfesor;
    private String nombre;
    private String descripcion;
    private String dificultad;
    private int duracion;
    private boolean especial;

    public Curso() {
    }

    public Curso(int codigoCurso, int codigoProfesor, String nombre, String descripcion, String dificultad, int duracion, boolean especial) {
        this.codigoCurso = codigoCurso;
        this.codigoProfesor = codigoProfesor;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.dificultad = dificultad;
        this.duracion = duracion;
        this.especial = especial;
    }

    public int getCodigoCurso() {
        return codigoCurso;
    }


    public int getCodigoProfesor() {
        return codigoProfesor;
    }

    public void setCodigoProfesor(int codigoProfesor) {
        this.codigoProfesor = codigoProfesor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public boolean isEspecial() {
        return especial;
    }

    public void setEspecial(boolean especial) {
        this.especial = especial;
    }
    
}

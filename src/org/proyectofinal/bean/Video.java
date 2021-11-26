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
public class Video {
    private int codigoVideo;
    private int codigoProfesor;
    private String url;
    private String titulo;
    private String descripcion;
    private int codigoCurso;

    public Video() {
    }

    public Video(int codigoVideo, int codigoProfesor, String url, String titulo, String descripcion) {
        this.codigoVideo = codigoVideo;
        this.codigoProfesor = codigoProfesor;
        this.url = url;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public Video(String url) {
        this.url = url;
    }

    public int getCodigoVideo() {
        return codigoVideo;
    }

    public void setCodigoVideo(int codigoVideo) {
        this.codigoVideo = codigoVideo;
    }

    public int getCodigoProfesor() {
        return codigoProfesor;
    }

    public void setCodigoProfesor(int codigoProfesor) {
        this.codigoProfesor = codigoProfesor;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(int codigoCurso) {
        this.codigoCurso = codigoCurso;
    }
    
}

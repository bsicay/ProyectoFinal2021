/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyectofinal.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import org.proyectofinal.sistema.Principal;

/**
 *
 * @author brand
 */
public class MenuProfesorController implements Initializable{
    
    private Principal escenarioPrincipal;
    @FXML private ImageView curso;
    @FXML private ImageView libros;
    @FXML private ImageView misCursos;
    @FXML private ImageView miPerfil;
    @FXML private ImageView video;
	

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
    
    public void vistaCurso(){
       escenarioPrincipal.agregarCursos();
    }
    
    public void zoom(){
        curso.setImage(new Image("/org/proyectofinal/images/menuPrincipal/cursosZoom.png"));
    }
    
    public void normal(){
        curso.setImage(new Image("/org/proyectofinal/images/menuPrincipal/cursos.png"));
    }
    
    public void librosZoom(){
        libros.setImage(new Image("/org/proyectofinal/images/menuPrincipal/librosZoom.png"));
    }
    
    public void librosNormal(){
        libros.setImage(new Image("/org/proyectofinal/images/menuPrincipal/libros.png"));
    }
    
    public void misCursosNormal(){
        misCursos.setImage(new Image("/org/proyectofinal/images/menuPrincipal/misCursos.png"));
    }
    
    public void misCursosZoom(){
        misCursos.setImage(new Image("/org/proyectofinal/images/menuPrincipal/misCursosZoom.png"));
    }
    
    public void perfilNormal(){
        miPerfil.setImage(new Image("/org/proyectofinal/images/menuPrincipal/perfil.png"));
    }
    
    public void perfilZoom(){
        miPerfil.setImage(new Image("/org/proyectofinal/images/menuPrincipal/perfilZoom.png"));
    }
    
    public void videoNormal(){
        video.setImage(new Image("/org/proyectofinal/images/menuPrincipal/video.png"));
    }
    
    public void videoZoom(){
        video.setImage(new Image("/org/proyectofinal/images/menuPrincipal/videoZoom.png"));
    }
    
    public void video(){
        escenarioPrincipal.misCursos();
               
    }
    
    public Principal getEscenarioPrincipal() {

    return escenarioPrincipal;
    }
    
    public void logout(){
        escenarioPrincipal.login();
    }
    
    public void misCursos(){
        escenarioPrincipal.misCursos();
    }

    public void setEscenarioPrincipal(Principal escenarioPrincipal) {
        this.escenarioPrincipal = escenarioPrincipal;
    }
    
    
    
}

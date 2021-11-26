/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyectofinal.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.proyectofinal.sistema.Principal;

/**
 *
 * @author brand
 */
public class MenuEstudianteController implements Initializable{
    private Principal escenarioPrincipal;
    @FXML private ImageView curso;
    @FXML private ImageView libros;
    @FXML private ImageView misCursos;
    @FXML private ImageView miPerfil;
        
    @Override
    public void initialize(URL location, ResourceBundle resources) {
      
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
    
    public void logout(){
        escenarioPrincipal.login();
    }
    
    public void asignarse(){
        escenarioPrincipal.asignarse();
    }
    
    public void misCursos(){
        escenarioPrincipal.previoVideos();
    }
    
    public void braile(){
        escenarioPrincipal.braile();
    }

    public Principal getEscenarioPrincipal() {
        return escenarioPrincipal;
    }

    public void setEscenarioPrincipal(Principal escenarioPrincipal) {
        this.escenarioPrincipal = escenarioPrincipal;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyectofinal.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import org.proyectofinal.sistema.Principal;

/**
 *
 * @author brand
 */
public class MenuProfesorController implements Initializable{
    
    private Principal escenarioPrincipal;
	

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
    public void video(){
        escenarioPrincipal.subirVideo();
    }
    
    public Principal getEscenarioPrincipal() {

    return escenarioPrincipal;
    }

    public void setEscenarioPrincipal(Principal escenarioPrincipal) {
        this.escenarioPrincipal = escenarioPrincipal;
    }
    
    
    
}

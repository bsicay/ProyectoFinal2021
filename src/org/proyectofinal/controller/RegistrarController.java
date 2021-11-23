/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyectofinal.controller;

import java.net.URL;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import org.proyectofinal.sistema.Principal;

/**
 *
 * @author brand
 */
public class RegistrarController implements Initializable{
    
    private Principal escenarioPrincipal;
	
    @Override
    public void initialize(URL location, ResourceBundle resources) {
            // TODO Auto-generated method stub

    }
        
    public void login(){
        escenarioPrincipal.login();
    }
    
    public void registrarProfesor(){
        escenarioPrincipal.registrarProfesor();
    }
    
    public void registrarEstudiante(){
        escenarioPrincipal.registrarEstudiante();
    }

    public Principal getEscenarioPrincipal() {
         return escenarioPrincipal;
    }
    
    public void setEscenarioPrincipal(Principal escenarioPrincipal) {
        this.escenarioPrincipal = escenarioPrincipal;
    }

    
}

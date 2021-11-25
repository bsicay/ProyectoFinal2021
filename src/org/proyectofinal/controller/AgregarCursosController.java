/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyectofinal.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.proyectofinal.sistema.Principal;

/**
 *
 * @author brand
 */
public class AgregarCursosController implements Initializable{
    private Principal escenarioPrincipal;
    @FXML
    private TextField txtNombreCurso;
    @FXML
    private TextArea txtDescripcionCurso;
    @FXML
    private TextField txtDuracion;
    @FXML
    private CheckBox chkCursoEspecial;
    @FXML
    private ComboBox cmbDificultad;
    @FXML
    private Button btnAgregar;
  
    
	
    @Override
    public void initialize(URL location, ResourceBundle resources) {
            // TODO Auto-generated method stub
            cmbDificultad.getItems().clear();
            cmbDificultad.getItems().addAll("Principiante",
            "Intermedio",
            "Avanzado");
    }
        
        
    public void login(){
        escenarioPrincipal.login();
    }
    
    public void registrar(){
      escenarioPrincipal.registrar();
    }



    public Principal getEscenarioPrincipal() {

    return escenarioPrincipal;
    }

    public void setEscenarioPrincipal(Principal escenarioPrincipal) {
        this.escenarioPrincipal = escenarioPrincipal;
    }
    
}

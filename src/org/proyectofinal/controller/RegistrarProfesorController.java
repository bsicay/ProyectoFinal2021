/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyectofinal.controller;

import java.net.URL;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import org.proyectofinal.bean.Profesor;
import org.proyectofinal.db.Conexion;
import org.proyectofinal.sistema.Principal;

/**
 *
 * @author brand
 */
public class RegistrarProfesorController implements Initializable{
    @FXML private TextField txtNombreProfesor; 
    @FXML private TextField intEdadProfesor; 
    @FXML private TextField txtUsuarioProfesor; 
    @FXML private TextField txtContraseñaProfesor; 
    @FXML private TextField intTelefonoProfesor; 
    @FXML private TextField txtDireccionProfesor; 
    @FXML private CheckBox chkEnseñanzaEspecializada;
    @FXML private RadioButton rbMasculinoProfesor;
    @FXML private RadioButton rbFemeninoProfesor;
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       
    }
    
    public void guardar(){
        if (txtNombreProfesor.getText().isEmpty() || txtUsuarioProfesor.getText().isEmpty() || txtContraseñaProfesor.getText().isEmpty() || intTelefonoProfesor.getText().isEmpty() 
                 || txtDireccionProfesor.getText().isEmpty() || intEdadProfesor.getText().isEmpty() || rbFemeninoProfesor.isFocused() || rbMasculinoProfesor.isFocused()){
            JOptionPane.showMessageDialog(null, "Ingrese todos los datos");  
        }else {
            Profesor registro = new Profesor();
            registro.setNombre(txtNombreProfesor.getText());
            registro.setUsuario(txtUsuarioProfesor.getText());
            registro.setContrasena(txtContraseñaProfesor.getText());
            registro.setTelefono(intTelefonoProfesor.getText());
            registro.setDireccion(txtDireccionProfesor.getText());
            registro.setEdad(Integer.parseInt(intEdadProfesor.getText()));
            registro.setEnsenanzaEspecialidada(chkEnseñanzaEspecializada.isSelected());
            if (rbMasculinoProfesor.isSelected()) {
                registro.setSexo("M");
            }else {
                registro.setSexo("F");  
            }
            try{
                PreparedStatement procedimiento = Conexion.getInstancia().getConexion().prepareCall("{call sp_AgregarProfesor(?,?,?,?,?,?,?,?,?)}");
                procedimiento.setString(1, registro.getNombre());
                procedimiento.setString(2, registro.getUsuario());
                procedimiento.setString(3, registro.getContrasena());
                procedimiento.setString(4, registro.getTelefono());
                procedimiento.setString(5, registro.getDireccion());
                procedimiento.setInt(6, registro.getEdad());
                procedimiento.setString(7, registro.getSexo());
                procedimiento.setBoolean(8, registro.isEnsenanzaEspecialidada());
                procedimiento.setInt(9, 1);
                procedimiento.execute();
                JOptionPane.showMessageDialog(null, "USUARIO GUARDADO CON EXITO");
                limpiarControles();
                escenarioPrincipal.menuProfesor();
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }

    }
    
    private void limpiarControles(){
        txtNombreProfesor.setText("");
        intEdadProfesor.setText("");
        txtUsuarioProfesor.setText("");
        txtContraseñaProfesor.setText("");
        intTelefonoProfesor.setText("");
        txtDireccionProfesor.setText("");
        chkEnseñanzaEspecializada.setSelected(false);
        rbFemeninoProfesor.setSelected(false);
        rbMasculinoProfesor.setSelected(false);
    }
    
    private Principal escenarioPrincipal;
    
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyectofinal.controller;

import java.net.URL;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import org.proyectofinal.bean.Estudiante;
import org.proyectofinal.db.Conexion;
import org.proyectofinal.sistema.Principal;

/**
 *
 * @author brand
 */
public class RegistrarEstudianteController implements Initializable{
    
    @FXML private TextField txtNombreEstudiante; 
    @FXML private TextField intEdadEstudiante; 
    @FXML private TextField txtUsuarioEstudiante; 
    @FXML private TextField txtContraseñaEstudiante; 
    @FXML private TextField intTelefonoEstudiante; 
    @FXML private TextField txtDireccionEstudiante; 
    @FXML private CheckBox chkDiscapacidadVisual;
    @FXML private RadioButton rbMasculinoEstudiante;
    @FXML private RadioButton rbFemeninoEstudiante;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       
    }
    
    public void guardar(){
        if (txtNombreEstudiante.getText().isEmpty() || txtUsuarioEstudiante.getText().isEmpty() || txtContraseñaEstudiante.getText().isEmpty() || intTelefonoEstudiante.getText().isEmpty() 
                 || txtDireccionEstudiante.getText().isEmpty() || intEdadEstudiante.getText().isEmpty() || rbMasculinoEstudiante.isFocused() || rbFemeninoEstudiante.isFocused()){
            JOptionPane.showMessageDialog(null, "Ingrese todos los datos");  
        }else {
            Estudiante registro = new Estudiante();
            registro.setNombre(txtNombreEstudiante.getText());
            registro.setUsuario(txtUsuarioEstudiante.getText());
            registro.setContrasena(txtContraseñaEstudiante.getText());
            registro.setTelefono(intTelefonoEstudiante.getText());
            registro.setDireccion(txtDireccionEstudiante.getText());
            registro.setEdad(Integer.parseInt(intEdadEstudiante.getText()));
            registro.setDiscapacidadVisual(chkDiscapacidadVisual.isSelected());
            if (rbMasculinoEstudiante.isSelected()) {
                registro.setSexo("M");
            }else {
                registro.setSexo("F");  
            }
            try{
                PreparedStatement procedimiento = Conexion.getInstancia().getConexion().prepareCall("{call sp_AgregarEstudiante(?,?,?,?,?,?,?,?,?)}");
                procedimiento.setString(1, registro.getNombre());
                procedimiento.setString(2, registro.getUsuario());
                procedimiento.setString(3, registro.getContrasena());
                procedimiento.setString(4, registro.getTelefono());
                procedimiento.setString(5, registro.getDireccion());
                procedimiento.setInt(6, registro.getEdad());
                procedimiento.setString(7, registro.getSexo());
                procedimiento.setBoolean(8, registro.isDiscapacidadVisual());
                procedimiento.setInt(9, 0);
                procedimiento.execute();
                JOptionPane.showMessageDialog(null, "USUARIO GUARDADO CON EXITO");
                escenarioPrincipal.menuProfesor();
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }

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

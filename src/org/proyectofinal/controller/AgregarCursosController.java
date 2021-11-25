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
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javax.swing.JOptionPane;
import org.proyectofinal.bean.Curso;
import org.proyectofinal.bean.Profesor;
import org.proyectofinal.db.Conexion;
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
//    
//    public void guardar(){
//        if (txtNombreCurso.getText().isEmpty() || txtDescripcionCurso.getText().isEmpty() || txtDuracion.getText().isEmpty() 
//                || cmbDificultad.getSelectionModel().isEmpty()){
//            JOptionPane.showMessageDialog(null, "Ingrese todos los datos");  
//        }else {
//            LoginController profesor = new LoginController();
//            Curso registro = new Curso();
//            registro.setCodigoProfesor(profesor.getProfesor().get(0).getIdUsuarioActual());
//            registro.setUsuario(txtUsuarioProfesor.getText());
//            registro.setContrasena(txtContraseñaProfesor.getText());
//            registro.setTelefono(intTelefonoProfesor.getText());
//            registro.setDireccion(txtDireccionProfesor.getText());
//            registro.setEdad(Integer.parseInt(intEdadProfesor.getText()));
//            registro.setEnsenanzaEspecialidada(chkEnseñanzaEspecializada.isSelected());
//            if (rbMasculinoProfesor.isSelected()) {
//                registro.setSexo("M");
//            }else {
//                registro.setSexo("F");  
//            }
//            try{
//                PreparedStatement procedimiento = Conexion.getInstancia().getConexion().prepareCall("{call sp_AgregarProfesor(?,?,?,?,?,?,?,?,?)}");
//                procedimiento.setString(1, registro.getNombre());
//                procedimiento.setString(2, registro.getUsuario());
//                procedimiento.setString(3, registro.getContrasena());
//                procedimiento.setString(4, registro.getTelefono());
//                procedimiento.setString(5, registro.getDireccion());
//                procedimiento.setInt(6, registro.getEdad());
//                procedimiento.setString(7, registro.getSexo());
//                procedimiento.setBoolean(8, registro.isEnsenanzaEspecialidada());
//                procedimiento.setInt(9, 1);
//                procedimiento.execute();
//                JOptionPane.showMessageDialog(null, "USUARIO GUARDADO CON EXITO");
//                escenarioPrincipal.menuProfesor();
//            }catch(Exception e){
//                e.printStackTrace();
//            }
//            
//        }
//    }
//    
    public void SoloNumerosEnteros(KeyEvent keyEvent) {
        try{
            char key = keyEvent.getCharacter().charAt(0);

            if (!Character.isDigit(key))
                keyEvent.consume();

        } catch (Exception e){ 
            e.printStackTrace();
        }
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

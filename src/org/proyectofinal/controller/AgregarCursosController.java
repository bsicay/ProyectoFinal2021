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
    
    public void guardar(){
        if (txtNombreCurso.getText().isEmpty() || txtDescripcionCurso.getText().isEmpty() || txtDuracion.getText().isEmpty() 
                || cmbDificultad.getSelectionModel().isEmpty()){
            JOptionPane.showMessageDialog(null, "Ingrese todos los datos");  
        }else {
            LoginController profesor = new LoginController();
            Curso registro = new Curso();
            registro.setCodigoProfesor(profesor.getUsuario());
            registro.setNombre(txtNombreCurso.getText());
            registro.setDescripcion(txtDescripcionCurso.getText());
            registro.setDificultad(cmbDificultad.getSelectionModel().getSelectedItem().toString());
            registro.setDuracion(Integer.parseInt(txtDuracion.getText()));
            registro.setEspecial(chkCursoEspecial.isSelected());
            try{
                PreparedStatement procedimiento = Conexion.getInstancia().getConexion().prepareCall("{call sp_AgregarCurso(?,?,?,?,?,?,?)}");
                procedimiento.setInt(1, registro.getCodigoProfesor());
                procedimiento.setString(2, registro.getNombre());
                procedimiento.setString(3, registro.getDescripcion());
                procedimiento.setString(4, registro.getDificultad());
                procedimiento.setInt(5, registro.getDuracion());
                procedimiento.setBoolean(6, registro.isEspecial());
                String image = JOptionPane.showInputDialog("Ingrese el enlace o ruta de la imagen del curso");
                procedimiento.setString(7, image);
                procedimiento.execute();
                JOptionPane.showMessageDialog(null, "CURSO GUARDADO CON EXITO");
                limpiarControles();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Ingrese datos validos");
                e.printStackTrace();
            }
            
        }
    }
    
    public void limpiarControles(){
        txtNombreCurso.setText("");
        txtDescripcionCurso.setText("");
        cmbDificultad.setSelectionModel(null);
        txtDuracion.setText("");
        chkCursoEspecial.setSelected(false);
    }
    
    public void SoloNumerosEnteros(KeyEvent keyEvent) {
        try{
            char key = keyEvent.getCharacter().charAt(0);

            if (Character.isLetter(key))
                keyEvent.consume();

        } catch (Exception e){ 
            e.printStackTrace();
        }
    }
        
    public void login(){
        escenarioPrincipal.login();
    }
    
    public void menuProfesor(){
      escenarioPrincipal.menuProfesor();
    }



    public Principal getEscenarioPrincipal() {

    return escenarioPrincipal;
    }

    public void setEscenarioPrincipal(Principal escenarioPrincipal) {
        this.escenarioPrincipal = escenarioPrincipal;
    }
    
}

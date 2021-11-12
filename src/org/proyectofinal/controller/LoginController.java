/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyectofinal.controller;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import org.proyectofinal.bean.Estudiante;
import org.proyectofinal.bean.Persona;
import org.proyectofinal.bean.Profesor;
import org.proyectofinal.db.Conexion;
import org.proyectofinal.sistema.Principal;

/**
 *
 * @author brand
 */
public class LoginController implements Initializable{
    
    private Principal escenarioPrincipal;
    private ObservableList<Persona>listaUsuario;
    private ObservableList<Estudiante>listaEstudiante;
    private ObservableList<Profesor>listaProfesor;
    @FXML private TextField txtUser;
    @FXML private PasswordField pswPassword;
    @FXML private Button btnLogin;
    @FXML private Button btnRegister;
    @FXML private RadioButton rbEstudiante;
    @FXML private RadioButton rbDocente;
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
            // TODO Auto-generated method stub

    }
    
    public ObservableList<Estudiante>getEstudiantes(){
        ArrayList<Estudiante> lista = new ArrayList<Estudiante>();
        try{
            PreparedStatement procedimiento = Conexion.getInstancia().getConexion().prepareCall("{call sp_ListarEstudiante}");
            ResultSet resultado = procedimiento.executeQuery();
            while(resultado.next()){
                lista.add(new Estudiante(resultado.getInt("idEstudiante"),
                                resultado.getBoolean("discapacidad_visual"),
                                resultado.getInt("codigoTipoUsuario"),
                                resultado.getString("nombre"), 
                                resultado.getString("telefono"),
                                resultado.getString("direccion"), 
                                resultado.getInt("edad"),
                                resultado.getInt("cantidad_cursos")));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return listaEstudiante = FXCollections.observableList(lista);
    }  
    
    
    
    public void inicioSesion(){
        if(txtUser.getText().isEmpty() || pswPassword.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Ingrese todos los datos");  
        }else{
            for(int i=0; i < getEstudiantes().size(); i++){
             if(txtUser.getText().equals(getEstudiantes().get(i).getNombre())){
                JOptionPane.showMessageDialog(null, "BIENVENIDO");
                menuProfesor();
                break;
             }else if(i >= getEstudiantes().size() -1 ){
                JOptionPane.showMessageDialog(null, "El usuario no existe o no tiene permitido ingresar");
            }
        }           
        }
    }
    
    public void registrar(){
        escenarioPrincipal.registrar();
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

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
    boolean encontradp = false;
    
    
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
                lista.add(new Estudiante(resultado.getBoolean("discapacidad_visual"),
                                resultado.getInt("idEstudiante"),
                                resultado.getString("nombre"), 
                                resultado.getString("usuario"), 
                                resultado.getString("contrasena"), 
                                resultado.getString("telefono"),
                                resultado.getString("direccion"), 
                                resultado.getInt("edad"),
                                resultado.getString("sexo"),
                                resultado.getInt("cantidad_cursos"), 
                                resultado.getInt("codigoTipoUsuario")));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return listaEstudiante = FXCollections.observableList(lista);
    }  
    
    public ObservableList<Profesor>getProfesor(){
        ArrayList<Profesor> lista = new ArrayList<Profesor>();
        try{
            PreparedStatement procedimiento = Conexion.getInstancia().getConexion().prepareCall("{call sp_ListarProfesor}");
            ResultSet resultado = procedimiento.executeQuery();
            while(resultado.next()){
                lista.add(new Profesor(resultado.getBoolean("ensenanza_especializada"),
                                resultado.getInt("idProfesor"),
                                resultado.getString("nombre"), 
                                resultado.getString("usuario"), 
                                resultado.getString("contrasena"), 
                                resultado.getString("telefono"),
                                resultado.getString("direccion"), 
                                resultado.getInt("edad"),
                                resultado.getString("sexo"),
                                resultado.getInt("cantidad_cursos"), 
                                resultado.getInt("codigoTipoUsuario")));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return listaProfesor = FXCollections.observableList(lista);
    }
    
    public void actualizarEstudiante(int codigo){
        try{
            PreparedStatement procedimiento = Conexion.getInstancia().getConexion().prepareCall("{call sp_EditarEstudiante(?)}");
            procedimiento.setInt(1, codigo);
            procedimiento.execute();
        }catch(Exception e){
            e.printStackTrace();
        }
    }   
    
    public void actualizarProfesor(int codigo){
        try{
            PreparedStatement procedimiento = Conexion.getInstancia().getConexion().prepareCall("{call sp_EditarProfesor(?)}");
            procedimiento.setInt(1, codigo);
            procedimiento.execute();
        }catch(Exception e){
            e.printStackTrace();
        }
    } 
    
    
    
    
    public void inicioSesion(){
        if(txtUser.getText().isEmpty() || pswPassword.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Ingrese todos los datos");  
        }else{
            if (verificarEstudiante()) {
               JOptionPane.showMessageDialog(null, "BIENVENIDO");
                menuEstudiante();
            }else if(verificarProfesor()){
                JOptionPane.showMessageDialog(null, "BIENVENIDO PROFESOR");
                menuProfesor();
            }else{
               JOptionPane.showMessageDialog(null, "Credenciales incorrectaas"); 
            }        
        }
    }
    
    public boolean verificarEstudiante(){
        encontradp = false;
        for(int i=0; i < getEstudiantes().size(); i++){
            if(txtUser.getText().equals(getEstudiantes().get(i).getUsuario()) && pswPassword.getText().equals(getEstudiantes().get(i).getContrasena())){
                actualizarEstudiante(getEstudiantes().get(i).getCodigoUsuario());
                encontradp  = true;
                break;
            }
        }
        return encontradp;
    }
    
    public boolean verificarProfesor(){
        encontradp = false;
        for(int i=0; i < getProfesor().size(); i++){
                if(txtUser.getText().equals(getProfesor().get(i).getUsuario()) && pswPassword.getText().equals(getProfesor().get(i).getContrasena())){
                    actualizarProfesor(getProfesor().get(i).getCodigoUsuario());
                    encontradp  = true;
                    break;
                }
            }
            return encontradp;
    }
    
    public void registrar(){
        escenarioPrincipal.registrar();
    }
    
    public void menuProfesor(){
        escenarioPrincipal.menuProfesor();
    }
    
    public void menuEstudiante(){
        escenarioPrincipal.menuEstudiante();
    }


    public Principal getEscenarioPrincipal() {

        return escenarioPrincipal;
    }

    public void setEscenarioPrincipal(Principal escenarioPrincipal) {
        this.escenarioPrincipal = escenarioPrincipal;
    }

    
}

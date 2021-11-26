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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.proyectofinal.bean.Curso;
import org.proyectofinal.bean.Estudiante;
import org.proyectofinal.db.Conexion;
import org.proyectofinal.sistema.Principal;

/**
 *
 * @author brand
 */
public class CursosEstudianteController implements Initializable{
    private ObservableList<Curso> listaCurso;
    private Principal escenarioPrincipal;
    
    @FXML
    private TableView tblCursos;

    @FXML
    private TableColumn colNombre;

    @FXML
    private TableColumn colDescripcion;

    @FXML
    private TableColumn colDificultad;

    @FXML
    private TableColumn colProfesor;
 
    @FXML
    private Button btnVideo;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
       cargarDatos();
    }
    
    public void cargarDatos(){
        tblCursos.setItems(getCursos());
        colNombre.setCellValueFactory(new PropertyValueFactory<Curso, String>("nombre"));
        colDescripcion.setCellValueFactory(new PropertyValueFactory<Curso, String>("descripcion"));
        colDificultad.setCellValueFactory(new PropertyValueFactory<Curso, String>("dificultad"));
        colProfesor.setCellValueFactory(new PropertyValueFactory<Curso, String>("url"));
        
    }
    
    public ObservableList<Curso> getCursos(){
        ArrayList<Curso> lista = new ArrayList<Curso>();
        try{
            PreparedStatement procedimiento = Conexion.getInstancia().getConexion().prepareCall("{call sp_ListarEstudianteCurso(?)}");
            LoginController usuario = new LoginController();
            Estudiante registro = new Estudiante();
            registro.setCodigoUsuario(usuario.getUsuario());
            procedimiento.setInt(1, registro.getCodigoUsuario());
            ResultSet resultado = procedimiento.executeQuery();
            while (resultado.next()){
                lista.add(new Curso(resultado.getString("nombre"),
                                resultado.getString("descripcion"), 
                                resultado.getString("dificultad"), 
                                resultado.getString("url")));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return listaCurso = FXCollections.observableList(lista);
    }
    
    public void menu(){
        escenarioPrincipal.menuEstudiante();
    }
    
    public void verVideo(){
        escenarioPrincipal.subirVideo();
    }
    
    public void seleccionarElementos(){
        if(tblCursos.getSelectionModel().getSelectedItem() != null)
            actualizarVideo(((Curso)tblCursos.getSelectionModel().getSelectedItem()).getUrl());
           // txtNombre.setText(((Area)tblAreas.getSelectionModel().getSelectedItem()).getNombreArea());
        else{
            tblCursos.getSelectionModel().clearSelection();
        }
    }
    
    public void actualizarVideo(String url){
        try{
            PreparedStatement procedimiento = Conexion.getInstancia().getConexion().prepareCall("{call sp_EditarVideoEstudiante(?)}");
            procedimiento.setString(1, url);
            procedimiento.execute();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    

    public Principal getEscenarioPrincipal() {
        return escenarioPrincipal;
    }

    public void setEscenarioPrincipal(Principal escenarioPrincipal) {
        this.escenarioPrincipal = escenarioPrincipal;
    }
    
    
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyectofinal.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import org.proyectofinal.bean.Curso;
import org.proyectofinal.bean.MyListener;
import org.proyectofinal.db.Conexion;
import org.proyectofinal.sistema.Principal;

/**
 *
 * @author brand
 */
public class AsignarCursoController implements Initializable{
    private Principal escenarioPrincipal;
    
    @FXML
    private Label lblTitulo;
    
    @FXML
    private ScrollPane scroll;

    @FXML
    private GridPane grid;
    
    private List<Curso> cursos = new ArrayList<>();
    
    private MyListener myListener;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cursos.addAll(getCursos());
        if (cursos.size() > 0) {
            myListener = new MyListener() {
                @Override
                public void onClickListener(Curso curso) {
                    
                }
            };
        }
        int column = 0;
        int row = 1;
        
        try {
            for (int i = 0; i < cursos.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/org/proyectofinal/view/cursoItemAsignacion.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                CursoItemController cursoItemController = fxmlLoader.getController();
                cursoItemController.setData(cursos.get(i), myListener);

                if (column == 3) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_COMPUTED_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_COMPUTED_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public List<Curso>getCursos(){
        Curso registro = new Curso();
        ArrayList<Curso> lista = new ArrayList<Curso>();
        try{
            PreparedStatement procedimiento = Conexion.getInstancia().getConexion().prepareCall("{call sp_ListarCursoTotales}");
            ResultSet resultado = procedimiento.executeQuery();
            while(resultado.next()){
                lista.add(new Curso(resultado.getInt("idCurso"),
                                resultado.getInt("idProfesor"),
                                resultado.getString("nombre"), 
                                resultado.getString("descripcion"), 
                                resultado.getString("dificultad"), 
                                resultado.getInt("duracion"),
                                resultado.getBoolean("especial"), 
                                resultado.getString("imageCurso")));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return lista;
    }
    
    public void menu(){
        escenarioPrincipal.menuEstudiante();
    }
    
    

    public Principal getEscenarioPrincipal() {
        return escenarioPrincipal;
    }

    public void setEscenarioPrincipal(Principal escenarioPrincipal) {
        this.escenarioPrincipal = escenarioPrincipal;
    }

    public void setLblTitulo() {
        lblTitulo.setText("LISTADO DE CURSOS");
    }
    
    
}

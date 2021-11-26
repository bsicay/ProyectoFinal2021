/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyectofinal.controller;

import java.sql.PreparedStatement;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;
import org.proyectofinal.bean.Curso;
import org.proyectofinal.bean.Estudiante;
import org.proyectofinal.bean.MyListener;
import org.proyectofinal.bean.Profesor;
import org.proyectofinal.bean.Video;
import org.proyectofinal.db.Conexion;
import org.proyectofinal.sistema.Principal;

/**
 *
 * @author brand
 */
public class CursoItemController {
    private Principal escenarioPrincipal;
    
    @FXML
    private Label nameLabel;

    @FXML
    private ImageView img;

    private Curso curso;
    private MyListener myListener;
    
    public void setData(Curso curso, MyListener myListener) {
        this.curso = curso;
        this.myListener = myListener;
        nameLabel.setText(curso.getNombre());
        Image image = new Image((curso.getImgSrc()));
        img.setImage(image);
    }
    
    @FXML
    private void click(MouseEvent mouseEvent) {
        myListener.onClickListener(curso);
    }
    
    public void subirVideo(){
        LoginController usuario = new LoginController();
        Video registro = new Video();
        String url = JOptionPane.showInputDialog("Ingrese el enlace de su video");
        String titulo = JOptionPane.showInputDialog("Ingrese el nombre de su video");
        String descripcion = JOptionPane.showInputDialog("Ingrese la descripcion de su video");
        registro.setCodigoProfesor(usuario.getUsuario());
        registro.setTitulo(titulo);
        registro.setUrl(url);
        registro.setDescripcion(descripcion);
        System.out.println(curso.getCodigoCurso());
        registro.setCodigoCurso(curso.getCodigoCurso());
        try{
            PreparedStatement procedimiento = Conexion.getInstancia().getConexion().prepareCall("{call sp_AgregarVideo(?,?,?,?,?)}");
            procedimiento.setInt(1, registro.getCodigoProfesor());
            procedimiento.setString(2, registro.getTitulo());
            procedimiento.setString(3, registro.getDescripcion());
            procedimiento.setString(4, registro.getUrl());
            procedimiento.setInt(5, registro.getCodigoCurso());
            procedimiento.execute();
            JOptionPane.showMessageDialog(null, "VIDEO GUARDADO CON EXITO");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ingrese datos validos");
            e.printStackTrace();
        }
    }
    
    
    
    public void asignarse(){
        LoginController usuario = new LoginController();
        Estudiante registro = new Estudiante();
        registro.setCodigoUsuario(usuario.getUsuario());
        curso.setCodigoCurso(curso.getCodigoCurso());
        try{
            PreparedStatement procedimiento = Conexion.getInstancia().getConexion().prepareCall("{call sp_AgregarEstudianteCurso(?,?)}");
            procedimiento.setInt(1, registro.getCodigoUsuario());
            procedimiento.setInt(2, curso.getCodigoCurso());
            procedimiento.execute();
            JOptionPane.showMessageDialog(null, "ASIGNADO A " +curso.getNombre()+" CON EXITO");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ingrese datos validos");
            e.printStackTrace();
        }
    }
    
}

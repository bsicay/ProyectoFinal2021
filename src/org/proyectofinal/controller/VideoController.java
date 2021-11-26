/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyectofinal.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.media.MediaView;
import org.proyectofinal.sistema.Principal;
import javax.swing.JFileChooser;
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.util.Duration;
import org.proyectofinal.db.Conexion;

/**
 *
 * @author brand
 */
public class VideoController implements Initializable{
    @FXML private WebView mediaView;
    @FXML WebEngine engine;
    private Principal escenarioPrincipal;
    private MediaPlayer mediaPlayer;
    private Media media;
    private String url;
    File archivoSeleccionado;
    JFileChooser seleccionarArchivo = new JFileChooser();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        engine = mediaView.getEngine(); 
        engine.load(getUrl());
    
//        seleccionarArchivo.showOpenDialog(null);
//        archivoSeleccionado = seleccionarArchivo.getSelectedFile();
//        System.out.println(archivoSeleccionado);
//        media = new Media(archivoSeleccionado.toURI().toString());
//        mediaPlayer = new MediaPlayer(media);
//        mediaView.setMediaPlayer(mediaPlayer);
        
    }
    
    public String getUrl(){
        String url = "";
        try{
            PreparedStatement procedimiento = Conexion.getInstancia().getConexion().prepareCall("{call sp_ListarUrl}");
            ResultSet resultado = procedimiento.executeQuery();
            while(resultado.next()){
               url = resultado.getString("url");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return url;
    }
    
    public void video(String url){
        this.url = url;
    }
    
    public void playMedia() {
        mediaPlayer.play();
    }
    
    public void pauseMedia() {
		
        mediaPlayer.pause();
    }
    
    public void menu(){
        escenarioPrincipal.previoVideos();
    }
    

    public void resetMedia() {

        if(mediaPlayer.getStatus() != MediaPlayer.Status.READY) {
                mediaPlayer.seek(Duration.seconds(0.0));
        }
    }

    public Principal getEscenarioPrincipal() {

    return escenarioPrincipal;
    }

    public void setEscenarioPrincipal(Principal escenarioPrincipal) {
        this.escenarioPrincipal = escenarioPrincipal;
    }
    
    
    
}

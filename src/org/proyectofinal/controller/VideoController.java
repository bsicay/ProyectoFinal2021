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
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

/**
 *
 * @author brand
 */
public class VideoController implements Initializable{
    @FXML private MediaView mediaView;
    @FXML private Button btnPlay;
    private Principal escenarioPrincipal;
    private MediaPlayer mediaPlayer;
    private Media media;
    File archivoSeleccionado;
    JFileChooser seleccionarArchivo = new JFileChooser();
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        seleccionarArchivo.showOpenDialog(null);
        archivoSeleccionado = seleccionarArchivo.getSelectedFile();
        System.out.println(archivoSeleccionado);
        media = new Media(archivoSeleccionado.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);
        
    }
    
    public void playMedia() {
        mediaPlayer.play();
    }
    
    public void pauseMedia() {
		
        mediaPlayer.pause();
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

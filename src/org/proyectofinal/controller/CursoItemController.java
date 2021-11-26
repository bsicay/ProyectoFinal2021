/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyectofinal.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.proyectofinal.bean.Curso;

/**
 *
 * @author brand
 */
public class CursoItemController {
    
    @FXML
    private Label nameLabel;

    @FXML
    private ImageView img;

    private Curso curso;
    
    public void setData(Curso curso) {
        this.curso = curso;
        nameLabel.setText(curso.getNombre());
        Image image = new Image(getClass().getResourceAsStream(curso.getImgSrc()));
        img.setImage(image);
        
    }
    
    
    
}

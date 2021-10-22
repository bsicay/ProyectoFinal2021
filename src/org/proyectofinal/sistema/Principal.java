package org.proyectofinal.sistema;

import java.io.InputStream;


import org.proyectofinal.controller.EjemploController;
import org.proyectofinal.controller.LoginController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Principal extends Application {
    private final String PAQUETE_VISTA = "/org/proyectofinal/view/";
    private Stage escenarioPrincipal;
    private Scene escena; 
  
    @Override
    public void start(Stage escenarioPrincipal) {
        this.escenarioPrincipal = escenarioPrincipal;
        escenarioPrincipal.setTitle("LOGIN");
        escenarioPrincipal.getIcons().add(new Image("/org/proyectofinal/images/student.png"));
        login();
        escenarioPrincipal.show();
        
       
    }
    
    public void iniciar(){
        try{
            EjemploController iniciar = (EjemploController)cambiarEscena("loginView.fxml", 800, 550);
            iniciar.setEscenarioPrincipal(this);
        }catch(Exception e){
            e.printStackTrace();
        }
    
    }
    
    public void login(){
        try{
            LoginController login = (LoginController)cambiarEscena("loginView.fxml", 800, 550);
            login.setEscenarioPrincipal(this);
        }catch(Exception e){
            e.printStackTrace();
        }
    
    }
    
    
    public Initializable cambiarEscena(String fxml, int ancho, int alto) throws Exception{
        Initializable resultado = null; 
        FXMLLoader cargadorFXML = new FXMLLoader();
        InputStream archivo = Principal.class.getResourceAsStream(PAQUETE_VISTA+fxml); 
        cargadorFXML.setBuilderFactory(new JavaFXBuilderFactory());
        cargadorFXML.setLocation(Principal.class.getResource(PAQUETE_VISTA+fxml));  
        escena = new Scene((AnchorPane)cargadorFXML.load(archivo), ancho, alto);
        escenarioPrincipal.setScene(escena);
        escenarioPrincipal.sizeToScene();
        resultado = (Initializable)cargadorFXML.getController();
        return resultado; 
            
    }  
   

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
    }
    
}
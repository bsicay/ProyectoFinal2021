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
import org.proyectofinal.controller.AgregarCursosController;
import org.proyectofinal.controller.AgregarLibrosController;
import org.proyectofinal.controller.MenuEstudianteController;
import org.proyectofinal.controller.MenuProfesorController;
import org.proyectofinal.controller.RegistrarController;
import org.proyectofinal.controller.RegistrarEstudianteController;
import org.proyectofinal.controller.RegistrarProfesorController;
import org.proyectofinal.controller.VideoController;

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
    
    public void agregarCursos(){
        try{
            AgregarCursosController agregarCursos = (AgregarCursosController)cambiarEscena("AgregarCurso.fxml", 800, 550);
            agregarCursos.setEscenarioPrincipal(this);
        }catch(Exception e){
            e.printStackTrace();
        }
    
    }
    
    public void agregarLibros(){
        try{
            AgregarLibrosController agregarLibros = (AgregarLibrosController)cambiarEscena("AgregarLibros.fxml", 800, 550);
            agregarLibros.setEscenarioPrincipal(this);
        }catch(Exception e){
            e.printStackTrace();
        }
    
    }
    
    public void menuProfesor(){
        try{
            MenuProfesorController menuProfesor = (MenuProfesorController)cambiarEscena("principalProfesor.fxml", 800, 550);
            menuProfesor.setEscenarioPrincipal(this);
        }catch(Exception e){
            e.printStackTrace();
        }
    
    }
    
    public void subirVideo(){
        try{
            VideoController video = (VideoController)cambiarEscena("subirVideosView.fxml", 800, 550);
            video.setEscenarioPrincipal(this);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void registrar(){
        try{
            RegistrarController registrar = (RegistrarController)cambiarEscena("principalRegistroView.fxml", 800, 550);
            registrar.setEscenarioPrincipal(this);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void registrarProfesor(){
        try{
            RegistrarProfesorController registrar = (RegistrarProfesorController)cambiarEscena("registrarseProfesor.fxml", 800, 550);
            registrar.setEscenarioPrincipal(this);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void registrarEstudiante(){
        try{
            RegistrarEstudianteController registrar = (RegistrarEstudianteController)cambiarEscena("registrarseEstudiante.fxml", 800, 550);
            registrar.setEscenarioPrincipal(this);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void menuEstudiante(){
        try{
            MenuEstudianteController menu = (MenuEstudianteController)cambiarEscena("menuEstudiantesView.fxml", 800, 550);
            menu.setEscenarioPrincipal(this);
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
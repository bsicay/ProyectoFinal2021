package org.proyectofinal.controller;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Pagination;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import org.proyectofinal.sistema.Principal;

public class BrailleController implements Initializable{
    private Principal escenarioPrincipal;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 @FXML private Button Bseleccionar;
	 @FXML private AnchorPane anchor;
	 @FXML private Pagination paginator;
	 File filesJPG[];
         ArrayList<String> images = new ArrayList<>();
        
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

                images.add("/org/proyectofinal/images/ImagenesBraille/a.jpg");
                images.add("/org/proyectofinal/images/ImagenesBraille/e.jpg");
                images.add("/org/proyectofinal/images/ImagenesBraille/i.png");
                images.add("/org/proyectofinal/images/ImagenesBraille/o.jpg");
                images.add("/org/proyectofinal/images/ImagenesBraille/u.jpg");
                images.add("/org/proyectofinal/images/ImagenesBraille/vproximamente.jpg");

                paginator.setPageFactory(n -> new ImageView(images.get(n)));

	}

	
	@FXML
	private void ButtonAction(ActionEvent event) {
		paginator.setPageFactory(n -> new ImageView(images.get(n)));
	}
	
	private void openDirectoryChooser(Stage parent) {
		DirectoryChooser directoryChooser= new DirectoryChooser();
		
		File selectedDirectory= directoryChooser.showDialog(parent);
		
		if(selectedDirectory != null)
		{
			FilenameFilter filterJPG= new FilenameFilter() {

				@Override
				public boolean accept(File dir, String name) {
					// TODO Auto-generated method stub
					return name.toLowerCase().endsWith(".jpg");
				}
			};
			
			filesJPG= selectedDirectory.listFiles(filterJPG);
		}
	}
	
	public VBox createPage(int index) {
		ImageView imageView= new ImageView();
		
		File file= filesJPG[index];
		try {
			BufferedImage bufferedImage= ImageIO.read(file);
			Image image= SwingFXUtils.toFXImage(bufferedImage, null);
			
			imageView.setImage(image);
			imageView.setFitWidth(400);
			imageView.setFitHeight(500);
			
			imageView.setSmooth(true);
			imageView.setCache(true);
		}
		
		catch(IOException ex) {
			
		}
		
		VBox pageBox= new VBox();
		pageBox.getChildren().add(imageView);
		
		return pageBox;
	}

        public void login(){
            escenarioPrincipal.menuEstudiante();
        }
    public Principal getEscenarioPrincipal() {
        return escenarioPrincipal;
    }

    public void setEscenarioPrincipal(Principal escenarioPrincipal) {
        this.escenarioPrincipal = escenarioPrincipal;
    }
        
        
}

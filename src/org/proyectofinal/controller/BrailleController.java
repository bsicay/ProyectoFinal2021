package otro;

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
import java.util.ResourceBundle;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class BrailleController implements Initializable{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 @FXML private Button Bseleccionar;
	 @FXML private AnchorPane anchor;
	 @FXML private Pagination pagination;
	 File filesJPG[];
	 
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub	
	}

	
	@FXML
	private void ButtonAction(ActionEvent event) {
		Stage stage= (Stage) anchor.getScene().getWindow();
		openDirectoryChooser(stage);
		
		pagination.setPageFactory(new Callback<Integer, Node> ()
			{public Node call(Integer pageIndex) {
				return createPage(pageIndex);
			}
			
			}
		);
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
}

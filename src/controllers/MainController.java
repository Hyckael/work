package controllers;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import animatefx.animation.*;

public class MainController implements Initializable{
	
		

	 	@FXML
	    private VBox PageInsFinal;

	    @FXML
	    private BorderPane anchoroot;

	    @FXML
	    private Button btnBack;

	    @FXML
	    private Button btnBack1;

	    @FXML
	    private Button btnCo;

	    @FXML
	    private Button btnForget;

	    @FXML
	    private Button btnIns;

	    @FXML
	    private Button btnInsNext;

	    @FXML
	    private Button btnInsValid;

	    @FXML
	    private VBox pageCo;

	    @FXML
	    private VBox pageIns;

	    @FXML
	    private StackPane pageStack;

	    @FXML
	    private PasswordField txtMdpInsVerif;

	    @FXML
	    private PasswordField txtMpdIns;

	    @FXML
	    private TextField txtNom;

	    @FXML
	    private TextField txtNumero;

	    @FXML
	    private PasswordField txtPassCo;

	    @FXML
	    private TextField txtPrenom;

	    @FXML
	    private TextField txtUsername;

	    @FXML
	    private TextField txtUsernameCo;


    @FXML
    void handleButtonAction(ActionEvent event) throws IOException {
    	if (event.getSource().equals(btnCo)) {
    		anchoroot.getScene().getWindow().hide();
    		Parent root = FXMLLoader.load(getClass().getResource("/interfaces/Acceuil.fxml"));
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			Image image = new Image("/assets/icons8_rolls_royce_512px.png");
			stage.getIcons().add(image);
			stage.setTitle("Acceuil");
			stage.setScene(scene);
			stage.show();
    	}
    	if (event.getSource().equals(btnIns)) {
    		new ZoomOut(pageCo).play();
			pageIns.toFront();
			new BounceInRight(pageIns).play();
		}
    	if (event.getSource().equals(btnInsNext)) {
			PageInsFinal.toFront();
			new BounceInRight(PageInsFinal).play();
		}
    	if (event.getSource().equals(btnInsValid)) {
    		new ZoomIn(pageCo).play();
			pageCo.toFront();
		}
    }
    
    @FXML
    void goBack(MouseEvent event) {
    	if (event.getSource().equals(btnBack)) {
    		new ZoomIn(pageCo).play();
			pageCo.toFront();
		}
    	if (event.getSource().equals(btnBack1)) {
    		pageIns.toFront();
			new BounceInLeft(pageIns).play();
		}
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}

   
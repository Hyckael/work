package controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ClientsController {

    @FXML
    private Button btnAjoutClient;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnModifClient;

    @FXML
    private Button btnSuppclient;

    @FXML
    private TableColumn<?, ?> colnmContact;

    @FXML
    private TableColumn<?, ?> colnmDom;

    @FXML
    private TableColumn<?, ?> colnmId;

    @FXML
    private TableColumn<?, ?> colnmNom;

    @FXML
    private TableColumn<?, ?> colnmNum;

    @FXML
    private TableColumn<?, ?> colnmPrenom;

    @FXML
    private TextField contactClient;

    @FXML
    private TextField domicileClient;

    @FXML
    private Label idClient;

    @FXML
    private TextField nomClient;

    @FXML
    private TextField numCni;

    @FXML
    private BorderPane pageClients;

    @FXML
    private TextField prenomClient;

    @FXML
    private TextField rechercher;

    @FXML
    void goBack(MouseEvent event) throws IOException {
    	if (event.getSource().equals(btnBack)) {
    		pageClients.getScene().getWindow().hide();
    		Parent root = FXMLLoader.load(getClass().getResource("/interfaces/Acceuil.fxml"));
    		Scene scene = new Scene(root);
    		Stage stage = new Stage();
    		Image image = new Image("/assets/icons8_connect_develop_512px.png");
			stage.getIcons().add(image);
			stage.setTitle("Acceuil");
    		stage.setScene(scene);
    		stage.show();
    	}
    }
    @FXML
    void ajouterClient(ActionEvent event) {

    }


    @FXML
    void modifierClient(ActionEvent event) {

    }

    @FXML
    void supprimerClient(ActionEvent event) {

    }

}

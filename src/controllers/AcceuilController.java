package controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class AcceuilController {

    @FXML
    private Button btnBack;

    @FXML
    private Button btnGestClient;

    @FXML
    private Button btnGestMat;

    @FXML
    private Button btnGestStock;

    @FXML
    private Button btnHelp;

    @FXML
    private Button btnHist;

    @FXML
    private Button btnReserv;
    
    @FXML
    private BorderPane pageAccueil;

    @FXML
    void goBack(MouseEvent event) throws IOException {
    	if (event.getSource().equals(btnBack)) {
    		pageAccueil.getScene().getWindow().hide();
    		Parent root = FXMLLoader.load(getClass().getResource("/interfaces/Main.fxml"));
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			Image image = new Image("/assets/icons8_rolls_royce_512px.png");
			stage.getIcons().add(image);
			stage.setScene(scene);
			stage.show();
    	}
    }

    @FXML
    void goClientPage(ActionEvent event) throws IOException {
    	if (event.getSource().equals(btnGestClient)) {
    		pageAccueil.getScene().getWindow().hide();
    		Parent root = FXMLLoader.load(getClass().getResource("/interfaces/PageClients.fxml"));
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			Image image = new Image("/assets/icons8_rolls_royce_512px.png");
			stage.getIcons().add(image);
			stage.setTitle("Clients");
			stage.setScene(scene);
			stage.show();
    	}

    }

    @FXML
    void goHelpPage(ActionEvent event) throws IOException {
    	if (event.getSource().equals(btnHelp)) {
    		pageAccueil.getScene().getWindow().hide();
    		Parent root = FXMLLoader.load(getClass().getResource("/interfaces/PageAide.fxml"));
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			Image image = new Image("/assets/icons8_rolls_royce_512px.png");
			stage.getIcons().add(image);
			stage.setTitle("Aide");
			stage.setScene(scene);
			stage.show();
    	}

    }

    @FXML
    void goHistoryPage(ActionEvent event) throws IOException {
    	if (event.getSource().equals(btnHist)) {
    		pageAccueil.getScene().getWindow().hide();
    		Parent root = FXMLLoader.load(getClass().getResource("/interfaces/PageHistorique.fxml"));
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			Image image = new Image("/assets/icons8_rolls_royce_512px.png");
			stage.getIcons().add(image);
			stage.setTitle("Historique");
			stage.setScene(scene);
			stage.show();
    	}

    }

    @FXML
    void goMaterielPage(ActionEvent event) throws IOException {
    	if (event.getSource().equals(btnGestMat)) {
    		pageAccueil.getScene().getWindow().hide();
    		Parent root = FXMLLoader.load(getClass().getResource("/interfaces/PageMateriel.fxml"));
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			Image image = new Image("/assets/icons8_rolls_royce_512px.png");
			stage.getIcons().add(image);
			stage.setTitle("Matériels");
			stage.setScene(scene);
			stage.show();
    	}

    }

    @FXML
    void goReservPage(ActionEvent event) throws IOException {
    	if (event.getSource().equals(btnReserv)) {
    		pageAccueil.getScene().getWindow().hide();
    		Parent root = FXMLLoader.load(getClass().getResource("/interfaces/PageReservation.fxml"));
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			Image image = new Image("/assets/icons8_rolls_royce_512px.png");
			stage.getIcons().add(image);
			stage.setTitle("Réservations");
			stage.setScene(scene);
			stage.show();
    	}

    }

    @FXML
    void goStockPage(ActionEvent event) throws IOException {
    	if (event.getSource().equals(btnGestStock)) {
    		pageAccueil.getScene().getWindow().hide();
    		Parent root = FXMLLoader.load(getClass().getResource("/interfaces/PageStock.fxml"));
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			Image image = new Image("/assets/icons8_rolls_royce_512px.png");
			stage.getIcons().add(image);
			stage.setTitle("Stock");
			stage.setScene(scene);
			stage.show();
    	}

    }

}

package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import com.dao.IMaterielDoa;
import com.dao.MaterielDao;
import com.model.Materiel;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;



public class MaterielController implements Initializable {

	@ManyToOne(fetch = FetchType.LAZY)
	
    @FXML
    private Button btnBack;

    @FXML
    private BorderPane pageProduit;
    
    @FXML
    private Button btnAjoutMat;

    @FXML
    private Button btnModifMat;
    
    @FXML
    private Button btnRefresh;

    @FXML
    private Button btnSuppMat;
    
    @FXML
    private TableColumn<Materiel, String> colnDescMat;

    @FXML
    private TableColumn<?, ?> colnIdMat;

    @FXML
    private TableColumn<?, ?> colnNomMat;

    @FXML
    private TableColumn<Materiel, Float> colnPrixMat;

    @FXML
    private TableColumn<Materiel, Integer> colnQuantityMat;
    
    @FXML
    private TableView<Materiel> materielTable;

    @FXML
    private TextField descMateriel;

    @FXML
    private TextField idMat;

    @FXML
    private TextField nomMateriel;

    @FXML
    private TextField prixMateriel;

    @FXML
    private TextField quantiteMateriel;
    
    @FXML
    private TextField rechercher;
    
    private ObservableList<Materiel> addMaterielList;
    
    IMaterielDoa materielDoa = new MaterielDao();
    
	Materiel materiels = new Materiel();
	
	float price;
	int quantity;
	int idMateriel;
	int id;
	
	public void clearMateriel() {
		nomMateriel.setText("");
		descMateriel.setText("");
		prixMateriel.setText("");
		quantiteMateriel.setText("");
	}
	
    @FXML
    void ajouterMateriel(ActionEvent event) {
    	
    	Alert alert;
    	
    	
    	
		if (nomMateriel.getText().isEmpty() || descMateriel.getText().isEmpty() || prixMateriel.getText().isEmpty() || quantiteMateriel.getText().isEmpty()) {
			alert = new Alert(AlertType.ERROR);
			alert.setTitle("Attention !!!");
			alert.setHeaderText(null);
			alert.setContentText("Remplissez tous les champs s'il vous plait !");
			alert.showAndWait();
		} else if (prixMateriel.getText().matches("[+-]?\\d*(\\.\\d+)?") == false || quantiteMateriel.getText().matches("[+-]?\\d*(\\.\\d+)?") == false) {
			alert = new Alert(AlertType.ERROR);
			alert.setTitle("Attention !!!");
			alert.setHeaderText(null);
			alert.setContentText("Entrer des nombres valides s'il vous plait !");
			alert.showAndWait();
		}
		else {
			Boolean verif = false;
			for (Materiel e : materielDoa.getAllmateriel()) {
				if (e.getNomMateriel().equalsIgnoreCase(nomMateriel.getText())) {
					verif = true;
				}
			}
			if (verif == true) {
				alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error Message");
				alert.setHeaderText(null);
				alert.setContentText("Le matériel : " + nomMateriel.getText() + " exite déjà. Entrer un autre nom matériel !");
				alert.showAndWait();
			} else {
//				idMateriel = Integer.parseInt(idMat.getText());
				materiels.setNomMateriel(nomMateriel.getText());
		    	materiels.setDescMateriel(descMateriel.getText());
		    	price = Float.parseFloat(prixMateriel.getText());
		    	quantity = Integer.parseInt(quantiteMateriel.getText());
		    	materiels.setPrix(price);
		    	materiels.setQuantite(quantity);

		    	materielDoa.savemateriel(materiels);
				System.out.println("====== Enregistremment Effectué ======");
				

				alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Félicitation !!!");
				alert.setHeaderText(null);
				alert.setContentText("Matériel : " + nomMateriel.getText() + " est enregistré avec success !");
				alert.showAndWait();
				clearMateriel();
				materielShowList();
			}
			materielShowList();
//			System.out.println(verif);
		}
    }
    
    void materielShowList() {
    	addMaterielList = materielDoa.addMaterielList();
    	
    	colnIdMat.setCellValueFactory(new PropertyValueFactory<>("idMateriel"));
    	colnNomMat.setCellValueFactory(new PropertyValueFactory<>("nomMateriel"));
    	colnDescMat.setCellValueFactory(new PropertyValueFactory<>("descMateriel"));
    	colnPrixMat.setCellValueFactory(new PropertyValueFactory<>("prix"));
    	colnQuantityMat.setCellValueFactory(new PropertyValueFactory<>("quantite"));
    	
    	materielTable.setItems(addMaterielList);
    	
    }
    
    

    @FXML
    void goBack(MouseEvent event) throws IOException {
    	if (event.getSource().equals(btnBack)) {
    		pageProduit.getScene().getWindow().hide();
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
    
    public void materielSelected() {
		Materiel materiel = materielTable.getSelectionModel().getSelectedItem();

		Integer num = materielTable.getSelectionModel().getSelectedIndex();

		if (num - 1 < -1) {
			return;
		}
		nomMateriel.setText(materiel.getNomMateriel());
		descMateriel.setText(materiel.getDescMateriel());
		prixMateriel.setText(String.valueOf(materiel.getPrix()));
		quantiteMateriel.setText(String.valueOf(materiel.getQuantite()));
	}
    
    @FXML
    void modifierMateriel(ActionEvent event) {
    	Alert alert;
		if (nomMateriel.getText().isEmpty() || descMateriel.getText().isEmpty() || prixMateriel.getText().isEmpty() || quantiteMateriel.getText().isEmpty()) {
			alert = new Alert(AlertType.ERROR);
			alert.setTitle("Attention !!!");
			alert.setHeaderText(null);
			alert.setContentText("Remplissez tous les champs s'il vous plait ");
			alert.showAndWait();
		} else if (prixMateriel.getText().matches("[+-]?\\d*(\\.\\d+)?") == false || quantiteMateriel.getText().matches("[+-]?\\d*(\\.\\d+)?") == false) {
			alert = new Alert(AlertType.ERROR);
			alert.setTitle("Attention !!!");
			alert.setHeaderText(null);
			alert.setContentText("Entrer des nombres valides s'il vous plait !");
			alert.showAndWait();
		}else {
			alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("CONFIRMATION MESSAGE");
			alert.setHeaderText(null);
			alert.setContentText("Voulez-vous vraiment modifier les Informations du matériel : "+ nomMateriel.getText() + " ?");
			Optional<ButtonType> option = alert.showAndWait();
			if (option.get().equals(ButtonType.OK)) {
				for (Materiel e : materielDoa.getAllmateriel()) {
					if (e.getNomMateriel().equals(nomMateriel.getText())) {
						e.setNomMateriel(nomMateriel.getText());
						e.setDescMateriel(descMateriel.getText());
						price = Float.parseFloat(prixMateriel.getText());
				    	quantity = Integer.parseInt(quantiteMateriel.getText());
						e.setPrix(price);
						e.setQuantite(quantity);
						materielDoa.updatemateriel(e);
					}
				}

				alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Félicitation !!!");
				alert.setHeaderText(null);
				alert.setContentText("Produit: " + nomMateriel.getText() + " a été modifié et enregistré avec success !");
				alert.showAndWait();
				clearMateriel();
				materielShowList();
			}
		}
    }

    @FXML
    void supprimerMateriel(ActionEvent event) {
    	Alert alert;
		if (nomMateriel.getText().isEmpty()) {
			alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText("Selectionner la ligne dans la tableau !");
			Optional<ButtonType> option = alert.showAndWait();
		} else {
			Boolean verif = false;
			int id = 0;
			for (Materiel e : materielDoa.getAllmateriel()) {
				if (e.getNomMateriel().equals(nomMateriel.getText())) {
					verif = true;
					id = e.getIdMateriel();
				}
			}
			if (verif == true) {
				alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("CONFIRMATION MESSAGE");
				alert.setHeaderText(null);
				alert.setContentText("Êtes-vous sûr de vouloir supprimer le Matériel : " + nomMateriel.getText()+ " ? Cette action est irreversible");
				Optional<ButtonType> option = alert.showAndWait();
				if (option.get().equals(ButtonType.OK)) {
					materielDoa.deletemateriel(id);
					clearMateriel();
					materielShowList();				}
			} else {
				alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText(null);
				alert.setContentText("Le Matériel: " + nomMateriel.getText() + " n'existe pas ");
				alert.showAndWait();
				return;
			}
		}
    }
    
    @FXML
    void refresh(MouseEvent event) throws IOException {
    	if (event.getSource().equals(btnRefresh)) {
    		clearMateriel();
    		materielShowList();
    	}
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		materielShowList();
	}

}

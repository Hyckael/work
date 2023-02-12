package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import com.dao.ClientDao;
import com.dao.IClientDoa;
import com.model.Client;
import com.model.Materiel;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ClientsController implements Initializable{
	
	@ManyToOne(fetch = FetchType.LAZY)
    @FXML
    private Button btnAjoutClient;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnModifClient;

    @FXML
    private Button btnSuppclient;

    @FXML
    private TableView<Client> clientTable;
    
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
    
 private ObservableList<Client> addClientList;
    
    IClientDoa clientDoa = new ClientDao();
    
	Client clients = new Client();
	
	public void clearClient() {
		nomClient.setText("");
		numCni.setText("");
		domicileClient.setText("");
		contactClient.setText("");
		prenomClient.setText("");
	}

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

    	Alert alert;
		if (nomClient.getText().isEmpty() || prenomClient.getText().isEmpty() || contactClient.getText().isEmpty() || domicileClient.getText().isEmpty() || numCni.getText().isEmpty()) {
			alert = new Alert(AlertType.ERROR);
			alert.setTitle("Attention !!!");
			alert.setHeaderText(null);
			alert.setContentText("Remplissez tous les champs s'il vous plait !");
			alert.showAndWait();
		} else {
			Boolean verif = false;
			for (Client e : clientDoa.getAllSclient()) {
				if (e.getNomClient().equalsIgnoreCase(nomClient.getText())) {
					verif = true;
				}
			}
			if (verif == true) {
				alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error Message");
				alert.setHeaderText(null);
				alert.setContentText("Le Client : " + nomClient.getText() + " exite déja. Entrer un autre nom Client !");
				alert.showAndWait();
			} else {
//				idMateriel = Integer.parseInt(idMat.getText());
				clients.setNomClient(nomClient.getText());
				clients.setPrenom(prenomClient.getText());
				clients.setContactClient(contactClient.getText());
				clients.setDomicileClient(domicileClient.getText());
				clients.setCodeCni(numCni.getText());
				

		    	clientDoa.saveclient(clients);
				System.out.println("====== Enregistremment Effectué ======");
				

				alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Félicitation !!!");
				alert.setHeaderText(null);
				alert.setContentText("Client : " + nomClient.getText() + " est enregistré avec success !");
				alert.showAndWait();
				clearClient();
				clientShowList();
			}
			clientShowList();
//			System.out.println(verif);
		}
    }
    
    void clientShowList() {
    	addClientList = clientDoa.addClientList();
    	
    	colnmId.setCellValueFactory(new PropertyValueFactory<>("idClient"));
    	colnmNom.setCellValueFactory(new PropertyValueFactory<>("nomClient"));
    	colnmPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
    	colnmContact.setCellValueFactory(new PropertyValueFactory<>("contactClient"));
    	colnmDom.setCellValueFactory(new PropertyValueFactory<>("domicileClient"));
    	colnmNum.setCellValueFactory(new PropertyValueFactory<>("codeCni"));
    	
    	clientTable.setItems(addClientList);
    	
    }
    
    public void clienSelected() {
  		Client client = clientTable.getSelectionModel().getSelectedItem();

  		Integer num = clientTable.getSelectionModel().getSelectedIndex();

  		if (num - 1 < -1) {
  			return;
  		}
  		nomClient.setText(client.getNomClient());
  		prenomClient.setText(client.getPrenom());
  		contactClient.setText(client.getContactClient());
  		domicileClient.setText(client.getDomicileClient());
  		numCni.setText(client.getCodeCni());
  		
  	}
    

    @FXML
    void modifierClient(ActionEvent event) {
    	Alert alert;
		if (nomClient.getText().isEmpty() || prenomClient.getText().isEmpty() || contactClient.getText().isEmpty() || domicileClient.getText().isEmpty() || numCni.getText().isEmpty()) {
			alert = new Alert(AlertType.ERROR);
			alert.setTitle("Attention !!!");
			alert.setHeaderText(null);
			alert.setContentText("Remplissez tous les champs s'il vous plait ");
			alert.showAndWait();
		} else if (contactClient.getText().matches("[+-]?\\d*(\\.\\d+)?") == false || numCni.getText().matches("[+-]?\\d*(\\.\\d+)?") == false) {
			alert = new Alert(AlertType.ERROR);
			alert.setTitle("Attention !!!");
			alert.setHeaderText(null);
			alert.setContentText("Entrer des numéros valides s'il vous plait !");
			alert.showAndWait();
		}else {
			alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("CONFIRMATION MESSAGE");
			alert.setHeaderText(null);
			alert.setContentText("Voulez-vous vraiment modifier les Informations du client : "+ nomClient.getText() + " ?");
			Optional<ButtonType> option = alert.showAndWait();
			if (option.get().equals(ButtonType.OK)) {
				for (Client c : clientDoa.getAllSclient()) {
					if (c.getNomClient().equals(nomClient.getText())) {
						c.setPrenom(prenomClient.getText());
						c.setContactClient(contactClient.getText());
						c.setDomicileClient(domicileClient.getText());
						c.setCodeCni(numCni.getText());
						clientDoa.updateclient(c);
					}
				}

				alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Félicitation !!!");
				alert.setHeaderText(null);
				alert.setContentText("Client: " + nomClient.getText() + " a été modifié et enregistré avec success !");
				alert.showAndWait();
				clearClient();
				clientShowList();
			}
		}
    }

    @FXML
    void supprimerClient(ActionEvent event) {
    	Alert alert;
		if (nomClient.getText().isEmpty()) {
			alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText("Selectionner la ligne dans la tableau !");
			Optional<ButtonType> option = alert.showAndWait();
		} else {
			Boolean verif = false;
			int id = 0;
			for (Client c : clientDoa.getAllSclient()) {
				if (c.getNomClient().equals(nomClient.getText())) {
					verif = true;
					id = c.getIdClient();
				}
			}
			if (verif == true) {
				alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("CONFIRMATION MESSAGE");
				alert.setHeaderText(null);
				alert.setContentText("Êtes-vous sûr de vouloir supprimer le Client : " + nomClient.getText()+ " ? Cette action est irreversible");
				Optional<ButtonType> option = alert.showAndWait();
				if (option.get().equals(ButtonType.OK)) {
					clientDoa.deleteclient(id);
					clearClient();
					clientShowList();				}
			} else {
				alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText(null);
				alert.setContentText("Le Client: " + nomClient.getText() + " n'existe pas ");
				alert.showAndWait();
				return;
			}
		}
    }
    
    /*@FXML
    void refresh(MouseEvent event) throws IOException {
    	if (event.getSource().equals(btnRefresh)) {
    		clearClient();
    		clientShowList();
    	}
    }
*/
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		clientShowList();
	}

}

package com.dao;

import java.util.List;

import com.model.Client;

import javafx.collections.ObservableList;


public interface IClientDoa {

 void saveclient(Client client);

 void updateclient(Client client);

 Client getclientById(int idClient);

 List<Client> getAllSclient();

 void deleteclient(int idClient);
 
 List <Client> rechercher(String nomClient);
 
//méthode permettant de recuperer la liste des fournisseur dans la base de donnée 

ObservableList<Client> addClientList();
}

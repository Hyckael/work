package com.dao;

import java.util.List;

import com.model.Materiel;

import javafx.collections.ObservableList;


public interface IMaterielDoa {

 void savemateriel(Materiel materiel);

 void updatemateriel(Materiel materiel);

 Materiel getmaterielById(int idMateriel);

 List<Materiel> getAllmateriel();

 void deletemateriel(int idMateriel);
 
 List <Materiel> rechercher(String nomMateriel);
 
//méthode permettant de recuperer la liste des fournisseur dans la base de donnée 
ObservableList<Materiel> addMaterielList();
}

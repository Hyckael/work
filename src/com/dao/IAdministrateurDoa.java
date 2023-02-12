package com.dao;

import java.util.List;

import com.model.Administrateur;

import javafx.collections.ObservableList;


public interface IAdministrateurDoa {

 void saveAdministrateur(Administrateur admin);

 void updateAdministrateur(Administrateur admin);

 Administrateur getadministrateurById(int idAdmin);

 List<Administrateur> getAllSadmin();

 void deleteadministrateur(int idAdmin);
 
 List <Administrateur> rechercher(String nom);
 
//méthode permettant de recuperer la liste des fournisseur dans la base de donnée 
ObservableList<Administrateur> addAdministrateurList();
}

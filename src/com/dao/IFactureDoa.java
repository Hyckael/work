package com.dao;

import java.util.List;

import com.model.Facture;
import javafx.collections.ObservableList;


public interface IFactureDoa {

 void savefacture(Facture facture);

 void updatefacture(Facture facture);

 Facture getfactureById(int idFacture);

 List<Facture> getAllSfacture();

 void deletefacture(int idFacture);
 
 //List <Facture> rechercher(String montantAnvance);
 
//méthode permettant de recuperer la liste des fournisseur dans la base de donnée 
ObservableList<Facture> addFactureList();
}

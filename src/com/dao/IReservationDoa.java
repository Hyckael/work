package com.dao;

import java.util.List;

import com.model.Reservation;

import javafx.collections.ObservableList;


public interface IReservationDoa {

 void savemateriel(Reservation reservation);

 void updatemateriel(Reservation reservation);

 Reservation getreservationById(int idReservation);

 List<Reservation> getAllSreservation();

 void deletereservation(int idReservation);
 
 //List <Reservation> rechercher(String nomMateriel);
 
//méthode permettant de recuperer la liste des fournisseur dans la base de donnée 
ObservableList<Reservation> addReservationList();
}

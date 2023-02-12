package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;


import com.model.Materiel;
import com.model.Reservation;
import com.util.HibernateUtil;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ReservationDao implements IReservationDoa {

	private Connection connect;

	private PreparedStatement prepare;

	private ResultSet result;
	
    // save Student
    // get All Students
    // get Student By Id
    // Update Student
    // Delete Student

	/*@Override
	public List<Materiel> rechercher(String nomMateriel) {
		Transaction transaction = null;
        List < Materiel > materiel = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start the transaction
            transaction = session.beginTransaction();

            // get students
           // students = session.createQuery("from Student").list();
            materiel = session.createSQLQuery(nomMateriel).addEntity(getClass()).list();
            //student = session.load(Student.class, id);
            // commit the transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
		return null;
	}
*/

	@SuppressWarnings("unchecked")

	@Override
	public void savemateriel(Reservation reservation) {
		// TODO Auto-generated method stub
				Transaction transaction = null;
		        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
		            // start the transaction
		            transaction = session.beginTransaction();

		            // save student object
		            session.save(reservation);

		            // commit the transaction
		            transaction.commit();
		        } catch (Exception e) {
		            if (transaction != null) {
		                transaction.rollback();
		            }
		        }
	}


	@Override
	public void updatemateriel(Reservation reservation) {
		// TODO Auto-generated method stub
		Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start the transaction
            transaction = session.beginTransaction();

            // save student object
            session.saveOrUpdate(reservation);

            // commit the transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
		
		
	}


	@Override
	public Reservation getreservationById(int idReservation) {
		// TODO Auto-generated method stub
				Transaction transaction = null;
		        Reservation reservation = null;
		        try {
					Session session = HibernateUtil.getSessionFactory().openSession();
					    // start the transaction
					    transaction = session.beginTransaction();

					    // get student object
					    reservation= session.byId(Reservation.class).getReference(idReservation);
					     // or student = session.get(Student.class, id);
					    //or student = session.load(Student.class, id);
					   //or commit the transaction
					    transaction.commit();
				} catch (Exception e) {
					if (transaction != null) {
		                transaction.rollback();
				}
					
				}
		        
		        
		        return reservation;
	}


	@Override
	public List<Reservation> getAllSreservation() {
		// TODO Auto-generated method stub
				Transaction transaction = null;
		        List < Reservation > reservation = null;
		        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
		            // start the transaction
		            transaction = session.beginTransaction();

		            // get matériel
		            reservation = session.createQuery("from reservation").list();
		            
		            transaction.commit();
		        } catch (Exception e) {
		            if (transaction != null) {
		                transaction.rollback();
		            }
		        }
		        return reservation;
	}


	@Override
	public void deletereservation(int idReservation) {
		Transaction transaction = null;
        Reservation reservation = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start the transaction
            transaction = session.beginTransaction();

            reservation  = session.get(Reservation.class, idReservation);
            // get student object
            session.delete(reservation);
            //student = session.load(Student.class, id);
            // commit the transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
		
	}


	@Override
	public ObservableList<Reservation> addReservationList() {
		ObservableList<Reservation> listReservation = FXCollections.observableArrayList();

		String sql = "SELECT * FROM reservation";

		connect = Database.connectDb();

		try {

			Reservation reservation;

			prepare = connect.prepareStatement(sql);

			result = prepare.executeQuery();

			while (result.next()) {
				reservation = new Reservation(result.getInt("ID_CLIENT"),result.getInt("ID_MATERIEL "), result.getDate("DATE_DEBUT_RESERVATION"), result.getDate("DATE_FIN_RESERVATION"),result.getInt("QUANTITE_RESERVEE"));
				listReservation .add(reservation);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listReservation;
	}


	
	/*
	 * public List<Student > recupererCommandeByDateAndMenu(String idMenu , Date
	 * dateCommande){ String query =
	 * "SELECT `commande`.`DATECOMMANDE` FROM `commande` WHERE ((`commande`.`ID_MENU` = "
	 * +idMenu+") AND (`commande`.`DATECOMMANDE` ='"+dateCommande+"'))"; //String
	 * query = "SELECT * FROM `` WHERE ((`CODETYPE_LOGEMENT`='"
	 * +typeLogement+"') AND (`CODE_TYPENATIONALITE` ='"
	 * +typeNationalite+"') AND (`CODE_ANNEES`='"+codeAnne+"'))";
	 * 
	 * Commande commande = session.createSQLQuery().addEntity(getClass()).list();
	 * (TypeLogementNationalite)
	 * getSessionFactory().getCurrentSession().createSQLQuery(query).addEntity(
	 * TypeLogementNationalite.class).uniqueResult(); return object; }
	 */
    
    
    
}

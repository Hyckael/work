package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.model.Facture;
import com.util.HibernateUtil;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FactureDao implements IFactureDoa {

	private Connection connect;

	private PreparedStatement prepare;

	private ResultSet result;
	
    // save Student
    // get All Students
    // get Student By Id
    // Update Student
    // Delete Student
    @SuppressWarnings("unchecked")

	/*@Override
	public List<Facture> rechercher(String montantAnvance) {
		Transaction transaction = null;
        List < Facture > montantAnvance = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start the transaction
            transaction = session.beginTransaction();

            // get students
           // students = session.createQuery("from Student").list();
            montantAnvance = session.createSQLQuery(montantAnvance).addEntity(getClass()).list();
            //student = session.load(Student.class, id);
            // commit the transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
		return null;
	}*/


	@Override
	public void savefacture(Facture facture) {
		// TODO Auto-generated method stub
		Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start the transaction
            transaction = session.beginTransaction();

            // save student object
            session.save(facture);

            // commit the transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
	}


	@Override
	public void updatefacture(Facture facture) {
		// TODO Auto-generated method stub
		Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start the transaction
            transaction = session.beginTransaction();

            // save student object
            session.saveOrUpdate(facture);

            // commit the transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
		
	}


	@Override
	public Facture getfactureById(int idFacture) {
		// TODO Auto-generated method stub
		Transaction transaction = null;
        Facture facture = null;
        try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			    // start the transaction
			    transaction = session.beginTransaction();

			    // get student object
			    facture= session.byId(Facture.class).getReference(idFacture);
			     // or student = session.get(Student.class, id);
			    //or student = session.load(Student.class, id);
			   //or commit the transaction
			    transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
                transaction.rollback();
		}
			
		}
        
        
        return facture;
	}


	@Override
	public List<Facture> getAllSfacture() {
		// TODO Auto-generated method stub
		Transaction transaction = null;
        List < Facture > facture = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start the transaction
            transaction = session.beginTransaction();

            // get matériel
            facture = session.createQuery("from facture").list();
            
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return facture;
	}


	@Override
	public void deletefacture(int idFacture) {
		Transaction transaction = null;
        Facture facture = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start the transaction
            transaction = session.beginTransaction();

            facture = session.get(Facture.class, idFacture);
            // get student object
            session.delete(facture);
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
	public ObservableList<Facture> addFactureList() {
		ObservableList<Facture> listFacture = FXCollections.observableArrayList();

		String sql = "SELECT * FROM facture";

		connect = Database.connectDb();

		try {

			Facture facture;

			prepare = connect.prepareStatement(sql);

			result = prepare.executeQuery();

			while (result.next()) {
				facture = new Facture(result.getInt("ID_RESERVATION"),result.getFloat("AMENDE"),result.getFloat("MONTANT_AVANCE"),result.getDate("DATE_AVANCE"),result.getDate("DATE_FIN_PAIEMENT"),result.getFloat("MONTATNT_A_PAYER"),result.getString("INTITULE_AMENDE"),result.getDate("DATE_LIVRAISON"),result.getString("LIEU_LIVRAISON"),result.getString("LIVRER"),result.getFloat("RESTE_A_PAYER"),result.getString("RETOURNER"),result.getString("ETAT_MATERIEL"),result.getDate("DATE_RETOUR"));
				listFacture.add(facture);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listFacture;
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

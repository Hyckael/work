package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.model.Client;
import com.model.Materiel;
import com.util.HibernateUtil;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ClientDao implements IClientDoa {

	private Connection connect;

	private PreparedStatement prepare;

	private ResultSet result;
	
	
    // save Student
    // get All Students
    // get Student By Id
    // Update Student
    // Delete Student
    @SuppressWarnings("unchecked")

	@Override
	public List<Client> rechercher(String nomClient) {
		Transaction transaction = null;
        List < Materiel > client = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start the transaction
            transaction = session.beginTransaction();

            // get students
           // students = session.createQuery("from Student").list();
            client = session.createSQLQuery(nomClient).addEntity(getClass()).list();
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


	@SuppressWarnings("unchecked")


	@Override
	public ObservableList<Client> addClientList() {
		ObservableList<Client> listClient = FXCollections.observableArrayList();

		String sql = "SELECT * FROM client";

		connect = Database.connectDb();

		try {

			Client client;

			prepare = connect.prepareStatement(sql);

			result = prepare.executeQuery();

			while (result.next()) {
				client = new Client(result.getInt("ID_CLIENT"),result.getString("NOM_CLIENT"), result.getString("PRENOM_"),result.getString("CONTACT_CLIENT"), result.getString("DOMICILE_CLIENT"),result.getString("CODE_CNI"));
				listClient.add(client);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listClient;
	}


	@Override
	public void saveclient(Client client) {
		// TODO Auto-generated method stub
				Transaction transaction = null;
		        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
		            // start the transaction
		            transaction = session.beginTransaction();

		            // save student object
		            session.save(client);

		            // commit the transaction
		            transaction.commit();
		        } catch (Exception e) {
		            if (transaction != null) {
		                transaction.rollback();
		            }
		       }
	}


	@Override
	public void updateclient(Client client) {
		// TODO Auto-generated method stub
		Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(client);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
		
	}


	@Override
	public Client getclientById(int idClient) {
		// TODO Auto-generated method stub
		Transaction transaction = null;
        Client client = null;
        try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			    // start the transaction
			    transaction = session.beginTransaction();

			    // get student object
			    client= session.byId(Client.class).getReference(idClient);
			     // or student = session.get(Student.class, id);
			    //or student = session.load(Student.class, id);
			   //or commit the transaction
			    transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
                transaction.rollback();
		}
			
		}
        
        
        return client;
	}


	@Override
	public List<Client> getAllSclient() {
		// TODO Auto-generated method stub
		 Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		 session.beginTransaction();
		 List<Client> result = session.createQuery("from Client", Client.class).getResultList();
		 session.getTransaction().commit();
		 return result;
	}


	@Override
	public void deleteclient(int idClient) {
		// TODO Auto-generated method stub
		Transaction transaction = null;
        Client client = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start the transaction
            transaction = session.beginTransaction();

            client = session.get(Client.class, idClient);
            // get student object
            session.delete(client);
            //student = session.load(Student.class, id);
            // commit the transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
		
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

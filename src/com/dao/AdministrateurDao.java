package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.model.Administrateur;
import com.model.Materiel;
import com.util.HibernateUtil;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AdministrateurDao implements IAdministrateurDoa {

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
	public List<Administrateur> rechercher(String nom) {
		Transaction transaction = null;
        List < Administrateur > admin = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start the transaction
            transaction = session.beginTransaction();

            // get students
           // students = session.createQuery("from Student").list();
            admin = session.createSQLQuery(nom).addEntity(getClass()).list();
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

	@Override
	@SuppressWarnings("unchecked")
	public List<Administrateur> getAllSadmin() {
		// TODO Auto-generated method stub
		Transaction transaction = null;
        List < Administrateur > admin = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start the transaction
            transaction = session.beginTransaction();

            // get admin
            admin = session.createQuery("from administrateur").list();
            
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return admin;
	}

	@Override
	public void deleteadministrateur(int idAdmin) {
		Transaction transaction = null;
        Administrateur admin = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start the transaction
            transaction = session.beginTransaction();

            admin = session.get(Administrateur.class, idAdmin);
            // get student object
            session.delete(admin);
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
	public void saveAdministrateur(Administrateur admin) {
		// TODO Auto-generated method stub
		Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start the transaction
            transaction = session.beginTransaction();

            // save student object
            session.save(admin);

            // commit the transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
	}


	@Override
	public void updateAdministrateur(Administrateur admin) {
		// TODO Auto-generated method stub
		Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start the transaction
            transaction = session.beginTransaction();

            // save student object
            session.saveOrUpdate(admin);

            // commit the transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
	}


	@Override
	public Administrateur getadministrateurById(int idAdmin) {
		// TODO Auto-generated method stub
		Transaction transaction = null;
        Administrateur admin = null;
        try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			    // start the transaction
			    transaction = session.beginTransaction();

			    // get student object
			    admin= session.byId(Administrateur.class).getReference(idAdmin);
			     // or student = session.get(Student.class, id);
			    //or student = session.load(Student.class, id);
			   //or commit the transaction
			    transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
                transaction.rollback();
		}
			
		}
        
        
        return admin;
	}


	@Override
	public ObservableList<Administrateur> addAdministrateurList() {
		// TODO Auto-generated method stub
		ObservableList<Administrateur> listAdministrateur = FXCollections.observableArrayList();

		String sql = "SELECT * FROM administrateur";

		connect = Database.connectDb();

		try {

			Administrateur admin;

			prepare = connect.prepareStatement(sql);

			result = prepare.executeQuery();

			while (result.next()) {
				admin = new Administrateur(result.getString("USER_NAME"), result.getString("MOT_PASS"),result.getString("NOM"),result.getString("PRENOM"),result.getString("E_MAIL"));
				listAdministrateur.add(admin);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listAdministrateur;
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

package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;


import com.model.Materiel;
import com.util.HibernateUtil;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MaterielDao implements IMaterielDoa {

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
	public List<Materiel> rechercher(String nomMateriel) {
		Transaction transaction = null;
        List < Materiel > materiel = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            materiel = session.createSQLQuery(nomMateriel).addEntity(getClass()).list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
		return null;
	}


	@Override
	public void savemateriel(Materiel materiel) {
		// TODO Auto-generated method stub
		Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(materiel);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
	}

	@Override
	public void updatemateriel(Materiel materiel) {
		// TODO Auto-generated method stub
		Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(materiel);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
		
	}

	@Override
	public Materiel getmaterielById(int idMateriel) {
		// TODO Auto-generated method stub
		Transaction transaction = null;
        Materiel materiel = null;
        try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			    transaction = session.beginTransaction();
			    materiel= session.byId(Materiel.class).getReference(idMateriel);
			    transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
                transaction.rollback();
		}
		}
        return materiel;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Materiel> getAllmateriel() {
		 Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		 session.beginTransaction();
		 List<Materiel> result = session.createQuery("from Materiel", Materiel.class).getResultList();
		 session.getTransaction().commit();
		 return result;
	}

	@Override
	public void deletemateriel(int idMateriel) {
		Transaction transaction = null;
        Materiel materiel = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            materiel = session.get(Materiel.class, idMateriel);
            session.delete(materiel);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
	}


	@Override
	public ObservableList<Materiel> addMaterielList() {
		ObservableList<Materiel> listMateriel = FXCollections.observableArrayList();
		String sql = "SELECT * FROM materiel";
		connect = Database.connectDb();
		try {
			Materiel materiel;
			prepare = connect.prepareStatement(sql);
			result = prepare.executeQuery();
			while (result.next()) {
				materiel = new Materiel(result.getString("NOM_MATERIEL"), result.getString("DESC_MATERIEL"), result.getFloat("PRIX"),result.getInt("QUANTITE"));
				listMateriel.add(materiel);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listMateriel;
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

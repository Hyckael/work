package com.model;
// Generated 12 f�vr. 2023, 12:38:48 by Hibernate Tools 4.3.6.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Administrateur generated by hbm2java
 */
@Entity
@Table(name = "administrateur", catalog = "myregister")
public class Administrateur implements java.io.Serializable {

	private Integer idAdmin;
	private String userName;
	private String motPass;
	private String nom;
	private String prenom;
	private String EMail;

	public Administrateur() {
	}

	public Administrateur(String userName, String motPass, String nom, String prenom, String EMail) {
		this.userName = userName;
		this.motPass = motPass;
		this.nom = nom;
		this.prenom = prenom;
		this.EMail = EMail;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ID_ADMIN_", unique = true, nullable = false)
	public Integer getIdAdmin() {
		return this.idAdmin;
	}

	public void setIdAdmin(Integer idAdmin) {
		this.idAdmin = idAdmin;
	}

	@Column(name = "USER_NAME", length = 50)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "MOT_PASS", length = 100)
	public String getMotPass() {
		return this.motPass;
	}

	public void setMotPass(String motPass) {
		this.motPass = motPass;
	}

	@Column(name = "NOM", length = 50)
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name = "PRENOM", length = 80)
	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Column(name = "E_MAIL", length = 100)
	public String getEMail() {
		return this.EMail;
	}

	public void setEMail(String EMail) {
		this.EMail = EMail;
	}

}
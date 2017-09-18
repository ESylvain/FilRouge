package fr.filrouge.jsf;

import java.io.Serializable;
import java.util.List;

import javax.faces.event.AjaxBehaviorEvent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.Hibernate;

import fr.filrouge.dao.FormationDAO;
import fr.filrouge.hibernate.Cours;
import fr.filrouge.hibernate.Formation;
import fr.filrouge.hibernate.Stagiaire;

public class FormationBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	@Size(min = 3, message = "minimum 3 lettres feignasse")
	private String libelle;
	private List<Cours> courss;
	private List<Stagiaire> stagiaires;
	private List<Formation> formations;
	int compteur;
	@NotNull(message = "nullllll")
	String value;
	String statusMessage;

	public FormationBean() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String toString() {
		return this.libelle + " (" + this.id + ")";
	}

	public List<Cours> getCourss() {
		return courss;
	}

	public void setCourss(List<Cours> courss) {
		this.courss = courss;
	}

	public List<Stagiaire> getStagiaires() {
		return stagiaires;
	}

	public void setStagiaires(List<Stagiaire> stagiaires) {
		this.stagiaires = stagiaires;
	}

	public List<Formation> getFormations() {
		return formations;
	}

	public void setFormations(List<Formation> formations) {
		this.formations = formations;
	}

	public String navigation(int c) {
		System.out.println("methode appellee c la fete vive jsf et tou param : " + c);
		switch (c) {
		case 0:
			return "create";
		case 1:
			return "detail";
		case 2:
			return "formationFeedback";
		default:
			return "error";
		}
	}

	// zone test ajax
	public int getCompteur() {
		return compteur;
	}

	public void setCompteur(int compteur) {
		this.compteur = compteur;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public void evaluer(AjaxBehaviorEvent event) {
		System.out.println("methode ajax compteur");
		System.out.println("id en param : "+id);
		setCompteur(getValue().length());
	}

	public void onload() {
		System.out.println("onload methode");
		// on appelle la couche metier
		FormationDAO formationDAO = new FormationDAO();
		List<Formation> f = null;
		try {
			f = formationDAO.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (Formation fo : f) {
			Hibernate.initialize(fo.getCourss());
			Hibernate.initialize(fo.getStagiaires());
			// fo.getCourss().size();
		}
		this.formations = f;
		formationDAO.close();
	}
	
	public void save() {
		System.out.println("save methode");
		// on appelle la couche metier
		FormationDAO formationDAO = new FormationDAO();
		Formation f = new Formation();
		System.out.println("et le libelle est : "+libelle);
		f.setLibelle(libelle);
		try {
			formationDAO.persist(f);
			statusMessage = "Sauvegarde OK";
			this.formations.add(f);
			System.out.println("formations : "+formations);
		} catch (Exception e) {
			System.out.println("erreur persist formationBean");
			statusMessage = "ca c'est mal passé";
			e.printStackTrace();
		}
		formationDAO.close();
	}
}

package fr.filrouge.jsf;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Hibernate;

import fr.filrouge.dao.FormateurDAO;
import fr.filrouge.hibernate.Cours;
import fr.filrouge.hibernate.Formateur;

public class FormateurBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String prenom;
	private String nom;

	private List<Cours> courss;
	public List<Formateur> formateurs;

	public FormateurBean() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Cours> getCourss() {
		return courss;
	}

	public void setCourss(List<Cours> courss) {
		this.courss = courss;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String toString() {
		return this.prenom + " " + this.nom + " (" + this.id + ")";
	}

	//// temporaire test jsf binding

	public List<Formateur> getFormateurs() {
		return formateurs;
	}

	public void setFormateurs(List<Formateur> formateurs) {
		this.formateurs = formateurs;
	}

	public void listeFormateurs() {
		// try {
		// FacesContext.getCurrentInstance().getExternalContext().redirect("ListFormateurs");
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		// on appelle la couche metier
		FormateurDAO formateurDAO = new FormateurDAO();
		List<Formateur> f = null;
		try {
			f = formateurDAO.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Formateur fo : f) {
			Hibernate.initialize(fo.getCourss());
			// fo.getCourss().size();
		}
		this.formateurs = f;
		 formateurDAO.close();
	}
}

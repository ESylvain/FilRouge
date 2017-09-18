package fr.filrouge.hibernate;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="Stagiaire")
@XmlRootElement
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
public class Stagiaire {
	
	@Id
	private int id;
	private String prenom;
	private String nom;
	@ManyToMany
	@JoinTable(name = "FormationStagiaire", joinColumns = {
			@JoinColumn(name = "Stagiaire") },
			inverseJoinColumns = { @JoinColumn(name = "Formation") })
	private List<Formation> formations;
	
	public Stagiaire() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public List<Formation> getFormations() {
		return formations;
	}

	public void setFormations(List<Formation> formations) {
		this.formations = formations;
	}
	
	public String toString(){
		return this.prenom +" "+ this.nom +" ("+ this.id+")";
	}
	
	
}

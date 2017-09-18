package fr.filrouge.hibernate;


import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name="Cours")
@XmlRootElement
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
@Named
@SessionScoped
public class Cours {

	@Id
	private int id;
	private String libelle;
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "FormationCours", joinColumns = {
			@JoinColumn(name = "Cours") },
			inverseJoinColumns = { @JoinColumn(name = "Formation") })
	private List<Formation> formations;
	@ManyToOne
//	@JsonBackReference
//	@JsonManagedReference
	private Formateur formateur;
	
	public Cours(){
		System.out.println("nouveau cours");
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
	public List<Formation> getFormations() {
		return formations;
	}
	public void setFormations(List<Formation> formations) {
		this.formations = formations;
	}
	public Formateur getFormateur() {
		return formateur;
	}
	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}
	
	
	public String toString(){
		return this.libelle +" ("+ this.id+")";
	}
	
	
}

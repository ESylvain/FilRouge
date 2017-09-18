package fr.filrouge.hibernate;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="Formation")
@XmlRootElement
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
public class Formation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String libelle;
	@ManyToMany
	@JoinTable(name = "FormationCours", joinColumns = {
			@JoinColumn(name = "Formation") },
			inverseJoinColumns = { @JoinColumn(name = "Cours") })
	private List<Cours> courss;
	@ManyToMany
	@JoinTable(name = "FormationStagiaire", joinColumns = {
			@JoinColumn(name = "Formation") },
			inverseJoinColumns = { @JoinColumn(name = "Stagiaire") })
	private List<Stagiaire> stagiaires;
	
	public Formation() {
		// TODO Auto-generated constructor stub
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
	
	public String toString(){
		return this.libelle +" ("+ this.id+")" ;
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
}

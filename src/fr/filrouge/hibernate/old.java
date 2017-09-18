package fr.filrouge.hibernate;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class old {
	
//	Liste les stagiaires
	public void listerStagiaires() {

		SessionFactory sessionFactory = new Configuration().configure("/resources/hibernate.cfg.xml").buildSessionFactory(); 

		Session session = sessionFactory.openSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Stagiaire> criteria = criteriaBuilder.createQuery(Stagiaire.class);

		Root<Stagiaire> root = criteria.from(Stagiaire.class);
		//		criteria.select(root);
		//		criteria.where(criteriaBuilder.equal(root.get("nom"), "McNulty"));

		TypedQuery<Stagiaire> query = session.createQuery(criteria);
		List<Stagiaire> stagiaires = query.getResultList() ;

		for(Stagiaire s : stagiaires){
			System.out.println(s);			
		}

		sessionFactory.close();
	}
	
//	Liste les formateurs
	public void listerFormateurs() {
		SessionFactory sessionFactory = new Configuration().configure("/resources/hibernate.cfg.xml").buildSessionFactory(); 

		Session session = sessionFactory.openSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Formateur> criteria = criteriaBuilder.createQuery(Formateur.class);
		
		Root<Formateur> root = criteria.from(Formateur.class);

		TypedQuery<Formateur> query = session.createQuery(criteria);
		List<Formateur> formateurs = query.getResultList() ;

		for(Formateur f : formateurs){
			System.out.println(f);			
		}

		sessionFactory.close();

	}
	
//	Liste les formations
	public void listerFormations() {
		SessionFactory sessionFactory = new Configuration().configure("/resources/hibernate.cfg.xml").buildSessionFactory(); 

		Session session = sessionFactory.openSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Formation> criteria = criteriaBuilder.createQuery(Formation.class);
		
		Root<Formation> root = criteria.from(Formation.class);

		TypedQuery<Formation> query = session.createQuery(criteria);
		List<Formation> formations = query.getResultList() ;

		for(Formation f : formations){
			System.out.println(f);			
		}

		sessionFactory.close();

	}
	
//	Liste les cours
	public void listerCours() {
		SessionFactory sessionFactory = new Configuration().configure("/resources/hibernate.cfg.xml").buildSessionFactory(); 

		Session session = sessionFactory.openSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Cours> criteria = criteriaBuilder.createQuery(Cours.class);
		
		Root<Cours> root = criteria.from(Cours.class);

		TypedQuery<Cours> query = session.createQuery(criteria);
		List<Cours> courss = query.getResultList() ;

		for(Cours c : courss){
			System.out.println(c);			
		}

		sessionFactory.close();

	}
	
}

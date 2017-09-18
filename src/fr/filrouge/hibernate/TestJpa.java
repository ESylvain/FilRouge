package fr.filrouge.hibernate;


import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestJpa {

	public static void main(String[] args) throws Exception {


		String etudiant = "21002127";
		long cours = 61l;
		String salle = "i50";
		long cursus = 10l;
		long matiere = 4l;
		long salleId = 20l;
		long professeur = 54l;


//		listerStagiaires();
//		listerFormateurs();
//		listerFormations();
		listerCours();

	}
	
//	Liste les stagiaires
	private static void listerStagiaires() {

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
	private static void listerFormateurs() {
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
	private static void listerFormations() {
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
	private static void listerCours() {
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

//	
//	//saveEtudiant
//		private static void updateEtudiant(String id){
//			
//			
//			
//			SessionFactory sessionFactory = new Configuration().configure("/resources/hibernate.cfg.xml").buildSessionFactory(); 
//			Session session = sessionFactory.openSession();
//			
//			Etudiant e = session.load(Etudiant.class, id);
//			
//			Transaction transaction = session.beginTransaction();
//			
//			try {
//				System.out.println("try");
//				e.setNom("update");
//				session.update(e); 				
//				transaction.commit();
//			} catch (Exception e2) {
//				System.out.println(e2);
//				System.out.println("rollback");
//				transaction.rollback();
//			}
//
//			session.close();
//			sessionFactory.close();
//		}
//	
//	//saveEtudiant
//	private static void saveEtudiant(){
//		Etudiant e = new Etudiant();
//		e.setNom("lol");
//		e.setPrenom("dd");
//		e.setNumeroEtudiant("dqqda20");
//		
//		SessionFactory sessionFactory = new Configuration().configure("/resources/hibernate.cfg.xml").buildSessionFactory(); 
//		Session session = sessionFactory.openSession();
//		
//		Transaction transaction = session.beginTransaction();
//		
//		try {
//			System.out.println("try");
//			System.out.println(session.save(e)); 
//			
//			transaction.commit();
//		} catch (Exception e2) {
//			System.out.println(e2);
//			System.out.println("rollback");
//			transaction.rollback();
//		}
//
//		session.close();
//		sessionFactory.close();
//	}
//
//	//	Liste les creneaux
//	private static void listerCreneaus() {
//
//		SessionFactory sessionFactory = new Configuration().configure("/resources/hibernate.cfg.xml").buildSessionFactory(); 
//
//		Session session = sessionFactory.openSession();
//		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
//		CriteriaQuery<Creneau> criteria = criteriaBuilder.createQuery(Creneau.class);
//
//		Root<Creneau> root = criteria.from(Creneau.class);
//		//		criteria.select(root);
//		//		criteria.where(criteriaBuilder.equal(root.get("nom"), "McNulty"));
//
//		TypedQuery<Creneau> query = session.createQuery(criteria);
//		List<Creneau> creneaus = query.getResultList() ;
//		System.out.println("");
//		System.out.println("--------------------------------------------");
//		System.out.println("Affiche les creneaux");
//		System.out.println("");
//		for(Creneau c : creneaus){
//			System.out.println(c);			
//		}
//
//		sessionFactory.close();
//	}
//	


//
//
//	//	Affiche le nom du cursus d'un étudiant
//	private static void cursusEtudiant(String numeroEtudiant) {
//		SessionFactory sessionFactory = new Configuration().configure("/resources/hibernate.cfg.xml").buildSessionFactory(); 
//
//		Session session = sessionFactory.openSession();
//		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
//		CriteriaQuery<Etudiant> criteria = criteriaBuilder.createQuery(Etudiant.class);
//
//		Root<Etudiant> root = criteria.from(Etudiant.class);
//		criteria.select(root);
//		criteria.where(criteriaBuilder.equal(root.get("numeroEtudiant"), numeroEtudiant));
//
//		TypedQuery<Etudiant> query = session.createQuery(criteria);
//		List<Etudiant> etudiants = query.getResultList() ;
//		System.out.println("");
//		System.out.println("--------------------------------------------");
//		for(Etudiant e : etudiants){
//			System.out.println(e+" : "+e.getCursus());			
//		}
//		System.out.println("--------------------------------------------");
//		sessionFactory.close();
//
//	}
//
//	//	Affiche le nom de la salle dans laquelle a lieu un cours
//	private static void salleCours(long idCours) {
//		SessionFactory sessionFactory = new Configuration().configure("/resources/hibernate.cfg.xml").buildSessionFactory(); 
//
//		Session session = sessionFactory.openSession();
//		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
//		CriteriaQuery<Cours> criteria = criteriaBuilder.createQuery(Cours.class);
//
//		Root<Cours> root = criteria.from(Cours.class);
//		criteria.select(root);
//		criteria.where(criteriaBuilder.equal(root.get("id"), idCours));
//
//		TypedQuery<Cours> query = session.createQuery(criteria);
//		List<Cours> courss = query.getResultList() ;
//		System.out.println("");
//		System.out.println("--------------------------------------------");
//		System.out.println("Affiche le nom de la salle dans laquelle a lieu un cours");
//		System.out.println("");
//		for(Cours c : courss){
//			System.out.println(c+" : "+c.getCreneau().getSalle().getNom());			
//		}
//		System.out.println("--------------------------------------------");
//		sessionFactory.close();
//
//	}
//
//	//	Affiche le nom des cours ayant lieu dans une salle
//	private static void listerCoursSalle(String nomSalle) {
//		SessionFactory sessionFactory = new Configuration().configure("/resources/hibernate.cfg.xml").buildSessionFactory(); 
//
//		Session session = sessionFactory.openSession();
//		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
//		CriteriaQuery<Salle> criteria = criteriaBuilder.createQuery(Salle.class);
//
//		Root<Salle> root = criteria.from(Salle.class);
//		criteria.select(root);
//		criteria.where(criteriaBuilder.equal(root.get("nom"), nomSalle));
//
//		TypedQuery<Salle> query = session.createQuery(criteria);
//		List<Salle> salles = query.getResultList() ;
//
//		System.out.println("");
//		System.out.println("--------------------------------------------------");
//		System.out.println("Affiche le nom des cours ayant lieu dans une salle");
//		System.out.println("");
//
//		for(Salle s : salles){
//			for(Creneau c : s.getCreneaux()){
//				System.out.println(s+" : "+c.getCours());
//			}
//		}
//		System.out.println("--------------------------------------------------");
//		sessionFactory.close();
//	}
//
//
//
//
//
//	//	Affiche le nom des étudiants qui assistent à un cours
//	private static void listerEtudiantsCours(long idCours) {
//		SessionFactory sessionFactory = new Configuration().configure("/resources/hibernate.cfg.xml").buildSessionFactory(); 
//
//		Session session = sessionFactory.openSession();
//
//		Cours c = session.load(Cours.class, idCours);
//
//		System.out.println("");
//		System.out.println("--------------------------------------------------");
//		System.out.println("Affiche le nom des étudiants qui assistent à un cours");
//		System.out.println("");
//		Set<Etudiant> set = new HashSet<Etudiant>();
//		for(Cursus cu : c.getMatiere().getCursuss()){
//			for(Etudiant e : cu.getEtudiants()){
//				if(set.add(e)){
//					System.out.println(c+" : "+e);
//				}
//			}
//		}
//		System.out.println("--------------------------------------------------");
//		sessionFactory.close();
//	}
//
//	//	Affiche le nom des professeurss qui enseignent dans un cursus
//	private static void listerProfesseursCursus(long idCursus) {
//		SessionFactory sessionFactory = new Configuration().configure("/resources/hibernate.cfg.xml").buildSessionFactory(); 
//
//		Session session = sessionFactory.openSession();
//
//		Cursus c = session.load(Cursus.class, idCursus);
//		Set<Professeur> set = new HashSet<Professeur>();
//
//		System.out.println("");
//		System.out.println("--------------------------------------------------");
//		System.out.println("Affiche le nom des professeurss qui enseignent dans un cursus");
//		System.out.println("");
//
//		for(Matiere m : c.getMatieres()){
//			for(Cours co : m.getCourss()){
//				for(Professeur p : co.getProfesseurs()){
//					if(set.add(p)){
//						System.out.println(c+" : "+p);
//					}
//				}
//			}
//		}
//		System.out.println("--------------------------------------------------");
//		sessionFactory.close();
//
//	}
//
//	//	Affiche le nom des professeurs qui enseignent une matière
//	private static void listerProfesseursMatiere(long idMatiere) {
//		SessionFactory sessionFactory = new Configuration().configure("/resources/hibernate.cfg.xml").buildSessionFactory(); 
//
//		Session session = sessionFactory.openSession();
//
//		Matiere m = session.load(Matiere.class, idMatiere);
//		Set<Professeur> set = new HashSet<Professeur>();
//
//		System.out.println("");
//		System.out.println("--------------------------------------------------");
//		System.out.println("Affiche le nom des professeurs qui enseignent une matière");
//		System.out.println("");
//
//		for(Cours c : m.getCourss()){
//			for(Professeur p : c.getProfesseurs()){
//				if(set.add(p)){
//					System.out.println(m+" : "+p);
//				}
//			}
//		}
//		System.out.println("--------------------------------------------------");
//		sessionFactory.close();
//
//	}
//
//	//	Affiche des profs qui enseignent à un étudiant
//	private static void listerProfsEtudiant(String numeroEtudiant) {
//		SessionFactory sessionFactory = new Configuration().configure("/resources/hibernate.cfg.xml").buildSessionFactory(); 
//
//		Session session = sessionFactory.openSession();
//
//		Etudiant e = session.load(Etudiant.class, numeroEtudiant);
//		Set<Professeur> set = new HashSet<Professeur>();
//
//		System.out.println("");
//		System.out.println("--------------------------------------------------");
//		System.out.println("Affiche des profs qui enseignent à un étudiant");
//		System.out.println("");
//
//		for(Matiere m : e.getCursus().getMatieres()){
//			for(Cours c : m.getCourss()){
//				for(Professeur p : c.getProfesseurs()){
//					if(set.add(p)){
//						System.out.println(e+" : "+p);
//					}
//				}
//			}
//
//		}
//		System.out.println("--------------------------------------------------");
//		sessionFactory.close();
//
//	}
//
//
//	//	Affiche l'emploi du temps d'une salle
//	private static void emploiDuTempsSalle(String nomSalle) {
//		SessionFactory sessionFactory = new Configuration().configure("/resources/hibernate.cfg.xml").buildSessionFactory(); 
//
//		Session session = sessionFactory.openSession();
//
//		//		Salle s = session.load(Salle.class, nomSalle);
//
//		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
//		CriteriaQuery<Salle> criteria = criteriaBuilder.createQuery(Salle.class);
//
//		Root<Salle> root = criteria.from(Salle.class);
//		criteria.select(root);
//		criteria.where(criteriaBuilder.equal(root.get("nom"), nomSalle));
//
//		TypedQuery<Salle> query = session.createQuery(criteria);
//		List<Salle> salles = query.getResultList() ;
//
//		SimpleDateFormat format = new SimpleDateFormat("dd-M-yyyy hh:mm");
//		String debutS ="";
//		String finS = "";
//		
//		System.out.println("");
//		System.out.println("--------------------------------------------------");
//		System.out.println("Affiche l'emploi du temps d'une salle");
//		System.out.println("");
//		
//		for(Salle s : salles){
//			for(Creneau cr : s.getCreneaux()){
//				for(Professeur p : cr.getCours().getProfesseurs()){
//					
//					debutS = format.format(cr.getHoraire().getDebut());
//					finS = format.format(cr.getHoraire().getFin());
//					
//					System.out.println(s+" : "+debutS+" - "+finS+" | "+cr.getCours().getMatiere().getNom()+" avec "+p);
//				}
//			}
//		}
//		
//		System.out.println("--------------------------------------------------");
//		sessionFactory.close();
//
//	}
//
//	//	Affiche l'emploi du temps d'un étudiant
//	private static void emploiDuTempsEtudiant(String numeroEtudiant) {
//		SessionFactory sessionFactory = new Configuration().configure("/resources/hibernate.cfg.xml").buildSessionFactory(); 
//
//		Session session = sessionFactory.openSession();
//
//		Etudiant e = session.load(Etudiant.class, numeroEtudiant);
//
//		SimpleDateFormat format = new SimpleDateFormat("dd-M-yyyy hh:mm");
//		String debutS ="";
//		String finS = "";
//		
//		System.out.println("");
//		System.out.println("--------------------------------------------------");
//		System.out.println("Affiche l'emploi du temps d'un étudiant");
//		System.out.println("");
//		
//		for(Matiere m : e.getCursus().getMatieres()){
//			for(Cours c : m.getCourss()){
//				for(Professeur p : c.getProfesseurs()){
//					
//					debutS = format.format(c.getCreneau().getHoraire().getDebut());
//					finS = format.format(c.getCreneau().getHoraire().getFin());
//					
//					System.out.println(e+" , cursus "+e.getCursus().getNom()+" : "+debutS+" - "+finS+" | "
//							+c.getCreneau().getSalle().getNom()+" | "+m.getNom()+" avec "+p);
//				}
//			}
//			
//		}
//		
//		System.out.println("--------------------------------------------------");
//		session.close();
//		sessionFactory.close();
//
//	}
//
//	//	Affiche l'emploi du temps d'un professeur
//	private static void emploiDuTempsProfesseur(long idProfesseur) {
//		SessionFactory sessionFactory = new Configuration().configure("/resources/hibernate.cfg.xml").buildSessionFactory(); 
//
//		Session session = sessionFactory.openSession();
//
//		Professeur p = session.load(Professeur.class, idProfesseur);
//
//		SimpleDateFormat format = new SimpleDateFormat("dd-M-yyyy hh:mm");
//		String debutS ="";
//		String finS = "";
//		
//		System.out.println("");
//		System.out.println("--------------------------------------------------");
//		System.out.println("Affiche l'emploi du temps d'un professeur");
//		System.out.println("");
//		
////		for(Cours c : p.getCourss()){
////			
////			debutS = format.format(c.getCreneau().getHoraire().getDebut());
////			finS = format.format(c.getCreneau().getHoraire().getFin());
////			
////			System.out.println(p+" : "+debutS+" - "+finS+" | "
////					+c.getCreneau().getSalle().getNom()+" | "+c.getMatiere().getNom());
////				
////		}
//		
//		p.getCourss().forEach(System.out::println);
//		
//		System.out.println("--------------------------------------------------");
//		session.close();
//		sessionFactory.close();
//		
//		
//
//	}


}

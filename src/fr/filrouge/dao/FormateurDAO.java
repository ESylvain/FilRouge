package fr.filrouge.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.filrouge.hibernate.Connec;
import fr.filrouge.hibernate.Formateur;

public class FormateurDAO {

	private Session session = null;

	// read Formateur id
	public Formateur findById(int id) throws Exception {

		if (session == null) {
			Connec connec = Connec.getInstance();
			this.session = connec.getSessionFactory().openSession();
		}

		Formateur f = session.load(Formateur.class, id);

		return f;
	}

	// read FormateurS name !! utilise LIKE, et pas EQUAL
	public List<Formateur> findByName(String name) throws Exception {

		if (session == null) {
			Connec connec = Connec.getInstance();
			this.session = connec.getSessionFactory().openSession();
		}
		
		CriteriaBuilder criteriaBuilder = this.session.getCriteriaBuilder();
		CriteriaQuery<Formateur> criteria = criteriaBuilder.createQuery(Formateur.class);
		Root<Formateur> root = criteria.from(Formateur.class);
		criteria.select(root);
		criteria.where(criteriaBuilder.like(root.get("nom"), "%"+name+"%"));
		TypedQuery<Formateur> query = this.session.createQuery(criteria);
		List<Formateur> formateurs = query.getResultList();
		
		return formateurs;
	}

	// read FormateurS
	public List<Formateur> findAll() throws Exception {

		if (session == null) {
			Connec connec = Connec.getInstance();
			this.session = connec.getSessionFactory().openSession();
		}

		CriteriaBuilder criteriaBuilder = this.session.getCriteriaBuilder();
		CriteriaQuery<Formateur> criteria = criteriaBuilder.createQuery(Formateur.class);
		criteria.from(Formateur.class);
		TypedQuery<Formateur> query = this.session.createQuery(criteria);
		List<Formateur> formateurs = query.getResultList();

		return formateurs;
	}

	// delete Formateur
	public boolean delete(Formateur f) throws Exception {

		if (session == null) {
			Connec connec = Connec.getInstance();
			this.session = connec.getSessionFactory().openSession();
		}

		Transaction transaction = session.beginTransaction();
		try {
			session.delete(f);
			transaction.commit();
			return true;
		} catch (Exception e2) {
			System.out.println("rollback");
			transaction.rollback();
			return false;
		}
	}

	// save Formateur
	public boolean save(Formateur f) throws Exception {
		if (session == null) {
			Connec connec = Connec.getInstance();
			this.session = connec.getSessionFactory().openSession();
		}

		Transaction transaction = session.beginTransaction();
		try {
			session.save(f);
			transaction.commit();
			return true;
		} catch (Exception e2) {
			System.out.println("rollback");
			transaction.rollback();
			return false;
		}
	}

	// update Formateur
	public boolean update(Formateur f) throws Exception {

		if (session == null) {
			Connec connec = Connec.getInstance();
			this.session = connec.getSessionFactory().openSession();
		}
		Transaction transaction = session.beginTransaction();

		try {
			session.update(f);
			transaction.commit();
			return true;
		} catch (Exception e2) {
			System.out.println("rollback");
			transaction.rollback();
			return false;
		}

	}

	// close session
	public void close() {
		this.session.close();
		System.out.println("close session");
	}
}

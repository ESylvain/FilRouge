package fr.filrouge.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.filrouge.hibernate.Connec;
import fr.filrouge.hibernate.Formation;

public class FormationDAO {

	private Session session = null;

	// read Formation by id
	public Formation findById(int id) throws Exception {

		if (session == null) {
			Connec connec = Connec.getInstance();
			this.session = connec.getSessionFactory().openSession();
		}

		Formation f = session.load(Formation.class, id);

		return f;
	}

	// read Formations
	public List<Formation> findAll() throws Exception {

		if (session == null) {
			Connec connec = Connec.getInstance();
			this.session = connec.getSessionFactory().openSession();
		}

		CriteriaBuilder criteriaBuilder = this.session.getCriteriaBuilder();
		CriteriaQuery<Formation> criteria = criteriaBuilder.createQuery(Formation.class);
		criteria.from(Formation.class);
		TypedQuery<Formation> query = this.session.createQuery(criteria);
		List<Formation> formations = query.getResultList();

		return formations;
	}

	// persist Formation
	public boolean persist(Formation f) throws Exception {
		if (session == null) {
			Connec connec = Connec.getInstance();
			this.session = connec.getSessionFactory().openSession();
		}

		Transaction transaction = session.beginTransaction();
		try {
			session.persist(f);
			transaction.commit();
			return true;
		} catch (Exception e2) {
			System.out.println("rollback");
			transaction.rollback();
			return false;
		}
	}

	// persist Formation
	public boolean save(Formation f) throws Exception {
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

	// close session
	public void close() {
		this.session.close();
		System.out.println("close session");
	}

}

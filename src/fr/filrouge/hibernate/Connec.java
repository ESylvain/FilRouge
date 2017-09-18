package fr.filrouge.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Connec {

	private static final Connec instance = new Connec();
	private SessionFactory sessionFactory;

	private Connec() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			System.out.println("Erreur class jdbc");
		}
		setSessionFactory(new Configuration().configure("/resources/hibernate.cfg.xml").buildSessionFactory());

	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	private void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public static Connec getInstance() {
		return instance;
	}

}

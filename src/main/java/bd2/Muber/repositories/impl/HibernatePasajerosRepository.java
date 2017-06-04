package bd2.Muber.repositories.impl;

import org.hibernate.SessionFactory;

public class HibernatePasajerosRepository {
	
	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
}

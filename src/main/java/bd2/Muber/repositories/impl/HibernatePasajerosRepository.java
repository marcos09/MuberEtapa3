package bd2.Muber.repositories.impl;

import org.hibernate.SessionFactory;

import antlr.collections.List;

public class HibernatePasajerosRepository  {
	
	protected SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List getPassenger(){
		//session = this.buildSessionFactory();
		//System.out.println(sessionFactory.getClass().toString());
		List result = (List) sessionFactory.getCurrentSession().createQuery("from Passenger").list();
		return null;
	}	
}

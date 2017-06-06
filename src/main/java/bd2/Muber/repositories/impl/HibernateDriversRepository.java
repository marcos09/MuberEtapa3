package bd2.Muber.repositories.impl;


import org.hibernate.SessionFactory;


import antlr.collections.List;

/**
 * @author yato
 *
 */
public class HibernateDriversRepository {

	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List getDrivers(){
		//session = this.buildSessionFactory();
		System.out.println(sessionFactory.getClass().toString());
		//List result = (List) sessionFactory.getCurrentSession().createQuery("from Driver").list();
		return null;
	}

}
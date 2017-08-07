/**
 * 
 */
package bd2.Muber.repositories.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import bd2.Muber.model.PersistentMuberObject;

/**
 * @author marcos
 *
 */
public class HibernateGenericRepository {
	
	protected SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public PersistentMuberObject saveOrUpdate(PersistentMuberObject persistentObject ) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(persistentObject);
		return persistentObject;
	}
}

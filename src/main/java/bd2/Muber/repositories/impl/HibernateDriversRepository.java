package bd2.Muber.repositories.impl;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import bd2.Muber.model.Driver;
import bd2.Muber.model.Trip;

/**
 * @author yato
 *
 */
public class HibernateDriversRepository extends HibernateGenericRepository{

	
	public Driver getUser(Long idUser) {
		List result = (List) sessionFactory.getCurrentSession().createQuery("from Driver where idUser = :idDriver").setParameter("idDriver", idUser).list();
		if( result.isEmpty()){
			return null;
		}
		return (Driver) result.get(0);
		
	}
	
	public ArrayList<Driver> getDrivers(){
		
		ArrayList<Driver> drivers = new ArrayList<Driver>();
		Iterator iterator = sessionFactory.getCurrentSession().createQuery("from Driver").iterate();
		while(iterator.hasNext()){
			Driver driver = (Driver) iterator.next();
			drivers.add(driver);
		}
		
		return drivers;
	}
	
	public Driver getDetail(Long idUser){
		List result = (List) sessionFactory.getCurrentSession().createQuery("from Driver where idUser = :id").setParameter("id",idUser).list();
		if( result.isEmpty()){
			return null;
		}
		return (Driver) result.get(0);
	}

	public Driver add(Driver driver) {
			Session session = sessionFactory.openSession();
			session.save(driver);
			session.close();
			return null;

	}


	


	
}
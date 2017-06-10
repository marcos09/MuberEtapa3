package bd2.Muber.repositories.impl;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.SessionFactory;

//import antlr.collections.List;
import bd2.Muber.model.Driver;

/**
 * @author yato
 *
 */
public class HibernateDriversRepository extends HibernateGenericRepository{

	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
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
		List result = (List) sessionFactory.getCurrentSession().createQuery("from Driver as driver INNER JOIN Trip.driver.idUser where Driver.idUser = :id").setParameter("id",idUser).list();
		if( result.isEmpty()){
			return null;
		}
		return (Driver) result.get(0);
	}


	public Driver getUser(Long idUser) {
		List result = (List) sessionFactory.getCurrentSession().createQuery("from Driver where USER_ID = :idUser").setParameter("idUser", idUser).list();
		if( result.isEmpty()){
			return null;
		}
		return (Driver) result.get(0);
		
	}
	
}
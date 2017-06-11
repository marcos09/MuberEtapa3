package bd2.Muber.repositories.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import bd2.Muber.model.Driver;
import bd2.Muber.model.Passenger;

public class HibernatePasajerosRepository  {
	
	protected SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List getPassenger(){
		ArrayList<Passenger> passengers = new ArrayList<Passenger>();
		Iterator iterator = sessionFactory.getCurrentSession().createQuery("from Passenger").iterate();
		while(iterator.hasNext()){
			Passenger passenger = (Passenger) iterator.next();
			passengers.add(passenger);
		}
		
		return passengers;		
		
	}	
	
	public Passenger getUser(Long idUser) {
		List result = (List) sessionFactory.getCurrentSession().createQuery("from Passenger where USER_ID = :idUser").setParameter("idUser", idUser).list();
		if(result.isEmpty()){
			return null;
		}
		return (Passenger) result.get(0);
		
	}

	public Passenger addCredit(Long idUser, Float credit) {
		Passenger passenger = (Passenger) this.getUser(idUser);
		System.out.println("Terminé el getUser");
		if(passenger == null){
			return null;
		}
		
		passenger.addCredits(credit);
		Session session = sessionFactory.openSession();
		session.update(passenger);
		
		session.close();
		return passenger;
	}

}

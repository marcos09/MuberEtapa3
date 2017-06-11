package bd2.Muber.repositories.impl;

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
		//session = this.buildSessionFactory();
		//System.out.println(sessionFactory.getClass().toString());
		List result = (List) sessionFactory.getCurrentSession().createQuery("from Passenger").list();
		return null;
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

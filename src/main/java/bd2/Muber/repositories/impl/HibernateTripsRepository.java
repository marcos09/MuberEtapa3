/**
 * 
 */
package bd2.Muber.repositories.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import bd2.Muber.model.Driver;
import bd2.Muber.model.Passenger;
import bd2.Muber.model.Trip;

public class HibernateTripsRepository {

	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Trip add(Trip trip) {
		Session session = sessionFactory.openSession();
		session.save(trip);
		session.close();
		return null;
	}

	public Trip closeTrip(Long idTrip) {
		
		List result = (List) sessionFactory.getCurrentSession().createQuery("from Trip where TRIP_ID = :idTrip").setParameter("idUser", idTrip).list();
		if( result.isEmpty()){
			return null;
		}
		Trip trip = (Trip) result.get(0);
		trip.closeTrip();
		sessionFactory.openSession().update(trip);
		sessionFactory.close();
		return trip;
		
	}
	
	public List getOpenTrips(){
		Iterator iterator = sessionFactory.getCurrentSession().createQuery("from Trip where state = 'enable' and date >= curdate()").iterate();
		ArrayList<Trip> trips = new ArrayList<Trip>();
		while(iterator.hasNext()){
			Trip trip = (Trip) iterator.next();
			trips.add(trip);
		}
		return trips;		

	}

	public Trip getTrip(Long idTrip) {
		List result = (List) sessionFactory.getCurrentSession().createQuery("from Trip where idTrip = :tripId").setParameter("tripId", idTrip).list();
		if( result.isEmpty()){
			return null;
		}
		return (Trip) result.get(0);

	}
	
	public Trip addPassenger(Long idPassenger, Long idTrip){
		HibernatePasajerosRepository pasajerosRepository = new HibernatePasajerosRepository(); 
		
		Trip trip = (Trip) this.getTrip(idTrip);
		System.out.println("Terminé el getTrip");
		if (trip == null)
			return null;
		
		trip.addPassenger(pasajerosRepository.getUser(idPassenger));
		Session session = sessionFactory.openSession();
		session.update(trip);
		session.close();
	
		return trip;
	}
	
	/*
	 * Obtener viajes abiertos formato SQL
	 * SELECT `TRIP_ID` FROM `TRIP` INNER JOIN PASSENGERTRIP ON(`TRIP_ID`= `idTrip`) WHERE `date` > CURDATE() and state = "enable" GROUP by TRIP_ID, numberOfpassengers HAVING count(*) < `numberOfpassengers`"
	 */
}

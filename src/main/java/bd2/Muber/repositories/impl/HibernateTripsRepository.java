/**
 * 
 */
package bd2.Muber.repositories.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

import bd2.Muber.model.Driver;
import bd2.Muber.model.Passenger;
import bd2.Muber.model.Trip;
import bd2.Muber.repositories.RepositoryLocator;
import bd2.Muber.services.ServiceLocator;

public class HibernateTripsRepository extends HibernateGenericRepository {


	public Trip add(Trip trip) {
		Session session = sessionFactory.openSession();
		session.save(trip);
		session.close();
		return trip;
	}

	public Trip closeTrip(Long idTrip) {
		
		List result = (List) sessionFactory.getCurrentSession().createQuery("from Trip where TRIP_ID = :idTrip").setParameter("idTrip", idTrip).list();
		if( result.isEmpty()){
			return null;
		}
		Trip trip = (Trip) result.get(0);
		trip.discountCredit();
		trip.closeTrip();
		sessionFactory.getCurrentSession().update(trip);
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
		Trip trip = (Trip) result.get(0);
		return trip;

	}
	
	public Trip addPassenger(Long idPassenger, Long idTrip){
		
		
		Trip trip = (Trip) this.getTrip(idTrip);
		if (trip == null)
			return null;
		Passenger passenger = RepositoryLocator.getInstance().getPasajerosRepository().getUser(idPassenger) ;		
		
		if(passenger == null){
			return null;
		}
		trip.addPassenger(passenger);
		Session session = sessionFactory.getCurrentSession();
		session.update(trip);
		
	
		return trip;
	}

	public Float getDriverPromedy(Driver driver) {
		
		List result = (List) sessionFactory.getCurrentSession().createQuery("from Trip where driver = aDriver").setParameter("aDriver", driver).list();
		if(result != null){
			Float promedy = (Float) result.get(0);
			System.out.println(promedy);
			return promedy;
		}
		return null;
		
		
	}

	
	/*
	 * Obtener viajes abiertos formato SQL
	 * SELECT `TRIP_ID` FROM `TRIP` INNER JOIN PASSENGERTRIP ON(`TRIP_ID`= `idTrip`) WHERE `date` > CURDATE() and state = "enable" GROUP by TRIP_ID, numberOfpassengers HAVING count(*) < `numberOfpassengers`"
	 */
}

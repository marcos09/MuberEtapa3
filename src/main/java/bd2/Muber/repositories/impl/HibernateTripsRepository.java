/**
 * 
 */
package bd2.Muber.repositories.impl;

import org.hibernate.SessionFactory;

import bd2.Muber.model.Trip;

/**
 * @author yato
 *
 */
public class HibernateTripsRepository {

	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void add(Trip trip) {
		sessionFactory.getCurrentSession()
	}
	
	/*
	 * Obtener viajes abiertos formato SQL
	 * SELECT `TRIP_ID` FROM `TRIP` INNER JOIN PASSENGERTRIP ON(`TRIP_ID`= `idTrip`) WHERE `date` > CURDATE() GROUP by TRIP_ID, numberOfpassengers HAVING count(*) < `numberOfpassengers`"
	 */
}

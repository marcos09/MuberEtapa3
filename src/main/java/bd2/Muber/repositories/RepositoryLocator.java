package bd2.Muber.repositories;

import bd2.Muber.repositories.impl.HibernateDriversRepository;
import bd2.Muber.repositories.impl.HibernatePasajerosRepository;
import bd2.Muber.repositories.impl.HibernateTripsRepository;

public class RepositoryLocator {
	
	private static RepositoryLocator instance = new RepositoryLocator( );
	private HibernatePasajerosRepository pasajerosRepository;
	private HibernateDriversRepository driversRepository;
	private HibernateTripsRepository tripsRepository;
	
	public static RepositoryLocator  getInstance(){
		return instance;
	}
	
	   private RepositoryLocator() { }

	public HibernatePasajerosRepository getPasajerosRepository() {
		return pasajerosRepository;
	}

	public void setPasajerosRepository(HibernatePasajerosRepository pasajerosRepository) {
		this.pasajerosRepository = pasajerosRepository;
	}

	/**
	 * @return the driversRepository
	 */
	public HibernateDriversRepository getDriversRepository() {
		return driversRepository;
	}

	/**
	 * @param driversRepository the driversRepository to set
	 */
	public void setDriversRepository(HibernateDriversRepository driversRepository) {
		this.driversRepository = driversRepository;
	}

	/**
	 * @return the tripsRepository
	 */
	public HibernateTripsRepository getTripsRepository() {
		return tripsRepository;
	}

	/**
	 * @param tripsRepository the tripsRepository to set
	 */
	public void setTripsRepository(HibernateTripsRepository tripsRepository) {
		this.tripsRepository = tripsRepository;
	}
	   
	
}
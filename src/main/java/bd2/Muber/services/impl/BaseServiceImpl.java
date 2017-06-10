package bd2.Muber.services.impl;

import bd2.Muber.dto.DTOFactory;
import bd2.Muber.repositories.impl.HibernateDriversRepository;
import bd2.Muber.repositories.impl.HibernatePasajerosRepository;
import bd2.Muber.repositories.impl.HibernateTripsRepository;

public abstract class BaseServiceImpl {
	protected HibernatePasajerosRepository pasajerosRepository;
	protected HibernateDriversRepository driversRepository;
	protected HibernateTripsRepository tripsRepository;
	private DTOFactory dtoFactory;
	
	
	public HibernatePasajerosRepository getPasajerosRepository() {
		return pasajerosRepository;
	}
	
	
	public void setPasajerosRepository(HibernatePasajerosRepository pasajerosRepository) {
		this.pasajerosRepository = pasajerosRepository;
	}
	
	
	public HibernateDriversRepository getDriversRepository(){
		return driversRepository;
	}
	
	
	public void setDriversRepository(HibernateDriversRepository driversRepository) {
		this.driversRepository = driversRepository;
	}
	
	
	public HibernateTripsRepository getTripsRepository(){
		return tripsRepository;
	}
	
	
	public void setTripsRepository(HibernateTripsRepository tripsRepository) {
		this.tripsRepository = tripsRepository;
	}
	
	
	public DTOFactory getDtoFactory() {
		return dtoFactory;
	}
	
	
	public void setDtoFactory(DTOFactory dtoFactory) {
		this.dtoFactory = dtoFactory;
	}
	
	
}

package bd2.Muber.services.impl;

import bd2.Muber.dto.DTOFactory;
import bd2.Muber.repositories.impl.HibernatePasajerosRepository;

public abstract class BaseServiceImpl {
	private HibernatePasajerosRepository pasajerosRepository;
	private DTOFactory dtoFactory;
	
	public HibernatePasajerosRepository getPasajerosRepository() {
		return pasajerosRepository;
	}
	
	
	public void setPasajerosRepository(HibernatePasajerosRepository pasajerosRepository) {
		this.pasajerosRepository = pasajerosRepository;
	}
	
	
	public DTOFactory getDtoFactory() {
		return dtoFactory;
	}
	
	
	public void setDtoFactory(DTOFactory dtoFactory) {
		this.dtoFactory = dtoFactory;
	}
	
	
}

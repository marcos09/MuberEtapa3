package bd2.Muber.repositories;

import bd2.Muber.repositories.impl.HibernatePasajerosRepository;

public class RepositoryLocator {
	
	private static RepositoryLocator instance = new RepositoryLocator( );
	private HibernatePasajerosRepository pasajerosRepository;
	
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
	   
}
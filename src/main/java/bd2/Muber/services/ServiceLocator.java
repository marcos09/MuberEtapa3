package bd2.Muber.services;

import org.springframework.beans.factory.FactoryBean;

@SuppressWarnings("rawtypes")
public class ServiceLocator {
	private static ServiceLocator instance = new ServiceLocator( );
	
	private FactoryBean pasajeroService;
	
	public static ServiceLocator  getInstance(){
		return instance;
	}
	
	public FactoryBean getPasajeroService() {
		return pasajeroService;
	}

	public void setPasajeroService(FactoryBean pasajeroService) {
		this.pasajeroService = pasajeroService;
	}

	private ServiceLocator() { }


}

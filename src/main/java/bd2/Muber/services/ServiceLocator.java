package bd2.Muber.services;

import org.springframework.beans.factory.FactoryBean;

@SuppressWarnings("rawtypes")
public class ServiceLocator {
	private static ServiceLocator instance = new ServiceLocator( );
	
	private FactoryBean pasajeroService;
	private FactoryBean driverService;
	private FactoryBean tripService;
	
	public static ServiceLocator  getInstance(){
		return instance;
	}
	
	
	private ServiceLocator() { 
		
	}

	
	/**
	 * @return the pasajeroService
	 */
	public FactoryBean getPasajeroService() {
		return pasajeroService;
	}

	
	/**
	 * @param pasajeroService the pasajeroService to set
	 */
	public void setPasajeroService(FactoryBean pasajeroService) {
		this.pasajeroService = pasajeroService;
	}


	/**
	 * @return the driverService
	 */
	public FactoryBean getDriverService() {
		return driverService;
	}


	/**
	 * @param driverService the driverService to set
	 */
	public void setDriverService(FactoryBean driverService) {
		this.driverService = driverService;
	}


	/**
	 * @return the tripService
	 */
	public FactoryBean getTripService() {
		return tripService;
	}


	/**
	 * @param tripService the tripService to set
	 */
	public void setTripService(FactoryBean tripService) {
		this.tripService = tripService;
	}


}

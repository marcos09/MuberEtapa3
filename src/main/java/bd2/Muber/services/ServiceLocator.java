package bd2.Muber.services;

import org.hibernate.secure.internal.DisabledJaccServiceImpl;
import org.springframework.beans.factory.FactoryBean;

import bd2.Muber.services.impl.PasajerosServiceImpl;
import bd2.Muber.services.impl.TripsServiceImpl;

@SuppressWarnings("rawtypes")
public class ServiceLocator {
	private static ServiceLocator instance = new ServiceLocator( );
	
	protected PasajerosServiceImpl pasajerosService;
	private DisabledJaccServiceImpl driverService;
	private TripsServiceImpl tripService;
	
	public static ServiceLocator  getInstance(){
		return instance;
	}
	
	
	private ServiceLocator() { 
		
	}


	public PasajerosServiceImpl getPasajerosService() {
		return pasajerosService;
	}


	public void setPasajerosService(PasajerosServiceImpl pasajerosService) {
		this.pasajerosService = pasajerosService;
	}


	public DisabledJaccServiceImpl getDriverService() {
		return driverService;
	}


	public void setDriverService(DisabledJaccServiceImpl driverService) {
		this.driverService = driverService;
	}


	public TripsServiceImpl getTripService() {
		return tripService;
	}


	public void setTripService(TripsServiceImpl tripService) {
		this.tripService = tripService;
	}

	
}

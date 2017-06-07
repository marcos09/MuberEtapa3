package bd2.Muber.services;

import bd2.Muber.services.impl.DriversServiceImpl;
import bd2.Muber.services.impl.PasajerosServiceImpl;
import bd2.Muber.services.impl.TripsServiceImpl;

public class ServiceLocator {
	private static ServiceLocator instance = new ServiceLocator( );
	
	protected PasajerosServiceImpl pasajerosService;
	protected DriversServiceImpl driversService;
	protected TripsServiceImpl tripsService;
	
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


	public DriversServiceImpl getDriverService() {
		return driversService;
	}


	public void setDriverService(DriversServiceImpl driverService) {
		this.driversService = driverService;
	}


	public TripsServiceImpl getTripService() {
		return tripsService;
	}


	public void setTripService(TripsServiceImpl tripService) {
		this.tripsService = tripService;
	}

	
}

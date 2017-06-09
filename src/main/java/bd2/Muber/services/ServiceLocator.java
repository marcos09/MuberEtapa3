package bd2.Muber.services;

import bd2.Muber.services.impl.DriversServiceImpl;
import bd2.Muber.services.impl.PasajerosServiceImpl;
import bd2.Muber.services.impl.TripsServiceImpl;

public class ServiceLocator {
	private static ServiceLocator instance;
	
	protected PasajerosServiceImpl pasajerosService;
	protected DriversServiceImpl driversService;
	protected TripsServiceImpl tripsService;
	
	public static ServiceLocator  getInstance(){
		if(instance == null){
			instance  = new ServiceLocator();
		}
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


	public DriversServiceImpl getDriversService() {
		return driversService;
	}


	public void setDriversService(DriversServiceImpl driversService) {
		this.driversService = driversService;
	}


	public TripsServiceImpl getTripsService() {
		return tripsService;
	}


	public void setTripsService(TripsServiceImpl tripsService) {
		this.tripsService = tripsService;
	}


}

package bd2.Muber.model;

import java.util.Date;
import java.util.Collection;
import java.util.HashSet;

/**
 * @author yato
 *
 */

public class Driver extends User{
	
	private Long idUser;
	private String license;
	private Collection<Trip> trips; 
	
	
	public Driver(){
		this.setTrips(new HashSet<Trip>());
	}
	
	
	/**
	 * @param driver_name
	 * @param driver_password
	 * @param driver_date
	 * @param driver_license
	 */
	public Driver(String driver_name,  String driver_password, Date driver_date, String driver_license){
		super(driver_name, driver_password, driver_date);
		this.setLicense(driver_license);
	}

	
	
	public String getLicense() {
		return license;
	}


	public void setLicense(String license) {
		this.license = license;
	}


	public Collection<Trip> getTrips() {
		return trips;
	}


	public void setTrips(Collection<Trip> trips) {
		this.trips = trips;
	}


	/**
	 * agrega al viaje trip el conductor
	 * agrega a la colección driver_trips el viaje trip  
	 */
	public void addTrip(Trip trip){
		trip.setDriver(this);
		this.getTrips().add(trip);
	}

	
}
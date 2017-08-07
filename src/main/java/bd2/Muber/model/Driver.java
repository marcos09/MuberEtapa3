package bd2.Muber.model;

import java.util.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * @author yato
 *
 */

public class Driver extends User{
	
	private String license;
	private Collection<Trip> trips; 
	private Float score;
	
	public Driver(){
		this.setTrips(new HashSet<Trip>());
	}
	
	public Float getPromedyScore(){
		ArrayList<Integer> points = new ArrayList<Integer>();
		Iterator<Trip> iterator = (Iterator<Trip>) trips.iterator();
		while(iterator.hasNext()){
			points.addAll(iterator.next().getScore());
		}
		if(points.isEmpty()){
			return 0f;
		}
		Iterator <Integer>  i = points.iterator();
		Float sum = 0f;
		while(i.hasNext()){
			sum += i.next();
		}
		return sum/points.size();
		
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
	
	public Driver(String driver_name,  String driver_password, Date driver_date, String driver_license, Float score){
		super(driver_name, driver_password, driver_date);
		this.setLicense(driver_license);
		this.setScore(score);
	}
	
	
	
	/**
	 * @return the score
	 */
	public Float getScore() {
		return score;
	}


	/**
	 * @param score the score to set
	 */
	public void setScore(Float score) {
		this.score = score;
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
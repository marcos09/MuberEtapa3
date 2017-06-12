package bd2.Muber.dto;

import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import bd2.Muber.model.Driver;
import bd2.Muber.model.Trip;

public class DriverAllDTO {

	private String name;
	protected Date date;
	private Float score;
	private List<TripDTO> trips;

	public DriverAllDTO(){
		
	}

	public DriverAllDTO(Driver aDriver) {
		this.setName(aDriver.getName());
		this.setDate(aDriver.getFnac());
		this.setScore(aDriver.getScore());
		this.setTrips(this.transformCollectionDTO(aDriver.getTrips()));
	}

	public List<TripDTO> transformCollectionDTO(Collection<Trip> trips){
		List<TripDTO> tripsDTO = new LinkedList<TripDTO>();
		for (Trip aTrip : trips) {
			tripsDTO.add(new TripDTO(aTrip));
		}
		return tripsDTO;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}


	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
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


	/**
	 * @return the trips
	 */
	public List<TripDTO> getTrips() {
		return trips;
	}


	/**
	 * @param trips the trips to set
	 */
	public void setTrips(List<TripDTO> trips) {
		this.trips = trips;
	}
	
	
}

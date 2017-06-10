/**
 * 
 */
package bd2.Muber.dto;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import bd2.Muber.model.Driver;
import bd2.Muber.model.Passenger;
import bd2.Muber.model.Score;
import bd2.Muber.model.Trip;

/**
 * @author yato
 *
 */
public class TripDTO {

	private Float cost;
	private int numberOfpassengers;
	private Date date;
	private String from;
	private String to;
	private Collection<Passenger> passengers = new HashSet<Passenger>();
	private Driver driver;
	private Set<Score> scores= new HashSet<Score>();
	
	public TripDTO(){
		
	}
	
	
	public TripDTO(Trip aTrip){
		this.setCost(aTrip.getCost());
		this.setNumberOfpassengers(aTrip.getNumberOfpassengers());
		this.setDate(aTrip.getDate());
		this.setFrom(aTrip.getFrom());
		this.setTo(aTrip.getTo());
		this.setDriver(aTrip.getDriver());
		this.setScores(aTrip.getScores());		
		this.setPassengers(aTrip.getPassengers());
		//ver aca que queda la lista de pasajeros y no son DTO
		
	}


	/**
	 * @return the cost
	 */
	public Float getCost() {
		return cost;
	}


	/**
	 * @param cost2 the cost to set
	 */
	public void setCost(Float cost2) {
		this.cost = cost2;
	}


	/**
	 * @return the numberOfpassengers
	 */
	public int getNumberOfpassengers() {
		return numberOfpassengers;
	}


	/**
	 * @param numberOfpassengers the numberOfpassengers to set
	 */
	public void setNumberOfpassengers(int numberOfpassengers) {
		this.numberOfpassengers = numberOfpassengers;
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
	 * @return the from
	 */
	public String getFrom() {
		return from;
	}


	/**
	 * @param from the from to set
	 */
	public void setFrom(String from) {
		this.from = from;
	}


	/**
	 * @return the to
	 */
	public String getTo() {
		return to;
	}


	/**
	 * @param to the to to set
	 */
	public void setTo(String to) {
		this.to = to;
	}


	/**
	 * @return the passengers
	 */
	public Collection<Passenger> getPassengers() {
		return passengers;
	}


	/**
	 * @param passengers the passengers to set
	 */
	public void setPassengers(Collection<Passenger> passengers) {
		this.passengers = passengers;
	}


	/**
	 * @return the driver
	 */
	public Driver getDriver() {
		return driver;
	}


	/**
	 * @param driver the driver to set
	 */
	public void setDriver(Driver driver) {
		this.driver = driver;
	}


	/**
	 * @return the scores
	 */
	public Set<Score> getScores() {
		return scores;
	}


	/**
	 * @param scores the scores to set
	 */
	public void setScores(Set<Score> scores) {
		this.scores = scores;
	}
	
	
}

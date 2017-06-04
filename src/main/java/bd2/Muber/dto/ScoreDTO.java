/**
 * 
 */
package bd2.Muber.dto;

import bd2.Muber.model.Passenger;
import bd2.Muber.model.Score;
import bd2.Muber.model.Trip;

/**
 * @author yato
 *
 */
public class ScoreDTO {
	private String comment;
	private Integer number;
	private Passenger autor;
	private Trip trip;
	
	
	public ScoreDTO() {
		
	}

	
	public ScoreDTO(Score aScore) {
		this.setAutor(aScore.getAutor());
		this.setComment(aScore.getComment());
		this.setNumber(aScore.getNumber());
		this.setTrip(aScore.getTrip());
	}
	
	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}
	
	
	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
	/**
	 * @return the number
	 */
	public Integer getNumber() {
		return number;
	}
	
	
	/**
	 * @param number the number to set
	 */
	public void setNumber(Integer number) {
		this.number = number;
	}
	
	
	/**
	 * @return the autor
	 */
	public Passenger getAutor() {
		return autor;
	}
	
	
	/**
	 * @param autor the autor to set
	 */
	public void setAutor(Passenger autor) {
		this.autor = autor;
	}
	
	
	/**
	 * @return the trip
	 */
	public Trip getTrip() {
		return trip;
	}
	
	
	/**
	 * @param trip the trip to set
	 */
	public void setTrip(Trip trip) {
		this.trip = trip;
	}
	
	
}

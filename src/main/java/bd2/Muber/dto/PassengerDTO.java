/**
 * 
 */
package bd2.Muber.dto;

import bd2.Muber.model.Passenger;

/**
 * @author yato
 *
 */
public class PassengerDTO extends UserDTO{
	private Double credits;
	
	public PassengerDTO(){
		
	}
	
	public PassengerDTO(Passenger aPassenger){
		this.setName(aPassenger.getName());
		this.setDate(aPassenger.getFnac());
		this.setPassword(aPassenger.getPassword());
		this.setCredits(aPassenger.getCredits());
		this.setIdUser(aPassenger.getIdUser());
	}

	/**
	 * @return the credits
	 */
	public Double getCredits() {
		return credits;
	}

	/**
	 * @param credits the credits to set
	 */
	public void setCredits(Double credits) {
		this.credits = credits;
	}
}
	
	

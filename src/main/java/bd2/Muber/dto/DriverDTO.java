/**
 * 
 */
package bd2.Muber.dto;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import bd2.Muber.model.Driver;
import bd2.Muber.model.Trip;

/**
 * @author yato
 *
 */
public class DriverDTO extends UserDTO{
	
	private String license;
	//private List<TripDTO> trips;
	
	
	public DriverDTO(){
	
	}
	
	public DriverDTO(Driver aDriver) {
		this.setName(aDriver.getName());
		this.setPassword(aDriver.getPassword());
		this.setDate(aDriver.getFnac());
		this.setLicense(aDriver.getLicense());
		//this.setTrips(this.transformCollectionDTO(aDriver.getTrips()));
		this.setIdUser(aDriver.getIdUser());
	}
	
	
	/**
	 * @return the license
	 */
	public String getLicense() {
		return license;
	}
	
	
	/**
	 * @param license the license to set
	 */
	public void setLicense(String license) {
		this.license = license;
	}
	
	
	/**
	 * @return the trips
	 */
	/*
	public List<TripDTO> getTrips() {
		return trips;
	}
	
	public void setTrips(List<TripDTO> list) {
		this.trips = list;
	} 
	*/
	
	
	
	public List<TripDTO> transformCollectionDTO(Collection<Trip> trips){
		List<TripDTO> tripsDTO = new LinkedList<TripDTO>();
		for (Trip aTrip : trips) {
			tripsDTO.add(new TripDTO(aTrip));
		}
		return tripsDTO;
	}

}

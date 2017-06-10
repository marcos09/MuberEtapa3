package bd2.Muber.services.impl;

import bd2.Muber.dto.TripDTO;
import bd2.Muber.model.Driver;
import bd2.Muber.model.Trip;

/**
 * @author yato
 *
 */
public class TripsServiceImpl extends BaseServiceImpl{
	
	public TripDTO addTrip(TripDTO tripDTO, Long idUser){
		Driver driver = this.driversRepository.getUser(idUser);
		if(driver == null){
			return null;
		}
		else{
			tripDTO.setDriver(driver);
			Trip trip = new Trip(tripDTO);
			this.tripsRepository.add(trip);
		}
	}
}

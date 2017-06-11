package bd2.Muber.services.impl;

import java.util.ArrayList;

import bd2.Muber.dto.TripDTO;
import bd2.Muber.model.Driver;
import bd2.Muber.model.Trip;

/**
 * @author yato
 *
 */
/**
 * Calificar viaje, parámetros:
 * viajeId, pasajeroId, puntaje,comentario
 * Ver en que servicio ponerlo
 *
 */
public class TripsServiceImpl extends BaseServiceImpl{
	
	public TripDTO addTrip(TripDTO tripDTO, Long idDriver){
		Driver driver = this.driversRepository.getUser(idDriver);
		if(driver == null){
			return null;
		}
		else{
			tripDTO.setDriver(driver);
			Trip trip = new Trip(tripDTO);
			this.tripsRepository.add(trip);
			return null;
			//Ver este return Null que debería ser otra cosa
		}
	}
	
	public ArrayList<TripDTO> getOpenTrips(){
		return null;
	}
	
	public TripDTO addPassenger(Long idTrip,Long idPassenger){
		
		
		return null;
	}
	
	public TripDTO closeTrip(Long idTrip){
		
		Trip trip = this.tripsRepository.closeTrip(idTrip);
		if(trip == null){
			return null;
		}
		return new TripDTO(trip);
	}
}

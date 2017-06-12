package bd2.Muber.services.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import bd2.Muber.dto.PassengerDTO;
import bd2.Muber.dto.TripDTO;
import bd2.Muber.model.Driver;
import bd2.Muber.model.Passenger;
import bd2.Muber.model.Score;
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

		Iterator iterator = (Iterator) this.tripsRepository.getOpenTrips().iterator();
		ArrayList<TripDTO> tripsDTO = new ArrayList<TripDTO>();
		while(iterator.hasNext()){
			Trip trip = (Trip) iterator.next();
		 	tripsDTO.add(new TripDTO(trip));
		}
		return tripsDTO;
		
	}
	
	public TripDTO addPassenger(Long idTrip, Long idPassenger){
		System.out.println("Estoy en el servicio");
		Trip trip = this.tripsRepository.addPassenger(idPassenger, idTrip);
		System.out.println("Terminé el repositorio");
		if (trip == null)
			return null;
		return new TripDTO(trip);
	}
	
	
	public TripDTO closeTrip(Long idTrip){
		
		Trip trip = this.tripsRepository.closeTrip(idTrip);
		if(trip == null){
			return null;
		}
		return new TripDTO(trip);
	}

	public TripDTO qualifyTrip(Long idTrip, Long idPassenger, int score, String comment) {
		Trip trip = this.tripsRepository.getTrip(idTrip);
		if(trip != null){
			System.out.println("El viaje existe");
			if(trip.canQualify()){
				System.out.println("La fecha y la cantidad de pasajeros cierra");
				Passenger passenger = this.pasajerosRepository.getUser(idPassenger);
				if(passenger != null){
					System.out.println("Existe el usuario");
					if(trip.getPassengers().contains(passenger)){
						System.out.println("Se debería haber creado la calificación");
						Score scoreNew = new Score(comment, score, trip, passenger);
						trip.addScore(scoreNew);
						tripsRepository.saveOrUpdate(trip);
						return new TripDTO(trip);
					}
				}	
			}
		}
		System.out.println("No se pudo calificar");
		return null;
	}
}

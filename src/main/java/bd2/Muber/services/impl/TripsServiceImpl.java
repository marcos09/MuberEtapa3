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

public class TripsServiceImpl extends BaseServiceImpl{
	
	public TripDTO addTrip(TripDTO tripDTO, Long idDriver){
		Driver driver = this.driversRepository.getUser(idDriver);
		if(driver == null){
			System.out.println("El conductor no existe");
			return null;
		}
		else{
			tripDTO.setDriver(driver);
			Trip trip = new Trip(tripDTO);
			this.tripsRepository.add(trip);
			return tripDTO;
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
		Trip trip = this.tripsRepository.addPassenger(idPassenger, idTrip);
		if (trip == null)
			return null;
		return new TripDTO(trip);
	}
	
	/*
	 * Mensaje que finaliza el viaje y descuenta el crédito de los pasajeros
	 * que se unieron al viaje. No está especificado como hacer el control 
	 * del descuento de créditos que no que queden negativos. 
	 * */
	public TripDTO closeTrip(Long idTrip){
		
		Trip trip = this.tripsRepository.closeTrip(idTrip);
		if(trip == null){
			return null;
		}
		return new TripDTO(trip);
	}
	public ArrayList<TripDTO> getDriverPromedy(Long idDriver){
		Driver driver = this.driversRepository.getDetail(idDriver);
		this.tripsRepository.getDriverPromedy(driver);
		return null;
	}
		
		
	
	public TripDTO qualifyTrip(Long idTrip, Long idPassenger, int score, String comment) {
		TripDTO tripDTO = null;
		Trip trip = this.tripsRepository.getTrip(idTrip);
		if(trip != null){
			System.out.println("El viaje existe");
			if(trip.canQualify()){
				System.out.println("Puedo calificar");
				Passenger passenger = this.pasajerosRepository.getUser(idPassenger);
				if(passenger != null){
					System.out.println("Existe el pasajero");
					if(trip.getPassengers().contains(passenger)){
						Score scoreNew = new Score(comment, score, trip, passenger);
						trip.addScore(scoreNew);
						tripsRepository.saveOrUpdate(trip);
						System.out.println("Agregué una calificación");
						tripDTO = new TripDTO(trip);
					}
				}	
			}
		}
		return tripDTO;
	}
}

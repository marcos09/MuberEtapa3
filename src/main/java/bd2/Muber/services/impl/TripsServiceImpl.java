package bd2.Muber.services.impl;

import java.util.ArrayList;
import java.util.Iterator;

import bd2.Muber.dto.DriverDTO;
import bd2.Muber.dto.ErrorDTO;
import bd2.Muber.dto.TripDTO;
import bd2.Muber.model.Driver;
import bd2.Muber.model.Passenger;
import bd2.Muber.model.Score;
import bd2.Muber.model.Trip;

public class TripsServiceImpl extends BaseServiceImpl{
	
	public TripDTO addTrip(TripDTO tripDTO, Long idDriver){
		Driver driver = this.driversRepository.getUser(idDriver);
		if(driver == null){
			return null;
		}
		else{
			tripDTO.setDriver(new DriverDTO(driver));
			Trip trip = new Trip(tripDTO);
			this.tripsRepository.add(trip);
			return new TripDTO(trip);
		}
	}
	
	public ArrayList<TripDTO> getOpenTrips(){

		@SuppressWarnings("rawtypes")
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
			if(trip.canQualify()){
				Passenger passenger = this.pasajerosRepository.getUser(idPassenger);
				if(passenger != null){
					if(trip.getPassengers().contains(passenger)){
						Score scoreNew = new Score(comment, score, trip, passenger);
						trip.addScore(scoreNew);
						tripsRepository.saveOrUpdate(trip);
						tripDTO = new TripDTO(trip);
					}
				}	
			}
		}
		return tripDTO;
	}
	
	/*
	 * Mensaje que sirve para detectar el error que produjo que no se agregar un pasajero al viaje.
	 * */
	public ErrorDTO getErrorAdd(Long idTrip, Long idPassenger){
		
		Trip trip = this.tripsRepository.getTrip(idTrip);
		if(trip != null){
			if(trip.getNumberOfpassengers() <= trip.getPassengers().size()){
				return new ErrorDTO("El viaje ya se encuentra lleno. No es posible agregar mas pasajeros");
			}
			else{
					return new ErrorDTO("El pasajero que intenta agregar no existe");
			}
			
		}
		return new ErrorDTO("El viaje solicitado no existe");
	}
	/*
	 * Mensaje que sirve para detectar el error que produjo que no se pueda calificar un viaje.
	 * */
	public ErrorDTO getError(Long idTrip, Long idPassenger){
		Trip trip = this.tripsRepository.getTrip(idTrip);
		if(trip != null){
			if(trip.canQualify()){
				Passenger passenger = this.pasajerosRepository.getUser(idPassenger);
				if(passenger != null){
					if(!trip.getPassengers().contains(passenger)){
						return new ErrorDTO("El pasajero indicado no participó del viaje");
					}
				}
				return new ErrorDTO("El pasajero que intenta agregar al viaje no existe");
			}
			return new ErrorDTO("No es posible calificar el viaje indicado. Puede que no haya pasado su fecha, no esté finalizado o bien todos sus participantes ya han calificado");

		}
		ErrorDTO error = new ErrorDTO("El viaje solicitado no existe");
		return error;
	}
}

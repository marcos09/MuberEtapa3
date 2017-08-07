package bd2.Muber.services.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

import bd2.Muber.dto.PassengerDTO;
import bd2.Muber.model.Passenger;
import bd2.Muber.model.Trip;

public class PasajerosServiceImpl extends BaseServiceImpl{

	
	public ArrayList<PassengerDTO> getPassenger(){
		ArrayList<PassengerDTO> passengersDTO = new ArrayList<PassengerDTO>();
		List result = (List) this.pasajerosRepository.getPassenger();
		Iterator iterator = result.iterator();
		while(iterator.hasNext()){
			Passenger p = (Passenger) iterator.next();
		 	passengersDTO.add(new PassengerDTO(p));
		}
		return passengersDTO;
	}
	
	public PassengerDTO addCredit(Long idUser, Float credit){
		Passenger passenger = this.pasajerosRepository.addCredit(idUser, credit);
		if(passenger == null){
			return null;
		}
		return new PassengerDTO(passenger);
		
	}

	public Long addPassenger(PassengerDTO passengerGerman) {
		Passenger pepe = new Passenger();
		Passenger passenger = new Passenger();
		passenger.setCredits(passengerGerman.getCredits());
		passenger.setFnac(passengerGerman.getDate());
		passenger.setName(passengerGerman.getName());
		passenger.setPassword(passengerGerman.getPassword());
		Passenger passengerSaved = (Passenger) this.pasajerosRepository.saveOrUpdate(passenger);
		return passengerSaved.getIdUser();
		
	}
}

package bd2.Muber.services.impl;

import java.util.ArrayList;
import java.util.Iterator;

import bd2.Muber.dto.DriverDTO;
import bd2.Muber.dto.PassengerDTO;
import bd2.Muber.model.Driver;
import bd2.Muber.model.Passenger;

public class PasajerosServiceImpl extends BaseServiceImpl{
	
	
	/**
	 * retorna una lista que contiene los pasajeros de Muber 
	 *
	 */
	public ArrayList<PassengerDTO> getPassenger(){
		ArrayList<PassengerDTO> passengersDTO = new ArrayList<PassengerDTO>();
		Iterator<Passenger> iterator = this.pasajerosRepository.getPassenger().iterator();
		while(iterator.hasNext()){
			Passenger p = (Passenger) iterator.next();
			passengersDTO.add(new PassengerDTO(p));
		}
		return passengersDTO;
	}
	
}

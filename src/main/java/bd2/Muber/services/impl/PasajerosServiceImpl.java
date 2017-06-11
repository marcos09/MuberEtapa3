package bd2.Muber.services.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import bd2.Muber.dto.PassengerDTO;
import bd2.Muber.model.Passenger;

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
		System.out.println("Estoy en el servicio");
		Passenger passenger = this.pasajerosRepository.addCredit(idUser, credit);
		System.out.println("Llegué y retorno null");
		
		if(passenger == null){
			return null;
		}
		return new PassengerDTO(passenger);
		
	}
}

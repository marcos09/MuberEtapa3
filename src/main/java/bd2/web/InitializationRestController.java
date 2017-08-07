package bd2.web;

import java.util.Collection;
import java.util.Date;
import java.util.Set;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import bd2.Muber.dto.*;
import bd2.Muber.model.Driver;
import bd2.Muber.model.Passenger;
import bd2.Muber.model.Score;

@ControllerAdvice
@RequestMapping("/init")
@ResponseBody
@EnableWebMvc

public class InitializationRestController {
	
	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json", headers = "Accept=application/json")
	@SuppressWarnings("deprecation")
	public void createTrip() {
		
		Date date = new Date(16, 8, 2017);
		Date date_user = new Date(16, 8, 1980);
		Driver conductorRoberto = new Driver();
		conductorRoberto.setName("Roberto");
		conductorRoberto.setPassword("Roberto");
		TripDTO trip= new TripDTO(900f, 4, date, "La Plata", "Tres Arroyos", null, conductorRoberto, null );
		
		PassengerDTO passengerGerman, passengerMargarita, passengerAlicia;
		
		passengerGerman = new PassengerDTO(1500.0, "German", "pasajeroGerman", date_user);
		passengerAlicia = new PassengerDTO(1500.0, "Alicia", "pasajeroAlicia", date_user);
		passengerMargarita = new PassengerDTO(1500.0, "German", "pasajeroMargarita", date_user);	
	}	

}

/*
 * @SuppressWarnings("deprecation")
		Muber muber = new Muber();
		
		Trip trip = new Trip(900f, 4, date, "La Plata", "Tres Arroyos");
		
		Driver roberto = new Driver("Roberto", "robertito", date, "license#");
		
		Passenger german, alicia, margarita;
		german = new Passenger("German", "pasajeroGerman", date_user, 1500.0);
		alicia = new Passenger("Alicia", "pasajeroAlicia", date_user, 1500.0);
		margarita = new Passenger("Margarita", "pasajeroMarga", date_user, 1500.0);
		
		muber.addDriver(roberto);
		muber.addPassenger(german);
		muber.addPassenger(alicia);
		muber.addPassenger(margarita);
	
		muber.addTripBy(trip, roberto);
		
		muber.addPassengerToTrip(trip, german);
		muber.addPassengerToTrip(trip, alicia);
		muber.addPassengerToTrip(trip, margarita);
		
		trip.discountCredit();		
		muber.qualifyTrip(trip, german, new Score("Buen viaje", 5));
		muber.qualifyTrip(trip, alicia, new Score("Volvería a viajar", 4));
		muber.qualifyTrip(trip, margarita, new Score("Rapidísimo", 4));
 */

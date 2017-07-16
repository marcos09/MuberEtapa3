package bd2.web;

import java.sql.Date;
import java.util.Collection;
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
/*
 @SuppressWarnings("deprecation")
		Date date = new Date(16, 04, 2017);
		
		@SuppressWarnings("deprecation")
		Date date_user = new Date(10,10,2016);
		
		Muber muber = new Muber();
		
				
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
		
		
		Session s = sessionFactory.getCurrentSession();
		s.beginTransaction();
		s.save(muber);
		s.getTransaction().commit();
		
		*/

public class InitializationRestController {
	
	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json", headers = "Accept=application/json")
	public void createTrip() {
		Date date = new Date(16, 04, 2017);
		Date date_user = new Date(10,10,2016);
		
		PassengerDTO passengerGerman, passengerMargarita, passengerAlicia;
		
		passengerGerman = new PassengerDTO(1500.0, "German", "pasajeroGerman", date_user);
		passengerAlicia = new PassengerDTO(1500.0, "Alicia", "pasajeroAlicia", date_user);
		passengerMargarita = new PassengerDTO(1500.0, "German", "pasajeroMargarita", date_user);
		
		Driver roberto = new Driver("Roberto", "robertito", date, "license#");
		
		Driver driver = new Driver(); 
		driver.setName("Roberto");
		driver.setFnac(date);
		driver.setPassword("conductorRoberto");

		TripDTO trip = new TripDTO(900f, 4, date, "La Plata", "Tres Arroyos",null, driver, null);
		
		System.out.println("Entré en el server de inicialization.");

					
	}	

}

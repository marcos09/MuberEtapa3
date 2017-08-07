package bd2.web;

import java.util.Collection;
import java.util.Date;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import bd2.Muber.dto.*;
import bd2.Muber.model.Driver;
import bd2.Muber.model.Passenger;
import bd2.Muber.model.Score;
import bd2.Muber.services.ServiceLocator;
import bd2.Muber.services.impl.DriversServiceImpl;
import bd2.Muber.services.impl.PasajerosServiceImpl;
import bd2.Muber.services.impl.TripsServiceImpl;

@ControllerAdvice
@RequestMapping("/services/init")
@ResponseBody
@EnableWebMvc

public class InitializationRestController {
	
	PasajerosServiceImpl passengerService = ServiceLocator.getInstance().getPasajerosService();
	DriversServiceImpl driverService = ServiceLocator.getInstance().getDriversService();
	TripsServiceImpl tripService = ServiceLocator.getInstance().getTripsService();
	
	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json", headers = "Accept=application/json")
	@SuppressWarnings("deprecation")
	public void createTrip() {
		
		Date date = new Date(16, 7, 2017);
		Date date_user = new Date(16, 8, 1980);
		
		DriverDTO roberto = new DriverDTO();
		roberto.setName("Roberto");
		roberto.setPassword("passRoberto");
		roberto.setLicense("Julio 2018");
		roberto.setDate(date);
	
		Long idDriver = driverService.add(roberto);
		
		
		PassengerDTO passengerGerman, passengerAlicia, passengerMargarita;
		passengerGerman = new PassengerDTO(1500.0, "German", "pasajeroGerman", date_user);
		passengerAlicia = new PassengerDTO(1500.0, "Alicia", "pasajeroAlicia", date_user);
		passengerMargarita = new PassengerDTO(1500.0, "German", "pasajeroMargarita", date_user);
		
		Long idGerman = passengerService.addPassenger(passengerGerman);
		Long idAlicia = passengerService.addPassenger(passengerAlicia);
		Long idMargarita = passengerService.addPassenger(passengerMargarita);
		
		TripDTO trip = new TripDTO();
		trip.setCost(900f);
		trip.setDate(date_user);
		trip.setFrom("La Plata");
		trip.setTo("Tres Arroyos");
		trip.setNumberOfpassengers(4);
		
		Long idTrip = tripService.addTripId(trip, idDriver);

		tripService.addPassenger(idTrip, idGerman);
		tripService.addPassenger(idTrip, idAlicia);
		tripService.addPassenger(idTrip, idMargarita);
		
		tripService.closeTrip(idTrip);
		TripDTO tripDTO;
		tripDTO = tripService.qualifyTrip(idTrip ,idGerman, 5, "Buen viaje");
		tripDTO = tripService.qualifyTrip(idTrip,idAlicia, 4, "Volvería a viajar");
		tripDTO = tripService.qualifyTrip(idTrip,idMargarita, 4, "Rapidisimo");
		System.out.println("Terminé el init");
			
	}	

}
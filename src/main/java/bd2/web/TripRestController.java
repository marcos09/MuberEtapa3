package bd2.web;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import bd2.Muber.dto.ErrorDTO;
import bd2.Muber.dto.TripDTO;
import bd2.Muber.dto.TripId;
import bd2.Muber.dto.TripPassenger;
import bd2.Muber.services.ServiceLocator;
import bd2.Muber.services.impl.TripsServiceImpl;


@ControllerAdvice
@RequestMapping("services/viajes")
@ResponseBody
@EnableWebMvc

public class TripRestController {

	TripsServiceImpl tripService = ServiceLocator.getInstance().getTripsService();
	
	@RequestMapping(value = "/abiertos", method = RequestMethod.GET, produces = "application/json", headers = "Accept=application/json")
	public ResponseEntity<ArrayList<TripDTO>> passenger() {
		ArrayList<TripDTO> trips = tripService.getOpenTrips();
		if(trips == null){
			return new ResponseEntity<ArrayList<TripDTO>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<ArrayList<TripDTO>>(trips,HttpStatus.OK);
		
	}
	
	
	/*
	 * Genera un nuevo viaje con el conductor y lo agrega en la colección 
	 * */
	@RequestMapping(value = "/nuevo", method = RequestMethod.POST, produces = "application/json", headers = "Accept=application/json")
	public ResponseEntity<?> createTrip(@RequestParam(value="origen", required=true) String tripOrigin, @RequestParam(value="destino", required=true) String tripTo, @RequestParam(value="conductorId", required=true) Long idDriver, @RequestParam(value="costoTotal", required=true) Float cost, @RequestParam(value="cantidadPasajeros", required=true) int numberOfPassengers ) {
				
		TripDTO tripDTO= new TripDTO();
		tripDTO.setCost(cost);		
		tripDTO.setNumberOfpassengers(numberOfPassengers);
		tripDTO.setTo(tripTo);
		tripDTO.setFrom(tripOrigin);
		tripDTO = tripService.addTrip(tripDTO, idDriver);
		
		if(tripDTO == null){
			ErrorDTO error = new ErrorDTO("El conductor indicado para el viaje no existe");
			return new ResponseEntity<ErrorDTO>(error, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<TripDTO>(tripDTO,HttpStatus.CREATED);
		
	}
		
	@RequestMapping(value = "/agregarPasajero", method = RequestMethod.PUT, produces = "application/json", headers = "Accept=application/json")
	public void addPassenger2(@RequestBody TripPassenger parameters) {

		tripService.addPassenger(parameters.getViajeId(), parameters.getPasajeroId());

	}
	
	@RequestMapping(value = "/calificar", method = RequestMethod.POST, produces = "application/json", headers = "Accept=application/json")
	public ResponseEntity<?> scoreTrip(@RequestParam(value="viajeId", required=true) Long idTrip, @RequestParam(value="pasajeroId", required=true) Long idPassenger, @RequestParam(value="puntaje", required=true) int score, @RequestParam(value="comentario", required=true) String comment) {
		
		TripDTO tripDTO = tripService.qualifyTrip(idTrip,idPassenger, score, comment);
		if(tripDTO != null){
			return new ResponseEntity<TripDTO>(tripDTO,HttpStatus.OK);
		}
		ErrorDTO error = tripService.getError(idTrip, idPassenger);
		return new ResponseEntity<ErrorDTO>(error, HttpStatus.BAD_REQUEST);
		
	}
	
	
	@RequestMapping(value = "/finalizar", method = RequestMethod.PUT, produces = "application/json", headers = "Accept=application/json")
	public ResponseEntity<?> closeTrip(@RequestBody TripId parameters) {
		Long idTrip = parameters.getViajeId();
		TripDTO tripDTO = tripService.closeTrip(idTrip);
		if(tripDTO == null){
			ErrorDTO error = new ErrorDTO("El viaje que intenta finalizar no existe");
			return new ResponseEntity<ErrorDTO>(error, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<TripDTO>(tripDTO,HttpStatus.OK);
	}

}
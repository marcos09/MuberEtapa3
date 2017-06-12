package bd2.web;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import bd2.Muber.dto.TripDTO;
import bd2.Muber.services.ServiceLocator;
import bd2.Muber.services.impl.TripsServiceImpl;


@ControllerAdvice
@RequestMapping("/viajes")
@ResponseBody
@EnableWebMvc

//Ver como mejorar el mapping para que tome el /services de la superclase y no repetire las anotaciones en todos

public class TripRestController extends MuberRestController{

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
	 * Ver fecha del viaje
	 * Genera un nuevo viaje con el conductor y lo agrega en la colección 
	 * */
	@RequestMapping(value = "/nuevo", method = RequestMethod.POST, produces = "application/json", headers = "Accept=application/json")
	public ResponseEntity<TripDTO> createTrip(@RequestParam(value="origen", required=true) String tripOrigin, @RequestParam(value="destino", required=true) String tripTo, @RequestParam(value="conductorId", required=true) Long idDriver, @RequestParam(value="costoTotal", required=true) Float cost, @RequestParam(value="cantidadPasajeros", required=true) int numberOfPassengers ) {
		
		//Funcionando: Ver error de fechas y del idUsuario que no se carga bien. Procesar bien la respuesta del service
		
		TripDTO tripDTO= new TripDTO();
		tripDTO.setCost(cost);		
		tripDTO.setNumberOfpassengers(numberOfPassengers);
		tripDTO.setTo(tripTo);
		tripDTO.setFrom(tripOrigin);
		tripDTO = tripService.addTrip(tripDTO, idDriver);
		
		if(tripDTO == null){
			return new ResponseEntity<TripDTO>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<TripDTO>(tripDTO, HttpStatus.CREATED);
		
	}
	
	@RequestMapping(value = "/agregarPasajero", method = RequestMethod.PUT, produces = "application/json", headers = "Accept=application/json")
	public String addPassenger(@RequestParam(value="viajeId", required=true) Long idTrip, @RequestParam(value="pasajeroId", required=true) Long idPassenger) {
		tripService.addPassenger(idTrip, idPassenger);
		return null;
	}
	
	@RequestMapping(value = "/calificar", method = RequestMethod.POST, produces = "application/json", headers = "Accept=application/json")
	public String scoreTrip(@RequestParam(value="viajeId", required=true) Long idTrip, @RequestParam(value="pasajeroId", required=true) Long idPassenger, @RequestParam(value="puntaje", required=true) int score, @RequestParam(value="comentario", required=true) String comment) {
		
		TripDTO tripDTO = tripService.qualifyTrip(idTrip,idPassenger, score, comment);
		return null;
	}
	
	//Ver...Devuelve un 403 no se por que
	@RequestMapping(value = "/finalizar", method = RequestMethod.PUT, produces = "application/json", headers = "Accept=application/json")
	public ResponseEntity<TripDTO> closeTrip(@RequestParam(value="viajeId", required=true) Long idTrip) {
		
		TripDTO tripDTO = tripService.closeTrip(idTrip);
		if(tripDTO == null){
			return new ResponseEntity<TripDTO>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<TripDTO>(HttpStatus.NO_CONTENT);
	}

}
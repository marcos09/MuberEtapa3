package bd2.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.google.gson.Gson;

import bd2.Muber.dto.TripDTO;
import bd2.Muber.services.ServiceLocator;
import bd2.Muber.services.impl.DriversServiceImpl;
import bd2.Muber.services.impl.TripsServiceImpl;


@ControllerAdvice
@RequestMapping("/viajes")
@ResponseBody
@EnableWebMvc

//Ver como mejorar el mapping para que tome el /services de la superclase y no repetire las anotaciones en todos

public class TripRestController extends MuberRestController{

	TripsServiceImpl tripService = ServiceLocator.getInstance().getTripsService();
	
	@RequestMapping(value = "/abiertos", method = RequestMethod.GET, produces = "application/json", headers = "Accept=application/json")
	public String passenger() {
		

		Map<String, Object> aMap = new HashMap<String, Object>();
		aMap.put("Acá debería devolver todos los viajes no finalizados", "OK");
		return new Gson().toJson(aMap);
	}
	/*
	 * Ver fecha del viaje
	 * */
	@RequestMapping(value = "/nuevo", method = RequestMethod.POST, produces = "application/json", headers = "Accept=application/json")
	public String createTrip(@RequestParam(value="origen", required=true) String tripOrigin, @RequestParam(value="destino", required=true) String tripTo, @RequestParam(value="conductorId", required=true) int idDriver, @RequestParam(value="costoTotal", required=true) Float cost, @RequestParam(value="cantidadPasajeros", required=true) int numberOfPassengers ) {
		//tripDTO.setDate(new Date(date));
		TripDTO tripDTO= new TripDTO();
		tripDTO.setCost(cost);
		
		tripDTO.setNumberOfpassengers(numberOfPassengers);
		//tripDTO.setDriver(idDriver);
		tripDTO.setTo(tripTo);
		tripDTO.setFrom(tripOrigin);
		tripService.addTrip(tripDTO, idDriver);
		return null;
	}
	
	@RequestMapping(value = "/agregarPasajero", method = RequestMethod.PUT, produces = "application/json", headers = "Accept=application/json")
	public String createTrip(@RequestParam(value="viajeId", required=true) int idTrip, @RequestParam(value="pasajeroId", required=true) int idPassenger) {
		return null;
	}
	
	@RequestMapping(value = "/calificar", method = RequestMethod.POST, produces = "application/json", headers = "Accept=application/json")
	public String scoreTrip(@RequestParam(value="viajeId", required=true) int idTrip, @RequestParam(value="pasajeroId", required=true) int idPassenger, @RequestParam(value="puntaje", required=true) int score, @RequestParam(value="comentario", required=true) String comment) {
		
		return null;
	}
	
	@RequestMapping(value = "/finalizar", method = RequestMethod.PUT, produces = "application/json", headers = "Accept=application/json")
	public String closeTrip(@RequestParam(value="viajeId", required=true) int idTrip) {
		return null;
	}

}
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


@ControllerAdvice
@RequestMapping("/viajes")
@ResponseBody
@EnableWebMvc

//Ver como mejorar el mapping para que tome el /services de la superclase y no repetire las anotaciones en todos

public class TripRestController extends MuberRestController{



	@RequestMapping(value = "/abiertos", method = RequestMethod.GET, produces = "application/json", headers = "Accept=application/json")
	public String passenger() {
		

		Map<String, Object> aMap = new HashMap<String, Object>();
		aMap.put("Acá debería devolver todos los viajes no finalizados", "OK");
		return new Gson().toJson(aMap);
	}
	
	@RequestMapping(value = "/nuevo", method = RequestMethod.POST, produces = "application/json", headers = "Accept=application/json")
	public String createTrip(@RequestParam(value="origen", required=true) String tripOrigin, @RequestParam(value="destino", required=true) String tripTo, @RequestParam(value="conductorId", required=true) String idDriver, @RequestParam(value="costoTotal", required=true) Float cost, @RequestParam(value="cantidadPasajeros", required=true) String numberOfPassengers ) {
		Map<String, Object> aMap = new HashMap<String, Object>();
		aMap.put("Acá debería agregar un nuevo viaje", "OK");
		aMap.put("El origen ingresado fue:", tripOrigin);
		aMap.put("El destino recibido fue: ", tripTo);
		return new Gson().toJson(aMap);
	}
	
	@RequestMapping(value = "/agregarPasajero", method = RequestMethod.PUT, produces = "application/json", headers = "Accept=application/json")
	public String createTrip(@RequestParam(value="viajeId", required=true) int idTrip, @RequestParam(value="pasajeroId", required=true) int idPassenger) {
		Map<String, Object> aMap = new HashMap<String, Object>();
		aMap.put("Acá debería agregar un pasajero al viaje con id: ", idTrip );
		aMap.put("El id del pasajero que se agrega al viaje fue: ", idPassenger );
		return new Gson().toJson(aMap);
	}
	
	@RequestMapping(value = "/calificar", method = RequestMethod.POST, produces = "application/json", headers = "Accept=application/json")
	public String scoreTrip(@RequestParam(value="viajeId", required=true) int idTrip, @RequestParam(value="pasajeroId", required=true) int idPassenger, @RequestParam(value="puntaje", required=true) int score, @RequestParam(value="comentario", required=true) String comment) {
		Map<String, Object> aMap = new HashMap<String, Object>();
		aMap.put("Vamos a calificar el viaje con id: ", idTrip );
		aMap.put("El id del pasajero que calificó el viaje fue: ", idPassenger );
		return new Gson().toJson(aMap);
	}
	
	@RequestMapping(value = "/finalizar", method = RequestMethod.PUT, produces = "application/json", headers = "Accept=application/json")
	public String closeTrip(@RequestParam(value="viajeId", required=true) int idTrip) {
		Map<String, Object> aMap = new HashMap<String, Object>();
		aMap.put("Acá debería finalizar el viaje con id: ", idTrip );
		
		return new Gson().toJson(aMap);
	}



}
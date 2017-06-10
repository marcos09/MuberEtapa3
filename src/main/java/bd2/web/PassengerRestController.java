package bd2.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.google.gson.Gson;

import bd2.Muber.dto.DriverDTO;
import bd2.Muber.dto.PassengerDTO;
import bd2.Muber.services.ServiceLocator;
import bd2.Muber.services.impl.PasajerosServiceImpl;



@ControllerAdvice
@RequestMapping("/pasajeros")
@ResponseBody
@EnableWebMvc

//Ver como mejorar el mapping para que tome el /services de la superclase y no repetire las anotaciones en todos


public class PassengerRestController extends MuberRestController{
	PasajerosServiceImpl passengerService = ServiceLocator.getInstance().getPasajerosService();

	
	/**
	 *recarga un monto al credito del pasajero con id pasajeroId
	 *
	 */
	@RequestMapping(value = "/cargarCredito", method = RequestMethod.PUT, produces = "application/json", headers = "Accept=application/json")
	public String createTrip(@RequestParam(value="pasajeroId", required=true) int idPassenger, @RequestParam(value="monto", required=true) Float credits) {
		Map<String, Object> aMap = new HashMap<String, Object>();
		aMap.put("Acá se le carga crédito al pasajero con id: ", idPassenger );
		aMap.put("La cantidad todal de créditos a agregar fueron: ", credits );
		return new Gson().toJson(aMap);
	}
	
	
	//Ver ese mapeo que está mal. Debería recibir solo los /pasajeros/
	/**
	 *genera una lista de los pasajeros de Muber 
	 *
	 */
	@RequestMapping(value = "/listar", method = RequestMethod.GET, produces = "application/json", headers = "Accept=application/json")
	public String passenger() {
		
		Map<String, Object> aMap = new HashMap<String, Object>();
		
		aMap.put("Listado de pasajeros", "resultado");
		return new Gson().toJson(aMap);
	}
	
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET, produces = "application/json", headers = "Accept=application/json")
	public ResponseEntity<ArrayList<PassengerDTO>> getDrivers() {
		ArrayList<PassengerDTO> result = passengerService.getPassenger();
		return new ResponseEntity<ArrayList<PassengerDTO>>(result,HttpStatus.OK );
	}


}

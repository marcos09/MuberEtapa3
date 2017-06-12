package bd2.web;

import java.util.ArrayList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import bd2.Muber.dto.PassengerDTO;
import bd2.Muber.dto.TripDTO;
import bd2.Muber.services.ServiceLocator;
import bd2.Muber.services.impl.PasajerosServiceImpl;

@ControllerAdvice
@RequestMapping("services/pasajeros")
@ResponseBody
@EnableWebMvc

//Ver como mejorar el mapping para que tome el /services de la superclase y no repetire las anotaciones en todos


public class PassengerRestController {

	PasajerosServiceImpl passengerService = ServiceLocator.getInstance().getPasajerosService();
	
	@RequestMapping(value = "/cargarCredito", method = RequestMethod.PUT, produces = "application/json", headers = "Accept=application/json")
	public ResponseEntity<PassengerDTO> addCredit(@RequestParam(value="pasajeroId", required=true) Long idPassenger, @RequestParam(value="monto", required=true) Float credits) {		
		PassengerDTO passengerDTO = this.passengerService.addCredit(idPassenger, credits);
		if(passengerDTO == null){
			return new ResponseEntity<PassengerDTO>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<PassengerDTO>(passengerDTO, HttpStatus.OK);
	}
	

	//Ver ese mapeo que está mal. Debería recibir solo los /pasajeros/
	
	/**
	 * Devuelve una lista de los pasajeros de Muber
	 */
	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json", headers = "Accept=application/json")
	public ResponseEntity<ArrayList<PassengerDTO>> getDrivers() {
		ArrayList<PassengerDTO> result = passengerService.getPassenger();
		return new ResponseEntity<ArrayList<PassengerDTO>>(result,HttpStatus.OK );
	}
	

}

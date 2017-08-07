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

import bd2.Muber.dto.DriverAllDTO;
import bd2.Muber.dto.DriverDTO;
import bd2.Muber.dto.ErrorDTO;
import bd2.Muber.services.ServiceLocator;
import bd2.Muber.services.impl.DriversServiceImpl;


@ControllerAdvice
@RequestMapping("/services/conductores")
@ResponseBody
@EnableWebMvc


public class DriverRestController {
	DriversServiceImpl driverService = ServiceLocator.getInstance().getDriversService();
	
	
	/**
	 *Retorna una lista que contiene los conductores de Muber 
	 *
	 */
	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json", headers = "Accept=application/json")
	public ResponseEntity<?> getDrivers() {
		ArrayList<DriverDTO> result = driverService.getDrivers();
		if( result != null){
			return new ResponseEntity<ArrayList<DriverDTO>>(result,HttpStatus.OK );
		}
		else{
			return new ResponseEntity<ArrayList<DriverDTO>>(result,HttpStatus.NO_CONTENT);
		}

	}
	
	
	/*
	 * Retorna el detalle de del conductor solicitado con id = conductorId
	 */
	@RequestMapping(value = "/detalle", method = RequestMethod.GET, produces = "application/json", headers = "Accept=application/json")
	public ResponseEntity<?> createTrip(@RequestParam(value="conductorId", required=true) Long idDriver) {
		DriverAllDTO result = driverService.getDetails(idDriver);
		
		return new ResponseEntity<DriverAllDTO>(result, HttpStatus.OK);
				
	}

}

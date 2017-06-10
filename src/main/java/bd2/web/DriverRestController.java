package bd2.web;

import java.security.Provider.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
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

import bd2.Muber.model.Driver;
import bd2.Muber.dto.DriverDTO;
import bd2.Muber.repositories.impl.HibernateDriversRepository;
import bd2.Muber.repositories.impl.HibernatePasajerosRepository;
import bd2.Muber.services.ServiceLocator;
import bd2.Muber.services.impl.DriversServiceImpl;
import bd2.Muber.services.impl.PasajerosServiceImpl;


@ControllerAdvice
@RequestMapping("/conductores")
@ResponseBody
@EnableWebMvc


public class DriverRestController extends MuberRestController{
		
	@RequestMapping(value = "/listar", method = RequestMethod.GET, produces = "application/json", headers = "Accept=application/json")
	public ResponseEntity<ArrayList<DriverDTO>> getDrivers() {
		ArrayList<DriverDTO> result = ServiceLocator.getInstance().getDriversService().getDrivers();
		return new ResponseEntity<ArrayList<DriverDTO>>(result,HttpStatus.OK );
	}
	
	 
	@RequestMapping(value = "/top10", method = RequestMethod.GET, produces = "application/json", headers = "Accept=application/json")
	public String top10() {
		Map<String, Object> aMap = new HashMap<String, Object>();
		aMap.put("Acá debería devolver los mejores 10 conductores del sistema", "OK");
		return new Gson().toJson(aMap);
	
	}
	@RequestMapping(value = "/detalle", method = RequestMethod.GET, produces = "application/json", headers = "Accept=application/json")
	public String createTrip(@RequestParam(value="conductorId", required=true) int idDriver) {
		
		Map<String, Object> aMap = new HashMap<String, Object>();
		aMap.put("Acá se devuelve el detalle del conductor con id: ", idDriver );
		return new Gson().toJson(aMap);
	}

	

}

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
@RequestMapping("/conductores")
@ResponseBody
@EnableWebMvc


public class DriverRestController extends MuberRestController{
	
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET, produces = "application/json", headers = "Accept=application/json")
	public String driver() {
		Map<String, Object> aMap = new HashMap<String, Object>();
		
		aMap.put("Algo", "Algo");
		return new Gson().toJson(aMap);
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

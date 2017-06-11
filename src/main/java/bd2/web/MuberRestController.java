package bd2.web;

import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import com.google.gson.Gson;

@ControllerAdvice
@RequestMapping("/services")
@ResponseBody
@EnableWebMvc
public class MuberRestController {

	public MuberRestController() {
		
	}
	
	public String generateJson(Object aSerializableObject) {
		Map<String, Object> aMap = new HashMap<String, Object>();
		aMap.put("result", "OK");
		aMap.put("resultingObjects", aSerializableObject);
		return new Gson().toJson(aMap);
	}
	
/*	
	@RequestMapping(value = "/pasajeros", method = RequestMethod.GET, produces = "application/json", headers = "Accept=application/json")
	public <T> String passengers() {
		List<T>passengers = genericDAO.recovery();
		
		Map<String, Object> aMap = new HashMap<String, Object>();
		aMap.put("Resultado del test pasajeros:", "OK");
		return this.generateJson(passengers);
	}
	*/
	
}

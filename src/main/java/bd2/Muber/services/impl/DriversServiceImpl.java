package bd2.Muber.services.impl;

import java.util.ArrayList;
import java.util.Iterator;
import bd2.Muber.dto.DriverDTO;
import bd2.Muber.model.Driver;

/**
 * @author yato
 *
 */
public class DriversServiceImpl extends BaseServiceImpl{
	
	public ArrayList<DriverDTO> getDrivers(){
		ArrayList<DriverDTO> driversDTO = new ArrayList<DriverDTO>();
		Iterator<Driver> iterator = this.driversRepository.getDrivers().iterator();
		while(iterator.hasNext()){
			Driver d = (Driver) iterator.next();
			driversDTO.add(new DriverDTO(d));
		}
		return driversDTO;
	}
	
	public DriverDTO getDetails(Long idUser){
		Driver driver = this.driversRepository.getDetail(idUser);
		if(driver != null){
			return new DriverDTO(driver);
		}
		return null;
		
	}
	
}

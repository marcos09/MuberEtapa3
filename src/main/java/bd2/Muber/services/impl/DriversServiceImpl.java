package bd2.Muber.services.impl;

import java.util.ArrayList;
import java.util.Iterator;

import bd2.Muber.dto.DriverAllDTO;
import bd2.Muber.dto.DriverDTO;
import bd2.Muber.model.Driver;

/**
 * @author yato
 *
 */
public class DriversServiceImpl extends BaseServiceImpl{
	
	/**
	 * retorna una lista que contiene los conductores de Muber 
	 *
	 */
	public ArrayList<DriverDTO> getDrivers(){
		ArrayList<DriverDTO> driversDTO = new ArrayList<DriverDTO>();
		Iterator<Driver> iterator = this.driversRepository.getDrivers().iterator();
		while(iterator.hasNext()){
			Driver d = (Driver) iterator.next();
			driversDTO.add(new DriverDTO(d));
		}
		return driversDTO;
	}
	
	/**
	 * retorna los detalles del conductor 
	 *
	 */
	public DriverAllDTO getDetails(Long idUser){
		Driver driver = this.driversRepository.getDetail(idUser);
		if(driver != null){
			return new DriverAllDTO(driver);
		}
		return null;
		
	}
	
}

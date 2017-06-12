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
	 * Retorna los detalles del conductor (Nombre, fecha de licencia, viajes realizados y puntaje promedio. 
	 *
	 */
	public DriverAllDTO getDetails(Long idUser){
		Driver driver = this.driversRepository.getDetail(idUser);
		if(driver != null){
			System.out.println(driver.getScore());
			return new DriverAllDTO(driver);
		}
		return null;
		
	}
	
}

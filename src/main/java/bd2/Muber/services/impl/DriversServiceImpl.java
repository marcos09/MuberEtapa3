package bd2.Muber.services.impl;

import bd2.Muber.repositories.impl.HibernateDriversRepository;

/**
 * @author yato
 *
 */
public class DriversServiceImpl {
	
	HibernateDriversRepository driversRepository = new HibernateDriversRepository(); 
	
	public void getDriver(){
		driversRepository.getDrivers();
	}

}

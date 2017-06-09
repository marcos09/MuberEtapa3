package bd2.Muber.services.impl;

import bd2.Muber.repositories.impl.HibernateDriversRepository;

/**
 * @author yato
 *
 */
public class DriversServiceImpl extends BaseServiceImpl{
	
	public void getDrivers(){
		this.driversRepository.getDrivers();
	}
}

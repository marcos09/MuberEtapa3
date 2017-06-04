package bd2.Muber.model;

import java.util.Collection;
import java.util.HashSet;

public class Muber {

	private Long idMuber;
	private Collection<Passenger> passengers;
	private Collection<Driver> drivers;
	private Collection<Trip> trips;
	
	
	/**
	 * 
	 */
	public Muber(){
		this.setTrips(new HashSet<Trip>());
		this.setPassengers(new HashSet<Passenger>());
		this.setDrivers(new HashSet<Driver>());
	}
	
	
	/**
	 * @param muber_passengers
	 * @param muber_drivers
	 * @param muber_trips
	 */
	public Muber(Collection<Passenger> muber_passengers, Collection<Driver> muber_drivers, Collection<Trip> muber_trips) {
		super();
		this.setPassengers(muber_passengers);
		this.setDrivers(muber_drivers);
		this.setTrips(muber_trips);
	}

		
	
	
	public Collection<Passenger> getPassengers() {
		return passengers;
	}


	public void setPassengers(Collection<Passenger> passengers) {
		this.passengers = passengers;
	}


	public Collection<Driver> getDrivers() {
		return drivers;
	}


	public void setDrivers(Collection<Driver> drivers) {
		this.drivers = drivers;
	}


	public Collection<Trip> getTrips() {
		return trips;
	}


	public void setTrips(Collection<Trip> trips) {
		this.trips = trips;
	}


	/**
	 * agrega aDriver a la colección muber_drivers
	 */
	public void addDriver(Driver aDriver) {
		this.getDrivers().add(aDriver);
	}
	
	
	/**
	 * agrega aPassenger a la colección muber_passengers
	 */
	public void addPassenger(Passenger aPassenger){
		this.getPassengers().add(aPassenger);
	}
	
	
	/**
	 * agrega aDriver a un viaje
	 * agrega aTrip a la colección muber_trips
	 */
	public void addTripBy(Trip aTrip, Driver aDriver){
		aTrip.setDriver(aDriver);
		this.getTrips().add(aTrip);
	}
	
	
	/**
	 * agrega aPassenger a la colección de pasajeros del viaje
	 */
	public void addPassengerToTrip(Trip aTrip, Passenger aPassenger){
		aTrip.addPassenger(aPassenger);
	}
	
	
	/**
	 * agrega aPassenger como autor de la calificación 
	 * agrega aTrip al viaje que pertenece dicha calificación
	 * agrega aScore a la colección de calificaciones del viaje aTrip.
	 * 
	 * Tampoco tenemos definidas las reglas de negocio sobre el control
	 * de las fechas. De momento no verificamos que el pasajero que 
	 * califica haya participado del viaje. En un futuro al implementar
	 * la capa de negocio se verificarán estas cosas.
	 */
	public void qualifyTrip(Trip aTrip, Passenger aPassenger, Score aScore ){
		aScore.setAutor(aPassenger);
		aScore.setTrip(aTrip);
		aTrip.addScore(aScore);
	}


	public Long getIdMuber() {
		return idMuber;
	}


	public void setIdMuber(Long idMuber) {
		this.idMuber = idMuber;
	}
	
	
}


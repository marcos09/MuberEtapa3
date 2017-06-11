package bd2.Muber.model;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import bd2.Muber.dto.TripDTO;

/**
 * @author yato
 *
 */
public class Trip {

	private Long idTrip;
	private Float cost;
	private int numberOfpassengers;
	private Date date;
	private String fromTrip;
	private String destiny;
	private Collection<Passenger> passengers = new HashSet<Passenger>();
	private Driver driver;
	private Set<Score> scores= new HashSet<Score>();
	private String state = "enable";
	
	/**
	 * 
	 */
	public Trip(){
		this.setPassengers(new HashSet<Passenger>());
	}
	
	
	/**
	 * @param trip_cost
	 * @param trip_numberOfpassengers
	 * @param date
	 * @param trip_from
	 * @param trip_to
	 */
	public Trip(Float trip_cost, int trip_numberOfpassengers,Date date, String trip_from,
			String trip_to) {
		super();
		this.setCost(trip_cost);
		this.setDate(date);
		this.setNumberOfpassengers(trip_numberOfpassengers);
		this.setFromTrip(trip_from);
		this.setDestiny(trip_to);
	}

	public Trip(TripDTO tripDTO){
		super();
		this.setCost(tripDTO.getCost());
		this.setDate(tripDTO.getDate());
		this.setNumberOfpassengers(tripDTO.getNumberOfpassengers());
		this.setFromTrip(tripDTO.getFrom());
		this.setDestiny(tripDTO.getTo());

	}
	
	public Long getIdTrip() {
		return idTrip;
	}


	public void setIdTrip(Long idTrip) {
		this.idTrip = idTrip;
	}


	public Float getCost() {
		return cost;
	}


	public void setCost(Float cost) {
		this.cost = cost;
	}


	public int getNumberOfpassengers() {
		return numberOfpassengers;
	}


	public void setNumberOfpassengers(int numberOfpassengers) {
		this.numberOfpassengers = numberOfpassengers;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getFromTrip() {
		return fromTrip;
	}


	public void setFromTrip(String from) {
		this.fromTrip = from;
	}


	public String getDestiny() {
		return destiny;
	}


	public void setDestiny(String to) {
		this.destiny = to;
	}


	public Collection<Passenger> getPassengers() {
		return passengers;
	}


	public void setPassengers(Collection<Passenger> passengers) {
		this.passengers = passengers;
	}


	public Driver getDriver() {
		return driver;
	}


	public void setDriver(Driver driver) {
		this.driver = driver;
	}


	public Set<Score> getScores() {
		return scores;
	}


	public void setScores(Set<Score> scores) {
		this.scores = scores;
	}


	/**
	 * @param score the trip_scores to add
	 */
	public void addScore(Score score) {
		scores.add(score);
		
	}

	
	/**
	 * @param passenger agrega pasajero al viaje si hay espacio disponible
	 */
	public void addPassenger(Passenger passenger){
		if(this.getNumberOfpassengers() - this.getPassengers().size() > 0)
			this.passengers.add(passenger);
	}
	
	
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}


	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	
	public void closeTrip(){
		this.setState("disable");
	}


	/*
	 *Mensaje que sirve para descontar el crédito a los pasajeros que participaron de un viaje.
	 *
	 *No contamos con las reglas de negocio completamente definidas para la implementación del mismo. 
	 *Podría ocurrir que un pasajero quede con créditos negativos. Desconocemos como se espera que el
	 *sistema verifique esto. Asumimos que los créditos son enteros  
	 * */
	@SuppressWarnings("rawtypes")
	public void discountCredit(){
		int passengerNumber = passengers.size() + 1;
		Passenger passenger;
		Iterator iterator = passengers.iterator(); 
		while(iterator.hasNext()){
			passenger = (Passenger) iterator.next();
			passenger.setCredits(passenger.getCredits() - cost/passengerNumber);
		}
	}
	
	
}

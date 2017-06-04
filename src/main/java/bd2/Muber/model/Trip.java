package bd2.Muber.model;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author yato
 *
 */
public class Trip {

	private Long idTrip;
	private int cost;
	private int numberOfpassengers;
	private Date date;
	private String from;
	private String to;
	private Collection<Passenger> passengers = new HashSet<Passenger>();
	private Driver driver;
	private Set<Score> scores= new HashSet<Score>();
	
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
	public Trip(int trip_cost, int trip_numberOfpassengers,Date date, String trip_from,
			String trip_to) {
		super();
		this.setCost(trip_cost);
		this.setDate(date);
		this.setNumberOfpassengers(trip_numberOfpassengers);
		this.setFrom(trip_from);
		this.setTo(trip_to);
	}

	
	
	public Long getIdTrip() {
		return idTrip;
	}


	public void setIdTrip(Long idTrip) {
		this.idTrip = idTrip;
	}


	public int getCost() {
		return cost;
	}


	public void setCost(int cost) {
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


	public String getFrom() {
		return from;
	}


	public void setFrom(String from) {
		this.from = from;
	}


	public String getTo() {
		return to;
	}


	public void setTo(String to) {
		this.to = to;
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
	
	/*
	 *Mensaje que sirve para descontar el crédito a los pasajeros que participaron de un viaje.
	 *
	 *No contamos con las reglas de negocio completamente definidas para la implementación del mismo. 
	 *Podría ocurrir que un pasajero quede con créditos negativos. Desconocemos como se espera que el
	 *sistema verifique esto. Asumimos que los créditos son enteros  
	 * */
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

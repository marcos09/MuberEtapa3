/**
 * 
 */
package bd2.Muber.dto;

/**
 * @author marcos
 *
 */
public class PassengerCredits {

	private Long pasajeroId;
	private Float monto;;
	/**
	 * 
	 */
	public PassengerCredits() {
		// TODO Auto-generated constructor stub
	}
	public PassengerCredits(Long pasajeroId, Float monto) {
		super();
		this.pasajeroId = pasajeroId;
		this.monto = monto;
	}
	public Long getPasajeroId() {
		return pasajeroId;
	}
	public void setPasajeroId(Long pasajeroId) {
		this.pasajeroId = pasajeroId;
	}
	public Float getMonto() {
		return monto;
	}
	public void setMonto(Float monto) {
		this.monto = monto;
	}

	
}

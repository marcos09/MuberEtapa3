package bd2.Muber.dto;

public class TripPassenger {
	
	private Long pasajeroId;
	private Long viajeId;
	
	
	public TripPassenger(Long pasajeroId, Long viajeId) {
		super();
		this.pasajeroId = pasajeroId;
		this.viajeId = viajeId;
	}
	
	
	public Long getPasajeroId() {
		return pasajeroId;
	}
	public void setPasajeroId(Long pasajeroId) {
		this.pasajeroId = pasajeroId;
	}
	public Long getViajeId() {
		return viajeId;
	}
	public void setViajeId(Long viajeId) {
		this.viajeId = viajeId;
	}
	
	
}

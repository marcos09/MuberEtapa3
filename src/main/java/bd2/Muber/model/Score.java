package bd2.Muber.model;

/**
 * @author marcos
 *
 */
public class Score {

	
	private Long idScore;
	private String comment;
	private Integer number;
	private Passenger autor;
	private Trip trip;

	
	public Score() {
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * @param score_comment
	 * @param score_number
	 */
	public Score(String score_comment, Integer score_number) {
		super();
		this.setComment(score_comment);
		this.setNumber(score_number);
	}


	/**
	 * @return the score_id
	 */
	public Long getScore_id() {
		return idScore;
	}

	
	/**
	 * @param score_id the score_id to set
	 */
	public void setScore_id(Long score_id) {
		this.idScore = score_id;
	}


	public Long getIdScore() {
		return idScore;
	}


	public void setIdScore(Long idScore) {
		this.idScore = idScore;
	}


	public String getComment() {
		return comment;
	}


	public void setComment(String comment) {
		this.comment = comment;
	}


	public Integer getNumber() {
		return number;
	}


	public void setNumber(Integer number) {
		this.number = number;
	}


	public Passenger getAutor() {
		return autor;
	}


	public void setAutor(Passenger autor) {
		this.autor = autor;
	}


	public Trip getTrip() {
		return trip;
	}


	public void setTrip(Trip trip) {
		this.trip = trip;
	}
	
	
	
	

}

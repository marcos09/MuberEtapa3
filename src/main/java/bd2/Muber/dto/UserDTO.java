package bd2.Muber.dto;

import java.util.Date;
import bd2.Muber.model.User;

public class UserDTO {
	
	private Long idUser;
	protected String name;
	protected String password; 
	protected Date date;
	
	
	public UserDTO() {
	}
	
	public UserDTO(User anUser) {
		
	}

	
	/**
	 * @return the idUser
	 */
	public Long getIdUser() {
		return idUser;
	}

	/**
	 * @param idUser the idUser to set
	 */
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}

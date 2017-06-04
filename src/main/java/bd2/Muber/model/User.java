package bd2.Muber.model;

import java.util.Date;

/**
 * @author yato
 *
 */
public abstract class User {
	
	private Long idUser;
	private String name;
	private String password; 
	private Date date;
	
	public User() {
	}
	
	
	/**
	 * @param user_name
	 * @param user_password
	 * @param user_date
	 */
	public User (String name, String password, Date date){
		this();
		this.name = name; 
		this.password = password;
		this.date = new Date();			
	}


	public Long getIdUser() {
		return idUser;
	}


	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	
	
}

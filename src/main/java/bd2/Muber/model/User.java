package bd2.Muber.model;

import java.util.Date;

/**
 * @author yato
 *
 */
public abstract class User implements PersistentMuberObject {
	
	private Long idUser;
	private String name;
	private String password; 
	private Date fnac;
	
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
		this.fnac = new Date();			
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


	public Date getFnac() {
		return fnac;
	}


	public void setFnac(Date date) {
		this.fnac = date;
	}


	
	
}

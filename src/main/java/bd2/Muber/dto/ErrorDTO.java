package bd2.Muber.dto;

public class ErrorDTO {

	private String result = "Error";
	private String description;

	public ErrorDTO() {
		super();
	}
	
	public ErrorDTO(String desc) {
		super();
		this.setDescription(desc);
	}


	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}	
	
	
}

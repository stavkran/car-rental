package carRental.core;


public class Client {
	private String id;
	private String licenseNumber;
	private String name;
	private String surname;
	private String email;
	private String adress;
	private String telephone;
	
	
	//public Client (String name,String id,String licenseNumber,String surname,String email,String adress,String telephone) {
	public Client(String id, String licenseNumber , String name,String surname, String email,
			String adress, String telephone) {
	this.name=name;
		this.id = id;
		this.licenseNumber=licenseNumber;
		this.surname=surname;
		this.email=email;
		this.adress=adress;
		this.telephone=telephone;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLicenseNumber() {
		return licenseNumber;
	}
	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
}
	
package carRental.core;



public class Vehicle {
	private String vehregisterNumber;
	private String vehmodel;
	private String vehtype;
	private String vehcubic;
	private String vehcost;
	
	public Vehicle(String vehregisterNumber, String vehmodel, String vehtype,String vehcubic, String vehcost) {
		this.vehcost=vehcost;
		this.vehcubic=vehcubic;
		this.vehmodel=vehmodel;
		this.vehregisterNumber=vehregisterNumber;
		this.vehtype=vehtype;
	}
		
	public String getRegisterNumber() {
		return vehregisterNumber;
	}
	public void setRegisterNumber(String registerNumber) {
		this.vehregisterNumber = registerNumber;
	}
	public String getModel() {
		return vehmodel;
	}
	public void setModel(String model) {
		this.vehmodel = model;
	}
	public String getType() {
		return vehtype;
	}
	public void setType(String type) {
		this.vehtype = type;
	}
	public String getCubic() {
		return vehcubic;
	}
	public void setCubic(String cubic) {
		this.vehcubic = cubic;
	}
	public String getCost() {
		return vehcost;
	}
	public void setCost(String cost) {
		this.vehcost = cost;
	}
	
	
	
	
	
	
	
	
}

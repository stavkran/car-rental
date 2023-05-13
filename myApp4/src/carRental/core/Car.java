package carRental.core;



public class Car extends Vehicle {
	
	private String seats;
	private String doors;
	private String height;
	private String baggage;
	public Car(String registerNumber, String model, String type,String cubic, String cost,String seats,String doors,String height,String baggage) {
		super(registerNumber, model, type, cubic, cost);
		this.doors=doors;
		this.seats=seats;
		this.baggage=baggage;
		this.height=height;
	this.height=null ;
	this.baggage=null;
	
	}
	
	public String getSeats() {
		return seats;
	}
	public void setSeats(String seats) {
		this.seats = seats;
	}
	public String getDoors() {
		return doors;
	}
	public void setDoors(String doors) {
		this.doors = doors;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getBaggage() {
		return baggage;
	}

	public void setBaggage(String baggage) {
		this.baggage = baggage;
	}
	
	
}

package carRental.core;



public class twoWheeled extends Vehicle {
	private String height;
	private String baggage;
	private String seats;
	private String doors;
	public twoWheeled(String registerNumber2, String model2, String type2,String cubic2, String cost2,String seats2,String doors2,String height2,String baggage2) {
		super(registerNumber2, model2, type2, cubic2, cost2);
		this.doors=doors2;
		this.seats=seats2;
		this.baggage=baggage2;
		this.height=height2;
		this.doors=null;
		this.seats=null;
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

}

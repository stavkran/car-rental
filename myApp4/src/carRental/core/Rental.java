package carRental.core;
public class Rental {
	private int rentalPassword;
	private String rentalVehicle;
	private String rentalClientName;
	private String rentalMarket;
	private String rentalDate;
	private String rentalHour;
	private String registrationNumber;
	private String sumCost;
	public static int  MAX_CODE=0;
	public Rental (String rentalClientName, String rentalMarket, String registrationNumber,String rentalDate, String rentalHour, String sumCost,int rentalPassword,String rentalVehicle)  {
		MAX_CODE = MAX_CODE+1;
		rentalPassword=MAX_CODE;
		this.registrationNumber=registrationNumber;
		this.rentalClientName=rentalClientName;
		this.rentalDate=rentalDate;
		this.rentalHour=rentalHour;
		this.rentalMarket=rentalMarket;
		this.rentalPassword=rentalPassword;
		this.rentalVehicle=rentalVehicle;
		this.sumCost=sumCost;
		
	}
	
	
	
	
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	public int getRentalPassword() {
		return rentalPassword;
	}
	public void setRentalPassword(int rentalPassword) {
		this.rentalPassword = rentalPassword;
	}
	public String getRentalVehicle() {
		return rentalVehicle;
	}
	public void setRentVehicle(String rentalVehicle) {
		this.rentalVehicle = rentalVehicle;
	}
	public String getRentalClientName() {
		return rentalClientName;
	}
	public void setRentalClientName(String rentalClientName) {
		this.rentalClientName = rentalClientName;
	}
	public String getRentalMarket() {
		return rentalMarket;
	}
	public void setRentalMarket(String rentalMarket) {
		this.rentalMarket = rentalMarket;
	}
	public String getRentalDate() {
		return rentalDate;
	}
	public void setrDate(String rentalDate) {
		this.rentalDate = rentalDate;
	}
	public String getRentalHour() {
		return rentalHour;
	}
	public void setHour(String rentalHour) {
		this.rentalHour = rentalHour;
	}
	public String getSumCost() {
		return sumCost;
	}
	public void setSumCost(String sumCost) {
		this.sumCost = sumCost;
	}
	
	public static int MAX_CODE() {
		return MAX_CODE;
	}
	
	
	
	
	
}
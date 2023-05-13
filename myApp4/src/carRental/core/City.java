package carRental.core;



public class City {
	private int cityCode;
	private String cityName;
	public static int  MAX_CODE=0;
	public City(String cityName,int cityCode) {
		MAX_CODE = MAX_CODE+1;
		cityCode=MAX_CODE;
		this.cityName=cityName;
		this.cityCode = cityCode;
	
	}
	public int getCityCode() {
		return cityCode;
	}
	public void setCityCode(int cityCode) {
		this.cityCode = cityCode;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public static int MAX_CODE() {
		return MAX_CODE;
	}
}

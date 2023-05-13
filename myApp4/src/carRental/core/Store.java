package carRental.core;
public class Store {
	private String storeName;
	private String storeCity;
	private int storePassword;
	public static int MAX_CODE=0;
	
	public Store(String storeName, String storeCity,int storePassword) {
		MAX_CODE = MAX_CODE+1;
		storePassword=MAX_CODE;
		
		this.storePassword=storePassword;
		this.storeName=storeName;
		this.storeCity=storeCity;
		//this.storePassword=storePassword;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getStoreCity() {
		return storeCity;
	}
	public void setStoreCity(String storeCity) {
		this.storeCity = storeCity;
	}
	public int getStorePassword() {
		return storePassword;
	}
	public void setStorePassword(int storePassword) {
		this.storePassword = storePassword;
	}
	public static int MAX_CODE() {
		return MAX_CODE;
	}





}
package customer;

public class Customer {
	
	//Time when Customer arrived
	private int arrivalTime;
	
	//Time when Customer finished receiving service
	private int departureTime;
	
	//Time Left before Customer can leave
	private int serviceTime;
	
	//Time Customer waited before getting service
	private int waitingTime;

	
	public Customer(int arrival, int service){
		this.arrivalTime = arrival;
		this.serviceTime = service;
	}
	
	public void setWaitingTime(int t){
		this.waitingTime = t - this.arrivalTime;
	}
	
	public void setDepartureTime(int t){
		this.departureTime = t;
	}
	
	public void reduceService(){
		this.serviceTime --;
	}
	
	public int getServiceTime(){
		return this.serviceTime;
	}
	
	public int getArrivalTime(){
		return this.departureTime;
	}
	
	public int getWaitingTime(){
		return this.waitingTime;
	}

}

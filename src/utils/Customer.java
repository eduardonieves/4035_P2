package utils;

/**
 * Customer Class which represent an individual on line
 * @author Eduardo O. Nieves Colon
 *
 */
public class Customer {
	
	//Time when Customer arrived
	private int arrivalTime;
	
	//Time when Customer finished receiving service
	private int departureTime;
	
	//Time Left before Customer can leave
	private int serviceTime;
	
	//Time Customer waited before getting service
	private int waitingTime;
	
	//Has Customer changed to another line
	private boolean changedLine = false;

	
	public Customer(int arrival, int service){
		this.arrivalTime = arrival;
		this.serviceTime = service;
	}
	
	public void setWaitingTime(int t){
		this.waitingTime = t;
	}
	
	public void setDepartureTime(int t){
		this.departureTime = t;
	}
	
	public int getDepartureTime(){
		return this.departureTime;
	}
	
	public void toogleChangeLine(){
		this.changedLine = true;
	}
	
	public boolean isDone(int t){		
		if(t == departureTime){
			return true;
		}
		return false;
	}
	
	public int getServiceTime(){
		return this.serviceTime;
	}
	
	public int getArrivalTime(){
		return this.arrivalTime;
	}
	
	public int getWaitingTime(){
		return this.waitingTime;
	}
	
	public boolean changedLine(){
		return this.changedLine;
	}

//	@Override
//	public int compareTo(Customer cust) {
//		// TODO Auto-generated method stub
//		
//		if(this.arrivalTime < cust.arrivalTime){
//			return -1;
//		}
//		if(this.arrivalTime > cust.arrivalTime){
//			return 1;
//		}
//		return 0;
//	}

}

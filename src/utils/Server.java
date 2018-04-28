package utils;

import MainClasses.Main;
import interfaces.Policy;
import policies.SLMS;

public class Server {

	public boolean serving;
	private ServiceLine serviceLineID;
//	private boolean hasNext;
	private Customer currentCustomer;
	
	public Server(ServiceLine serviceLineID){
		this.serviceLineID = serviceLineID;
		this.serving = false;
		this.currentCustomer = null;
	}
	
	public boolean isServing() {
		return serving;
	}
	public void setServing(boolean serving) {
		this.serving = serving;
	}
	public ServiceLine getQueueID() {
		return serviceLineID;
	}
	public void setQueueID(ServiceLine queueID) {
		serviceLineID = queueID;
	}
//	public boolean HasNext() {
//		return hasNext;
//	}
	public void setCurrentCustomer(Customer customer){
		this.currentCustomer = customer;
	}
	
	public Customer getCurrentCustomer(){
		return this.currentCustomer;
	}
	
	public void serviceStart(Customer customer){
		this.currentCustomer = customer;
		serving = true;	
	}
	
	public Customer serviceEnded(){
		serving = false;
		Customer ctr = currentCustomer;
		//super.addServedCustomers(currentCustomer);
		this.currentCustomer = null;	
		return ctr;

	}
	
	
}

package utils;

import java.util.ArrayList;

import MainClasses.Main;
import interfaces.Policy;
import policies.SLMS;

public class Server {

	public boolean serving;
	private ServiceLine serviceLineID;
//	private boolean hasNext;
	private Customer currentCustomer;
	public ArrayList<Customer> servedCustomersList;
	
	public Server(ServiceLine serviceLineID, ArrayList<Customer> servedCustomersList){
		this.serviceLineID = serviceLineID;
		this.serving = false;
		this.currentCustomer = null;
		this.servedCustomersList = servedCustomersList;
	}
	
	public Server(ArrayList<Customer> servedCustomersList){
		this.serving = false;
		this.currentCustomer = null;
		this.servedCustomersList = servedCustomersList;
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
		this.serviceStart();
	}
	
	public Customer getCurrentCustomer(){
		return this.currentCustomer;
	}
	
	public void serviceStart(){
		serving = true;	
	}
	
	public void serviceEnded(){
		serving = false;
		Customer ctr = currentCustomer;
		servedCustomersList.add(ctr);
		this.currentCustomer = null;	
	}
	
	public void takeTurn(int currentTime){
		
		if(currentCustomer.reduceServiceTime(currentTime)){
			serviceEnded();
		}
		
		
		
		
	}
	
	
}

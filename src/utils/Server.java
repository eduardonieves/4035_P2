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
	public void setCurrentCustomer(Customer customer, int t){
		this.currentCustomer = customer;
		this.serviceStart(t);
	}
	
	public Customer getCurrentCustomer(){
		return this.currentCustomer;
	}
	
	public void serviceStart(int t){
		currentCustomer.setDepartureTime(t +  currentCustomer.getServiceTime());
		serving = true;
		
		currentCustomer.setWaitingTime(currentCustomer.getDepartureTime() - currentCustomer.getServiceTime() - currentCustomer.getArrivalTime());
		System.out.println("Serving Now: Arrival: "+ currentCustomer.getArrivalTime() + ", Current Time: " + t + ", Waiting Time: " + currentCustomer.getWaitingTime());
		
	}
	
	public void serviceEnded(){
		serving = false;
		Customer ctr = currentCustomer;
	//	ctr.setWaitingTime((ctr.getDepartureTime() - ctr.getServiceTime()) - ctr.getArrivalTime());
		System.out.println("Departuring Now: Arrival: "+ ctr.getArrivalTime() + " Current Time: " + ctr.getDepartureTime());
//		ctr.setWaitingTime(ctr.getDepartureTime() - ctr.getArrivalTime());
		servedCustomersList.add(ctr);
		this.currentCustomer = null;	
	}
	
	public void takeTurn(int currentTime){
		
		if(currentCustomer.isDone(currentTime)){
			serviceEnded();
		}
		
		
		
		
	}
	
	
}

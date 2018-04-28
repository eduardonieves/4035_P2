package utils;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

import MainClasses.Main;

public class ServiceLine {
	
	Queue<Customer> customerQueue;
	
	public ServiceLine(){
		this.customerQueue = new LinkedList<Customer>();
	}

	public void addCustomer(Customer c){
		customerQueue.add(c);
	}
	
	public Customer removeCustomer() throws NoSuchElementException{
		
		if(customerQueue.isEmpty())
			throw new NoSuchElementException("No Customers in queue");
		
		return customerQueue.remove();
	}
	
	public boolean sendCustomerToServer(){
		
		for(Server s: Main.serversList){
			if(!s.serving){
				s.setCurrentCustomer(customerQueue.remove());
				return true;
			}
		}
		return false;
	}
	
	
	
	
	
}

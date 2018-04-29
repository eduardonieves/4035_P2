package utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;

import interfaces.Policy;




public class ServiceLine {
	
	public Queue<Customer> customerQueue;
	public ArrayList<Server> serversList;

	
	
	public ServiceLine(){
		this.customerQueue = new LinkedList<Customer>();
	}

	public ArrayList<Server> getServersList() {
		return serversList;
	}

	public void setServersList(ArrayList<Server> serversList) {
		this.serversList = serversList;
	}

	public void addCustomer(Customer c){
		customerQueue.add(c);
	}
	
	public Customer removeCustomer() throws NoSuchElementException{
		
		if(customerQueue.isEmpty())
			throw new NoSuchElementException("No Customers in queue");
		
		return customerQueue.remove();
	}
	
	public boolean sendCustomerToServer(int t){
		
		for(Server s: serversList){
			if(!s.serving){
				s.setCurrentCustomer(customerQueue.remove(), t);
				return true;
			}
		}
		return false;
	}
	
	public Customer frontCustomer(){
		if(customerQueue.isEmpty()){
			return null;
		}else{
			return customerQueue.peek();
		}
	}
	
	public void sortQueue(){
		
		
		
		
		
	}
	
	
	
	
	
}

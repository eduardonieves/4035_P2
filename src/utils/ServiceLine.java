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

	//Used for SLMS
	public void addCustomer(Customer c){
		customerQueue.add(c);
	}
	
	//Used for other Policies
	public void addCustomer(Customer c, int t){
		if (!this.getServersList().get(0).isServing() && customerQueue.isEmpty()) 
			this.getServersList().get(0).setCurrentCustomer(c, t);
		else{
			System.out.println("In queue for "+ this.serversList.get(0).serverID);
			customerQueue.add(c);
		}
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
	
	public int totalWaitingTime(int t){
		int waitingTime = 0;
		
		//This chunk should be used for MSLMBSS, i think...
		
		if(this.serversList.get(0).isServing()){
			waitingTime = this.serversList.get(0).getCurrentCustomer().getDepartureTime() - t;
		}
		
		
		for(Customer c: customerQueue){
			
			waitingTime += c.getServiceTime();
			
		}
		
		return waitingTime;
		
	}
	
	
	
	
	
}

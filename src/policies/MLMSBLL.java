package policies;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

import utils.Customer;
import utils.Server;
import utils.ServiceLine;

public class MLMSBLL {

	public ArrayList<Customer> servedCustomers = new ArrayList<Customer>();
	public ArrayList<Server> serversList;
	public ArrayList<ServiceLine> serviceLines;
	private PriorityQueue<Customer> ArrivalsQueue;
	private int totalCustomers;
	private int t1 = 0;
	
	public MLMSBLL(int servers, PriorityQueue<Customer> customersQueue ){

		this.ArrivalsQueue = new PriorityQueue<Customer>(customersQueue);
		totalCustomers = customersQueue.size();
		serviceLines = new ArrayList<>();
		serversList = new ArrayList<>();

		for(int i = 0; i < servers;i++){
			//Create a new Server
			Server currentServer = new Server(servedCustomers);
			
			//Create a server list using only this new server
			ArrayList<Server> currentServerAsList = new ArrayList<>();
			currentServerAsList.add(currentServer);
			
			//create a new Service Line
			ServiceLine newLine = new ServiceLine();
			
			//Add the current server to the list of servers 
			serversList.add(currentServer);
			
			//add the current server as a list to the respective service line (link server with service line)
			newLine.setServersList(currentServerAsList);
			
			//Add the newLine to the service line list
			serviceLines.add(newLine);
			
			//attach queue to server
			currentServer.setQueueID(newLine);
		}
	}
	
	public void runPolicy() {
		int t = 0;
		System.out.println("Time:" + t);

		while(servedCustomers.size() != totalCustomers || this.currentlyServing()) {
			
			processTurn(t);
			t++;
			System.out.println("Time:" + t);

		}
		t1 = t;
	}
	
	public void processTurn(int t) {
		
		serviceCustomers(t);
		//makeTransfers(t);
		newServices(t);
		newArrival(t);
		
	}
	
	
	private void serviceCustomers(int t){


		//First Step: Check if a service ends
		for (ServiceLine line : serviceLines)
		{
			for(Server s: line.serversList){
				//Servers take a turn from their customers
				if(s.serving){
					s.takeTurn(t);
				}
				else {
					//Server is Available
				}
				
				//checkForTransfer();
			}
		}
	}
	
	private void newServices(int t) {
		for (ServiceLine line : serviceLines)
		{
			for(Server s: line.serversList){
				if(!s.serving){
					try {
						s.setCurrentCustomer(line.removeCustomer(), t);
					}catch(NoSuchElementException e) {
						//no more customers in line. line is empty
					}				
				}
			}
		}
	}
	
	private void checkForTransfers() {
		
	}
	
	
	private void newArrival(int t) {
		if (!ArrivalsQueue.isEmpty() && ArrivalsQueue.peek().getArrivalTime() == t)
		{
			System.out.println("Next in Line: Current Time: " + t + ", Arrival Time: "+ ArrivalsQueue.peek().getArrivalTime() + ", Service Time: "+ArrivalsQueue.peek().getServiceTime());

			//the customer arrived
			
			//check for line with minimum waiting time
			ServiceLine minLine = serviceLines.get(0);
			for(ServiceLine line : serviceLines)
			{
				if(!line.serversList.get(0).isServing()) {
					minLine = line;
					break;
				}
				if(line.customerQueue.size() < minLine.customerQueue.size()) {
					minLine = line;
				}
			}
			
			//send customer to the line with minimum waiting time
			minLine.addCustomer(ArrivalsQueue.remove(), t);
			
			
			newArrival(t);  //to check if the next customer in arrival queue arrived at the same time

		}
		
		serviceCustomers(t);
	}
	
	private boolean currentlyServing(){
		for(Server s: serversList){
			//Servers take a turn from their customers
			if(s.serving){
				return true;
			}
		}
		return false;
	}

	public String getStats() {
		float t2 = 0;
		float m = 0;

		//Calculating average waiting times
		for(int i=0; i<servedCustomers.size(); i++) {
			t2 += servedCustomers.get(i).getWaitingTime();
		}
		t2 = t2/servedCustomers.size();
		
		//Calculate Overpass
		for(int i=0; i<servedCustomers.size(); i++)
			for(int j=i+1; j<servedCustomers.size(); j++)
			{
				System.out.println("Customer "+j+": Arrival: "+servedCustomers.get(j).getArrivalTime() + ", Customer "+i+": Arrival: "+servedCustomers.get(i).getArrivalTime());
				if(servedCustomers.get(j).getArrivalTime() < servedCustomers.get(i).getArrivalTime()) {
					m++;
				}
			}
		m = m/(servedCustomers.size());
		
		return "MLMSBLL " + serversList.size() + ":     " + t1 +  "     " + t2 + "     " + m;
	}
}

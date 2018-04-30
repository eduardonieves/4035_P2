package policies;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

import interfaces.Policy;
import utils.Customer;
import utils.Server;
import utils.ServiceLine;

public class SLMS implements Policy {

	public ArrayList<Customer> servedCustomers = new ArrayList<Customer>();
	public ArrayList<Server> serversList;
	ServiceLine serviceLine;
	private PriorityQueue<Customer> ArrivalsQueue;


	int t1;

	public SLMS(int servers, PriorityQueue<Customer> customersQueue ){

		this.ArrivalsQueue = new PriorityQueue<Customer>(customersQueue);

		serviceLine = new ServiceLine();

		serversList = new ArrayList<>();

		for(int i = 0; i < servers;i++){
			serversList.add(new Server(serviceLine, servedCustomers));
		}

		serviceLine.setServersList(serversList);

		while(!ArrivalsQueue.isEmpty()){
			serviceLine.addCustomer(ArrivalsQueue.remove());
		}

		//	servedCustomers.add(serversList[0].serviceEnded());
	}

	public void addServedCustomer(Customer customer){



	}

	public void runSLMS(){

		//while or for loop
		//		proccessTurn();

		int t = 0;

		while(!serviceLine.customerQueue.isEmpty() || this.currentlyServing()){ 

			
			System.out.println("Time:" + t);
			serviceCustomers(t);

			//Checks all customers in line to see if is their turn
			while(!serviceLine.customerQueue.isEmpty()){
				
				System.out.println("Next in Line: Current Time: " + t + ", Arrival Time: "+ serviceLine.frontCustomer().getArrivalTime() + ", Service Time: "+serviceLine.frontCustomer().getServiceTime());

				if(serviceLine.frontCustomer().getArrivalTime() <= t ){


					if (!serviceLine.sendCustomerToServer(t)){
						//All servers are occupied no need to check for other Customers
						break;

					}


				}else{
					//Customers haven't arrived yet
					break;
				}
			}

			t++;
		}
		
		t1 = t;
	}

	private boolean currentlyServing(){
		
		for(Server s: serviceLine.serversList){
			//Servers take a turn from their customers
			if(s.serving){
				return true;
			}

		}
		return false;
		
	}
	
	
	private void serviceCustomers(int t){


		//First Step: Check if a service ends
		for(Server s: serviceLine.serversList){
			//Servers take a turn from their customers
			if(s.serving){
				s.takeTurn(t);
			}

		}

	}

	public ArrayList<Customer> getServedCustomers() {
		return servedCustomers;
	}

	public void addServedCustomers(Customer servedCustomer) {
		this.servedCustomers.add(servedCustomer);
	}

	public String getStats() {
		float t2 = 0;
		float m = 0;
		
		//Calculating average waiting times
		for(int i=0; i<servedCustomers.size(); i++) {
			t2 += servedCustomers.get(i).getWaitingTime();
		}
		t2 = t2/servedCustomers.size();
		
		return "SLMS " + serversList.size() + ":     " + t1 +  "     " + t2 + "     " + m;
	}



}

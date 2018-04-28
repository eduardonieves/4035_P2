package policies;

import java.util.ArrayList;
import java.util.Queue;

import interfaces.Policy;
import utils.Customer;
import utils.Server;
import utils.ServiceLine;

public class SLMS implements Policy {

	public ArrayList<Customer> servedCustomers = new ArrayList<Customer>();
	public ArrayList<Server> serversList;

	
	public SLMS(int servers, Queue<Customer> customersQueue ){
		
		ServiceLine serviceLine = new ServiceLine();
		
		serversList = new ArrayList<>();
		
		for(int i = 0; i < servers;i++){
			serversList.add(new Server(serviceLine, servedCustomers));
		}
		
		serviceLine.setServersList(serversList);
		
		while(!customersQueue.isEmpty()){
			serviceLine.addCustomer(customersQueue.remove());
		}
				
	//	servedCustomers.add(serversList[0].serviceEnded());
	}
	
	public void addServedCustomer(Customer customer){
		
		
		
	}
	
	public void runSLMS(){
		
		//while or for loop
		proccessTurn();
		
	}
	
	private void proccessTurn(){
		
		
		
		
		
	}

	public ArrayList<Customer> getServedCustomers() {
		return servedCustomers;
	}

	public void addServedCustomers(Customer servedCustomer) {
		this.servedCustomers.add(servedCustomer);
	}
	

	
	
	
}

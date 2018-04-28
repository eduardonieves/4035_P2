package policies;

import java.util.ArrayList;

import interfaces.Policy;
import utils.Customer;
import utils.Server;
import utils.ServiceLine;

public class SLMS implements Policy {

	public static ArrayList<Customer> servedCustomers = new ArrayList<Customer>();
	public static Server[] serversList;

	
	public SLMS(int servers){
		
		ServiceLine serviceLine = new ServiceLine();
		
		serversList = new Server[servers];
		
		for(int i = 0; i < servers;i++){
			serversList[i] = new Server(serviceLine);
		}
		
		
		//serversList = (Server[]) new Object[servers];
		
		
		
	//	servedCustomers.add(serversList[0].serviceEnded());
	}
	
	public void addServedCustomer(Customer customer){
		
		
		
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

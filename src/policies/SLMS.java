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


	public SLMS(int servers, PriorityQueue<Customer> customersQueue ){

		serviceLine = new ServiceLine();

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
		//		proccessTurn();

		int t = 0;

		while(!serviceLine.customerQueue.isEmpty()){


			//First Step: Check if a service ends
			for(Server s: serviceLine.serversList){
				//Servers take a turn from their customers
				if(s.serving){
					s.takeTurn(t);
				}

			}

			//Checks all customers in line to see if is their turn
			while(!serviceLine.customerQueue.isEmpty()){
				System.out.println("Arrival Time: "+ serviceLine.frontCustomer().getArrivalTime() + ", Service Time: "+serviceLine.frontCustomer().getServiceTime());

				if(serviceLine.frontCustomer().getArrivalTime() <= t ){


					if (!serviceLine.sendCustomerToServer()){
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

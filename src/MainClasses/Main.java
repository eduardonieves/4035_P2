package MainClasses;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Queue;

import dataReader.DataReader;
import policies.SLMS;
import utils.Customer;
import utils.Server;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			dataReader.DataReader reader = new dataReader.DataReader();
			
			ArrayList<Queue<Customer>> arrivalList =  reader.customerArrivalList;
			
			for(Queue<Customer> queue: arrivalList){
				SLMS slms1 = new SLMS(1, queue);
				slms1.runSLMS();
				SLMS slms3 = new SLMS(3,queue);
				SLMS slms5 = new SLMS(5,queue);
			}
			
			
			
			
//			for (int i=0; i<reader.ArrivalQueue.size();i++) {
//				System.out.print(reader.ArrivalQueue.poll());
//			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	

	


}

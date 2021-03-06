package MainClasses;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

import dataReader.DataReader;
import policies.MLMS;
import policies.MLMSBLL;
import policies.MLMSBWT;
import policies.SLMS;
import utils.Customer;
import utils.Server;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			dataReader.DataReader reader = new dataReader.DataReader();
			
			ArrayList<PriorityQueue<Customer>> arrivalList =  reader.customerArrivalList;
			
			for(PriorityQueue<Customer> queue: arrivalList){
				
				//For Debugging purpose
//				while(!queue.isEmpty()){
//					System.out.println(queue.remove().getArrivalTime());
//				}
				
				//SLMS
				SLMS slms1 = new SLMS(1, queue);
				slms1.runSLMS();
				reader.writeToFile(reader.outputFileList.get(arrivalList.indexOf(queue)),slms1.getStats(), true);
				SLMS slms3 = new SLMS(3,queue);
				slms3.runSLMS();
				reader.writeToFile(reader.outputFileList.get(arrivalList.indexOf(queue)),slms3.getStats(), true);
				SLMS slms5 = new SLMS(5,queue);
				slms5.runSLMS();
				reader.writeToFile(reader.outputFileList.get(arrivalList.indexOf(queue)),slms5.getStats(), true);

				//MLMS

				MLMS mlms1 = new MLMS(1, queue);
				mlms1.runPolicy();
				reader.writeToFile(reader.outputFileList.get(arrivalList.indexOf(queue)),mlms1.getStats(), true);
				MLMS mlms3 = new MLMS(3, queue);
				mlms3.runPolicy();
				reader.writeToFile(reader.outputFileList.get(arrivalList.indexOf(queue)),mlms3.getStats(), true);
				MLMS mlms5 = new MLMS(5, queue);
				mlms5.runPolicy();
				reader.writeToFile(reader.outputFileList.get(arrivalList.indexOf(queue)),mlms5.getStats(), true);

				//MLMSBBL
				MLMSBLL mlmsbll1 = new MLMSBLL(1, queue);
				mlmsbll1.runPolicy();
				reader.writeToFile(reader.outputFileList.get(arrivalList.indexOf(queue)),mlmsbll1.getStats(), true);
				MLMSBLL mlmsbll3 = new MLMSBLL(3, queue);
				mlmsbll3.runPolicy();
				reader.writeToFile(reader.outputFileList.get(arrivalList.indexOf(queue)),mlmsbll3.getStats(), true);
				MLMSBLL mlmsbll5 = new MLMSBLL(5, queue);
				mlmsbll5.runPolicy();
				reader.writeToFile(reader.outputFileList.get(arrivalList.indexOf(queue)),mlmsbll5.getStats(), true);
				

				

				//MLMSBWT
				MLMSBWT mlmsbwt1 = new MLMSBWT(1, queue);
				mlmsbwt1.runPolicy();
				reader.writeToFile(reader.outputFileList.get(arrivalList.indexOf(queue)),mlmsbwt1.getStats(), true);
				MLMSBWT mlmsbwt3 = new MLMSBWT(3, queue);
				mlmsbwt3.runPolicy();
				reader.writeToFile(reader.outputFileList.get(arrivalList.indexOf(queue)),mlmsbwt3.getStats(), true);
				MLMSBWT mlmsbwt5 = new MLMSBWT(5, queue);
				mlmsbwt5.runPolicy();
				reader.writeToFile(reader.outputFileList.get(arrivalList.indexOf(queue)),mlmsbwt5.getStats(), true);
				
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

package MainClasses;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import dataReader.DataReader;
import utils.Customer;
import utils.Server;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			dataReader.DataReader reader = new dataReader.DataReader();
			for (int i=0; i<reader.ArrivalQueue.size();i++) {
				System.out.print(reader.ArrivalQueue.poll());
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	


}

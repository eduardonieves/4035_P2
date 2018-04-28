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
			System.out.print(reader.fileList.toString());
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	


}

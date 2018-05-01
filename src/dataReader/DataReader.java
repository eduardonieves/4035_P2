package dataReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.regex.PatternSyntaxException;

import policies.SLMS;
import utils.Customer;
import utils.CustomerComparator;


public class DataReader {

	private String fileName;
	public ArrayList<String> fileList = new ArrayList<>();
	private Integer[][] dataSet; 
	private String parentDirectory; 
	private static BufferedReader reader = null;
	private static File fout = null;
	static FileOutputStream fos = null;
	private static BufferedWriter bw = null;
	private String line = "";
	public ArrayList<PriorityQueue<Customer>> customerArrivalList = new ArrayList<>();
	public ArrayList<Customer> unsortedCustomerList = new ArrayList<>();
	public ArrayList<String> outputFileList = new ArrayList<>();
	

	public DataReader() throws FileNotFoundException {
			//if running on Terminal	
			//fileName = "dataFiles.txt";

			//if running on Eclipse and files are inside src folder
			fileName = "inputFiles/dataFiles.txt";

			File file = new File(fileName);

			if(file.exists()){

				try {
					if(file.getName().endsWith(".txt")){
						try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
							String line;
							while ((line = br.readLine()) != null) {

								if(!line.equals("")){
									fileList.add(line);
								}
							}

							//TestScenarios.loadInputFile(fileList);
							for(int i = 0; i< fileList.size(); i++){
								
								
								String fileName ="inputFiles/" +  fileList.get(i);
								//String[] fileNameSplit = fileName.split(" ");
								//fileName = fileNameSplit[1];
												
								File inputFile = new File(fileName);
						
								if(inputFile.exists()){
						
									//if running on Terminal		
									//reader = new BufferedReader(new FileReader(fileName));
									//fout = new File("output"+(i+1)+".out");
						
									//if running on Eclipse and files are inside src folder
									reader = new BufferedReader(new FileReader(fileName));
									
									PriorityQueue<Customer> ArrivalQueue = new PriorityQueue<Customer>();
												
									
									
									while ((line = reader.readLine()) != null) {
										
										try{
										String[] inputs = line.split(" ");
										
										if(inputs.length != 2){
											//Invalid File
										}
										
										unsortedCustomerList.add(new Customer(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1])));
										
										
										}catch(PatternSyntaxException e){
											// Invalid File
										}
					
									
										//ArrivalQueue.add(new Customer(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1])));
									
										
									}	
									
									Comparator<Customer> comparator = new CustomerComparator();
									ArrivalQueue = new PriorityQueue<Customer>(unsortedCustomerList.size(), comparator);
									
									
									while(!unsortedCustomerList.isEmpty()){
										ArrivalQueue.add(unsortedCustomerList.remove(0));
									}
									
									customerArrivalList.add(ArrivalQueue);
									outputFileList.add(fileName);
									
									String[] fileNameSplit = fileName.split("/");
									fileName = fileNameSplit[1];
									String[] fileNameSplit2 = fileName.split("\\.");
									fileName = fileNameSplit2[0];
									writeToFile(fileName,"Number of Customers: " + ArrivalQueue.size(), false);
								}
								else
								{
									String[] fileNameSplit = fileName.split("/");
									fileName = fileNameSplit[1];
									String[] fileNameSplit2 = fileName.split("\\.");
									fileName = fileNameSplit2[0];
									
									writeToFile(fileName, "Input file not found", false);
								}
									
							}
						}
					}

				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException err) {
					err.printStackTrace();
				} finally {
					if (reader != null) {
						try {
							reader.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}	
			}
	
	}
	
	public void writeToFile(String file, String text, boolean append) {
		
		
		try {
			
			String[] fileNameSplit = file.split("/");
			file = fileNameSplit[1];
			String[] fileNameSplit2 = file.split("\\.");
			file = fileNameSplit2[0];
			
			fout = new File(file+"_OUT.txt"); 
			FileWriter fw = new FileWriter(fout, append);
			//fos = new FileOutputStream(fout);
			bw = new BufferedWriter(fw);
			PrintWriter out = new PrintWriter(bw);
			out.println(text);
			out.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			try {
				
				fout = new File(file+"_OUT.txt"); 
				FileWriter fw = new FileWriter(fout, append);
				//fos = new FileOutputStream(fout);
				bw = new BufferedWriter(fw);
				PrintWriter out = new PrintWriter(bw);
				out.println(text);
				out.close();

			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		}
	}
	
	
	/*
	public Object[][] readDataFiles() throws FileNotFoundException {
		dataSet = new Integer[i][];

			for (int j=0; j<i; j++) {
				
				String fileName = "data_" + i + ".txt"; 
				Scanner inputFile = new Scanner(new File(parentDirectory, fileName)); 
				ArrayList<Integer> fileContent = new ArrayList<>(); 
				while (inputFile.hasNext())
					fileContent.add(inputFile.nextInt());
				inputFile.close();
				dataSet[i] = (Integer[]) fileContent.toArray(new Integer[0]);  
			}	
		return dataSet; 
	}

	
	public void printSets() { 
		System.out.println("datasets are: " ); 
			for (int j=0; j<i; j++) { 
				System.out.print("Set["+i+"] = "); 
				printArray((Integer[]) dataSet[i]); 
			}
	}
	
	private void printArray(Integer[] numbers) {
		for (int i=0; i<numbers.length; i++) 
			System.out.print(numbers[i] + "  "); 
		System.out.println(); 
	}
	*/

}

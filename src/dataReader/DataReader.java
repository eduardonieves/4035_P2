package dataReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import utils.Customer;


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
	public Queue<Customer> ArrivalQueue = new LinkedList<Customer>();
	

	public DataReader() throws FileNotFoundException {
			//if running on Terminal	
			//fileName = "dataFiles.txt";

			//if running on Eclipse and files are inside src folder
			fileName = "inputFiles/dataFiles.txt";

			File file = new File(fileName);

			if(file.exists()){

				try {
					fout = new File(fileName+".out");
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
									
									
									//Initialize Policies
									/*
									SLMS = new SLMS(1);
									SLMS = new SLMS(3);
									SLMS = new SLMS(5);
									MLMS = new MLMS(1);
									MLMS = new MLMS(3);
									MLMS = new MLMS(5);
									MLMSBLL = new MLMSBLL(1);
									MLMSBLL = new MLMSBLL(3);
									MLMSBLL = new MLMSBLL(5);
									MLMSBWT = new MLMSBWT(1);
									MLMSBWT = new MLMSBWT(3);
									MLMSBWT = new MLMSBWT(5);
									*/

									
									String[] fileNameSplit = fileName.split("/");
									fileName = fileNameSplit[1];
									String[] fileNameSplit2 = fileName.split("\\.");
									fileName = fileNameSplit2[0];
									
									fout = new File(fileName+"_OUT.txt");
						
									fos = new FileOutputStream(fout);
									bw = new BufferedWriter(new OutputStreamWriter(fos));
													
						
									while ((line = reader.readLine()) != null) {
										String[] inputs = line.split(" ");
										ArrivalQueue.add(new Customer(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1])));
									}					
								}
								else
								{
									String[] fileNameSplit = fileName.split("/");
									fileName = fileNameSplit[1];
									String[] fileNameSplit2 = fileName.split("\\.");
									fileName = fileNameSplit2[0];
									
									fout = new File(fileName+"_OUT.txt");
									
									fos = new FileOutputStream(fout);
									bw = new BufferedWriter(new OutputStreamWriter(fos));
									bw.write("Input file not found.");
									bw.close();
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
	/**
	 * 
	 * @return
	 * @throws FileNotFoundException 
	 */

	
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

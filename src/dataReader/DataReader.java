package dataReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class DataReader {

	private int i;
	private Integer[][] dataSet; 
	private String parentDirectory; 
	

	public DataReader() throws FileNotFoundException {
		parentDirectory = "inputFiles"; 
		Scanner dataFiles = new Scanner(new File(parentDirectory, "dataFiles.txt")); 
		// the values of n and m shall be read from file: "inputFiles/parameters.txt". 
		this.i = dataFiles.nextInt(); 
		dataFiles.close();
	}
	
	public int geti() {
		return i;
	}
	
	/**
	 * 
	 * @return
	 * @throws FileNotFoundException 
	 */
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


}

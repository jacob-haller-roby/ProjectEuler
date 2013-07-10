package problemPackage0;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem8 {
	
	public static void main(String[] args) throws FileNotFoundException{
		
		long start = System.nanoTime();
		System.out.println("The Answer is: " + standard());
		long mid = System.nanoTime();
		System.out.println("The Answer is: " + delimited());
		long end = System.nanoTime();
		
		System.out.println("Standard Time: " + (mid - start));
		System.out.println("Delimit  Time: " + (end - mid));
		
	}
	
	private static int standard() throws FileNotFoundException {
		
		Scanner fileIn = new Scanner(new File("SourceFiles/problem8Source"));
		fileIn.useDelimiter("0");
		int currentMax = 0;
		
		while(fileIn.hasNext()){
			String testString = fileIn.next();
			if(testString.length() < 5){
				continue;
			}
			
			int testProduct = 1;
			for(int x = 0; x < 5; x++){
				testProduct *= Character.getNumericValue(testString.charAt(x));
			}
			
			if(testProduct > currentMax){
				currentMax = testProduct;
			}
			
			for(int x = 5; x < testString.length(); x++){
				testProduct *= Character.getNumericValue(testString.charAt(x))/Character.getNumericValue(testString.charAt(x - 5));
				if(testProduct > currentMax){
					currentMax = testProduct;
				}
			}
		}
		
		fileIn.close();
		return currentMax;
	}
	
	private static int delimited() throws FileNotFoundException{
		Scanner fileIn = new Scanner(new File("SourceFiles/problem8Source"));
		String delimiterString = "0";
		int maxDelimiter = 0;
		fileIn.useDelimiter(delimiterString);
		int currentMax = 0;
		
		while(fileIn.hasNext()){
			String testString = fileIn.next();
			if(testString.length() < 5){
				continue;
			}
			
			int testProduct = 1;
			
			for(int x = 0; x < 5; x++){
				testProduct *= Character.getNumericValue(testString.charAt(x));
			}
			
			if(testProduct > currentMax){
				currentMax = testProduct;
			}
			
			for(int x = 5; x < testString.length(); x++){
				testProduct *= Character.getNumericValue(testString.charAt(x))/Character.getNumericValue(testString.charAt(x - 5));
				if(testProduct > currentMax){
					currentMax = testProduct;
				}
			}
			
			int delimiter = currentMax/(9*9*9*9);
			for(int x = maxDelimiter + 1; x <= delimiter; x++){
				delimiterString += "|" + x;
			}
			
			if(delimiter > maxDelimiter){
				maxDelimiter = delimiter;
				fileIn.useDelimiter(delimiterString);
			}
		}
		
		fileIn.close();
		return currentMax;
	}

}

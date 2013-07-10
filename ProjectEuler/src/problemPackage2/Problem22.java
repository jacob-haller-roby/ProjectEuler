package problemPackage2;

import helpers.AlphabetHelper;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem22 {

	public static void main(String[] args) throws FileNotFoundException{
		System.out.println("The Answer is: " + sumOfNameValues());
	}
	
	private static int nameValues(String name){
		int value = 0;
		for(char ch : name.toCharArray()){
			value += Character.getNumericValue(ch) - 9;
		}
		return value;
	}
	
	private static int sumOfNameValues() throws FileNotFoundException {
		Scanner fileIn = new Scanner(new File("SourceFiles/problem22Source"));
		fileIn.useDelimiter("\",\"|\"");
		
		List<String> namesList = new ArrayList<String>();
		while(fileIn.hasNext()){
			String nextName = fileIn.next();
			int index = 0;
			while(index < namesList.size() && AlphabetHelper.alphabeticalTest(namesList.get(index), nextName)){
				index++;
			}
			namesList.add(index, nextName);
		}
		fileIn.close();
		
		int total = 0;
		int rank = 1;
		for(String name : namesList){
			total += rank * nameValues(name);
			rank++;
		}
		
		
		return total;
	}
	
	
}

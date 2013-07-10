package problemPackage1;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

public class Problem13 {
	
	public static void main(String[] args) throws FileNotFoundException{
		long start = System.nanoTime();
		System.out.println("The Answer is: " + findSum());
		long mid = System.nanoTime();
		System.out.println("The Answer is: " + usingSubString());
		long end = System.nanoTime();
		System.out.println("BigInt time: " + (mid - start));
		System.out.println("SubStr time: " + (end - mid));
	}

	private static String findSum() throws FileNotFoundException{
		
		Scanner fileIn = new Scanner(new File("SourceFiles/problem13Source"));
		BigInteger sum = new BigInteger("0");
		while(fileIn.hasNext()){
			sum = sum.add(new BigInteger(fileIn.nextLine()));
		}
		fileIn.close();
		String totalSumString = sum.toString();
		return totalSumString.substring(0, 10);
	}
	
	private static String usingSubString() throws FileNotFoundException{
		
		Scanner fileIn = new Scanner(new File("SourceFiles/problem13Source"));
		long sum = 0;
		while(fileIn.hasNext()){
			String nextLine = fileIn.nextLine();
			nextLine = nextLine.substring(0, 11);
			sum += Long.parseLong(nextLine);
		}
		fileIn.close();
		String result = Long.toString(sum);
		return result.substring(0, 10);
	}
}

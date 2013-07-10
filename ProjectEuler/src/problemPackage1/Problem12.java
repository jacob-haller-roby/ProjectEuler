package problemPackage1;

import helpers.PrimeUtils;

import java.util.ArrayList;
import java.util.List;

public class Problem12 {
	
	private static PrimeUtils primeUtils;
	
	public static void main(String[] args){
		primeUtils = new PrimeUtils();
		System.out.println("The Answer is: " + findTriangleNumber());
	}
	
	private static long findTriangleNumber(){
		long answer = 0;
		for(int number = 6, power = 3; answer == 0; power++, number += power){
			answer = triangleNumbers(number);
		}
		
		return answer;
	}
	
	private static long triangleNumbers(int number){
		List<Integer> primeFactors = primeUtils.createListOfPrimeFactors(number);
		List<Long> factorCounter = new ArrayList<Long>();
		
		long lastFactor = 0;
		for(long primeFactor : primeFactors){
			if(lastFactor == primeFactor){
				factorCounter.set(factorCounter.size() - 1, factorCounter.get(factorCounter.size() - 1) + 1);
			} else {
				factorCounter.add((long) 2);
				lastFactor = primeFactor;
			}
		}
		
		if(totalFactors(factorCounter) > 500) {
			return number;
		}
		
		return 0;
	}
	
	private static long totalFactors(List<Long> factorCount){
		long factors = 1;
		for(long count : factorCount){
			factors *= count;
		}
		return factors;
	}

}

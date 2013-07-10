package problemPackage2;

import java.util.List;

import helpers.PrimeUtils;

public class Problem21 {
	
	private static PrimeUtils primeUtils;
	
	public static void main(String[] args){
		primeUtils = new PrimeUtils();
		long start = System.nanoTime();
		System.out.println("The Answer is: " + amicablePairsSumUnder(60000));
		long mid = System.nanoTime();
		System.out.println("The Answer is: " + bruteForce(60000));
		long end = System.nanoTime();
		System.out.println("Algorithm Time: " + (mid - start));
		System.out.println("BruteForc Time: " + (end - mid));
	}
	
	private static int bruteForce(int upperLimit){
		int[] amicableMate = new int[upperLimit + 1];
		int sum = 0;
		for(int x = 1; x < upperLimit; x++){
			amicableMate[x] = bruteSumOfDivisors(x);
			if (amicableMate[x] < x && x == amicableMate[amicableMate[x]]){
				sum+= x;
				sum += amicableMate[x];
			}
		}
		return sum;
	}
	
	private static int bruteSumOfDivisors(int input){
		int sum = 1;
		for(int x = 2; x*x < input; x++){
			if(input%x == 0){
				sum += x;
				sum += input/x;
			}
		}
		return sum;
	}
	
	private static int amicablePairsSumUnder(int upperLimit){
		
		int[] amicableMate = new int[upperLimit + 1];
		int sum = 0;
		for(int x = 1; x < upperLimit; x++){
			amicableMate[x] = sumOfDivisors(x);
			if(amicableMate[x] < x && x == amicableMate[amicableMate[x]]){
				sum += x;
				sum += amicableMate[x];
			}
		}
		return sum;
	}
	
	private static int sumOfDivisors(int number){
		List<Integer> primeFactors = primeUtils.createListOfPrimeFactors(number);
		
		int index = 0;
		int total = 1;
		while(index < primeFactors.size()){
			int currentPrime = primeFactors.get(index);
			int primeSum = 1;
			while(index < primeFactors.size() && currentPrime == primeFactors.get(index)){
				index++;
				primeSum = primeSum * currentPrime + 1;
			}
			total *= primeSum;
		}
		total -= number;
		return total;
	}

}

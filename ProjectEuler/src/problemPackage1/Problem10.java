package problemPackage1;

import helpers.PrimeUtils;

public class Problem10 {

	public static void main(String[] args){
		System.out.println("The Answer is: " + sumOfPrimesBelow(2000000));
	}
	
	private static long sumOfPrimesBelow(int upperLimits){
		PrimeUtils primeUtils = new PrimeUtils();
		primeUtils.extendListToUpperBound(upperLimits);
		
		long sum = 0;
		for(int prime : primeUtils.getPrimes()){
			sum += prime;
		}
		sum -= primeUtils.getPrimes().get(primeUtils.getPrimes().size() - 1);
		return sum;
	}
}

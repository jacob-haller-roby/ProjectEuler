package problemPackage4;

import helpers.PrimeUtils;

public class Problem41 {

	private static PrimeUtils primeUtils;
	
	public static void main(String[] args){
		
		primeUtils = new PrimeUtils();
		long start = System.nanoTime();
		System.out.println("The Answer is: " + pandigitalPrime());
		long end = System.nanoTime();
		System.out.println("nanoseconds: " + (end - start));
	}
	
	private static int pandigitalPrime(){
		
		primeUtils.extendListToUpperBound(987654321);
		for(int index = primeUtils.getPrimes().size() - 1; index > 0; index--){
			if(isPandigital(primeUtils.getPrimes().get(index))){
				return primeUtils.getPrimes().get(index);
			}
		}
		return 0;
		
	}
	
	private static boolean isPandigital(int input){
		
		boolean[] digits = new boolean[10];
		digits[0] = true;
		
		while(input > 0){
			int digit = input %10;
			if(digits[digit]){
				return false;
			}
			digits[digit] = true;
			input /= 10;
		}
		
		for(int index = 1; index < 10; index++){
			
			if(digits[index] && !digits[index-1]){
				return false;
			}
			
		}
		return true;
		
	}
}

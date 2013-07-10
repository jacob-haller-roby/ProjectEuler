package problemPackage3;

import helpers.PrimeUtils;

public class Problem37 {

	public static PrimeUtils primeUtils;
	
	public static void main(String[] args){
		primeUtils = new PrimeUtils();
		System.out.println("The Answer is: " + truncPrimes());
	}
	
	private static int truncPrimes(){
		
		int sum = 0;
		for(int primeIndex = 4, truncCount = 0; truncCount < 11; primeIndex++){
			primeUtils.extendListToPrimeCount(primeIndex +1);
			
			if(truncLeft(primeUtils.getPrimes().get(primeIndex)) && truncRight(primeUtils.getPrimes().get(primeIndex))){
				truncCount++;
				sum += primeUtils.getPrimes().get(primeIndex);
				System.out.println(primeUtils.getPrimes().get(primeIndex));
			}
			
		}
		return sum;
		
	}
	
	private static boolean truncLeft(int input){
		input /= 10;
		while(input > 0){
			
			if(!primeUtils.getPrimes().contains(input)){
				return false;
			}
			input /= 10;
		}
		return true;
	}
	
	private static boolean truncRight(int input){
		
		int digits = Integer.toString(input).length();
		int divisor = 1;
		for(int digitCount = 1; digitCount <digits; digitCount++){
			divisor *= 10;
		}
		
		input %= divisor;
		divisor /= 10;
		
		while(input > 0){
			
			if(!primeUtils.getPrimes().contains(input)){
				return false;
			}
			input %= divisor;
			divisor /= 10;
		}
		return true;
	}
}

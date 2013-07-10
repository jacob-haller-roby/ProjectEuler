package problemPackage0;

import helpers.PrimeUtils;

public class Problem7 {

	public static void main(String[] args){
		
		PrimeUtils primeUtils = new PrimeUtils();
		primeUtils.extendListToPrimeCount(10001);
		System.out.println("The Answer is: " + primeUtils.getPrimes().get(10000));
	}
}

package problemPackage2;

import helpers.PrimeUtils;

public class Problem27 {

	private static PrimeUtils primeUtils;
	
	public static void main(String[] args){
		System.out.println("The Answer is: " + findPrimeFormula());
	}
	
	private static int findPrimeFormula(){
		
		primeUtils = new PrimeUtils();
		primeUtils.extendListToUpperBound(79*79 + 79*1000 + 1000); //Highest potential prime, assuming
		//the equation n^2 - 79*n +1601 is more efficient than anything possible using b < 1000
		
		int maxCount = 0;
		int answer = 0;
		for(int b = 0; b < 1000; b++){
			for(int a = -40 - (b/40); a < 1000; a++){
				int primeCount = primeEquationCounter(a, b);
				if(primeCount > maxCount){
					maxCount = primeCount;
					answer = a*b;
				}
			}
		}
		return answer;
		
	}
	
	private static int primeEquationCounter(int a, int b){
		
		int n = 0;
		while(primeUtils.getPrimeMap().containsKey(n*(n+a) + b)){
			n++;
		}
		return n;
	}
}

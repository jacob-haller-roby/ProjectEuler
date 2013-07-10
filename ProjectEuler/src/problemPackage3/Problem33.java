package problemPackage3;

import java.util.List;
import helpers.PrimeUtils;

public class Problem33 {
	
	public static void main(String[] args){
		
		System.out.println("The Answer is: " + digitFractionCanceling());
	}

	private static int digitFractionCanceling(){
		
		int totalD = 1;
		int totalN = 1;
		
		for(int numerator = 12; numerator <100; numerator++){
			
			if(numerator%10 <= numerator/10){
				continue;
			}
			
			
			for(int denominator = (numerator%10)*10 +1; denominator< (numerator%10 + 1)*10; denominator++){
				double fraction = (double)numerator/(double)denominator;
				double simplified = (double)(numerator/10)/(double)(denominator%10);
				if(fraction == simplified){
					totalD *= denominator;
					totalN *= numerator;
					System.out.println(numerator + "/" + denominator + ", " +fraction +":" +simplified);
				}
			}
			
				
		}
		
		PrimeUtils primeUtils = new PrimeUtils();
		List<Integer> numeratorFactorList = primeUtils.createListOfPrimeFactors(totalN);
		List<Integer> denominatorFactorList = primeUtils.createListOfPrimeFactors(totalD);
		
		System.out.println(totalD);
		System.out.println(denominatorFactorList);
		System.out.println(numeratorFactorList);
		for(int factor :denominatorFactorList){
			if(numeratorFactorList.contains(factor)){
				numeratorFactorList.remove(numeratorFactorList.indexOf(factor));
				totalD /= factor;
			}
		}
		
		
		return totalD;
	}
	
	
}

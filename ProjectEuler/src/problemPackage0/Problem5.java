package problemPackage0;

import java.util.ArrayList;
import java.util.List;

import helpers.NumberSetHelper;
import helpers.PrimeUtils;

public class Problem5 {

	public static void main(String[] args){
		
		
		
		System.out.println("The Answer is: " + problem5());
	}
	
	private static int problem5(){
		
		
		PrimeUtils primeUtils = new PrimeUtils();
		List<Integer> primeFactors = new ArrayList<Integer>();
		
		for(int x = 2; x < 21; x++){
			primeFactors = NumberSetHelper.mergeListsAndRemoveDuplicates(primeUtils.createListOfPrimeFactors(x), primeFactors);
		}
		
		int result = 1;
		for(int factor : primeFactors){
			result *= factor;
		}
		return result;
	}
}

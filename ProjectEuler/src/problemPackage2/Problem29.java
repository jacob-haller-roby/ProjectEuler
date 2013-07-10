package problemPackage2;

import helpers.PrimeUtils;

import java.util.List;

public class Problem29 {
	
	private static PrimeUtils primeUtils;
	
	public static void main(String[] args){
		System.out.println("The Answer is: " + distinctValues(100));
	}
	
	private static int distinctValues(int max){
		
		int answer = 0;
		int[] duplicatesByPrimeCount = createDuplicateByPrimeArray(max);
		for(int current = 2; current <= max; current++){
			answer += max - 1 - duplicatesByPrimeCount[primeCount(current, max)];
		}
		return answer;
	}
	
	private static int primeCount(int number, int max){
		int n = 0;
		for(int prime : primeUtils.getPrimes()){
			if(Math.pow(number, prime) > max){
				return n;
			}
			n++;
		}
		return -1; //Should not reach
	}
	
	
	private static int[] createDuplicateByPrimeArray(int max){
		
		primeUtils = new PrimeUtils();
		primeUtils.extendListToUpperBound(max);
		
		int[] duplicateByPrimeCount = new int[primeUtils.getPrimes().size()];
		int potentialPrimePowers = 0;
		
		for(int index = 0; index < primeUtils.getPrimes().size(); index++){
			int exp = primeUtils.getPrimes().get(index);
			if(Math.pow(2, exp) > max){
				break;
			}
			
			for(int index2 = index; index2 < primeUtils.getPrimes().size() - 1; index2++){
				duplicateByPrimeCount[index2 + 1] += (max/exp) - 1;
				
			}
			potentialPrimePowers++;
		}
		
		for(int index = 0; index < potentialPrimePowers; index++){
			int lowerPrime = primeUtils.getPrimes().get(index);
			for(int index2 = index + 1; index2 < potentialPrimePowers; index2++){
				int higherPrime = primeUtils.getPrimes().get(index2);
				int aboveMaxDuplicates = (lowerPrime*max)/(lowerPrime* higherPrime) - max/(lowerPrime * higherPrime);
				for(int saveIndex = index2; saveIndex< duplicateByPrimeCount.length - 1; saveIndex++){
					duplicateByPrimeCount[saveIndex + 1] += aboveMaxDuplicates;
				}
			}
		}
		
		return duplicateByPrimeCount;
	}
	

}

package helpers;

import java.util.ArrayList;
import java.util.List;

public class PrimeUtilsLong {
	
	private List<Long> primes;
	
	public PrimeUtilsLong() {
		super();
		initializePrimes();
	}
	
	private void initializePrimes(){
		primes = new ArrayList<Long>();
		primes.add((long) 2);
		primes.add((long) 3);
		primes.add((long) 5);
	}
	
	public List<Long> getPrimes(){
		return primes;
	}
	
	private long addPrime(){
		
		trialNumber: for(long trialNumber = primes.get(primes.size() - 1) + 2; ; trialNumber+=2){
			for(long prime : primes){
				if(trialNumber % prime == 0){
					continue trialNumber;
				}
				if(prime * prime > trialNumber){
					break;
				}
			}
			primes.add(trialNumber);
			return trialNumber;
		}
	}
	
	public long largestPrimeFactor(long input) { 
		
		for(long prime : primes){
			while (input % prime == 0){
				input /= prime;
			}
			if(prime * prime > input){
				if(input == 1){
					return prime;
				}
				return input;
			}
		}
		
		for(long prime = addPrime(); prime * prime <= input; prime = addPrime()){
			while(input % prime == 0){
				input /= prime;
				if(input == 1){
					return prime;
				}
			}
		}
		
		return input;
	}
	
	public List<Long> createListOfPrimeFactors(long input) {
		 List<Long> result = new ArrayList<Long>();
		 
		 for(long prime : primes){
			 while ( input % prime == 0){
				 input /= prime;
				 result.add(prime);
			 }
			 if (prime * prime > input){
				 if(input != 1){
					 result.add(input);
				 }
				 return result;
			 }
		 }
		 
		 for(long prime = addPrime(); prime * prime <= input; prime = addPrime()){
			 while(input % prime == 0){
				 result.add(prime);
			 }
		 }
		 
		 if(input != 1){
			 result.add(input);
		 }
		 
		 return result;
	}
	
	public void extendListToUpperBound(long upperBound) {
		for(long prime = primes.get(primes.size() - 1); prime < upperBound; prime = addPrime());
	}
	
	public void extendListToPrimeCount(int count){
		for(int numberOfPrimes = primes.size(); numberOfPrimes < count; numberOfPrimes++){
			addPrime();
		}
	}

}

package helpers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrimeUtils {
	
	private List<Integer> primes;
	private Map<Integer, Integer> primeMap;
	
	public PrimeUtils() {
		super();
		initializePrimes();
	}
	
	private void initializePrimes(){
		primes = new ArrayList<Integer>();
		primes.add(2);
		primes.add(3);
		primes.add(5);
	}
	
	public List<Integer> getPrimes(){
		return primes;
	}
	
	public Map<Integer, Integer> getPrimeMap(){
		if(primeMap == null){
			initializePrimeMap();
		}
		return primeMap;
	}
	
	private void initializePrimeMap(){
		primeMap = new HashMap<Integer, Integer>();
		for(int prime : primes){
			primeMap.put(prime, prime);
		}
	}
	
	private int addPrime(){
		
		trialNumber: for(int trialNumber = primes.get(primes.size() - 1) + 2; ; trialNumber+=2){
			for(int prime : primes){
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
	
	public int largestPrimeFactor(int input) { 
		
		for(int prime : primes){
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
		
		for(int prime = addPrime(); prime * prime <= input; prime = addPrime()){
			while(input % prime == 0){
				input /= prime;
				if(input == 1){
					return prime;
				}
			}
		}
		
		return input;
	}
	
	public List<Integer> createListOfPrimeFactors(int input) {
		 List<Integer> result = new ArrayList<Integer>();
		 
		 for(int prime : primes){
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
		 
		 for(int prime = addPrime(); prime * prime <= input; prime = addPrime()){
			 while(input % prime == 0){
				 result.add(prime);
				 input /= prime;
			 }
		 }
		 
		 if(input != 1){
			 result.add(input);
		 }
		 
		 return result;
	}
	
	public void extendListToUpperBound(int upperBound) {
		for(int prime = primes.get(primes.size() - 1); prime < upperBound; prime = addPrime());
	}
	
	public void extendListToPrimeCount(int count){
		for(int numberOfPrimes = primes.size(); numberOfPrimes < count; numberOfPrimes++){
			addPrime();
		}
	}
	
	public boolean isPrime(int input){
		extendListToUpperBound(input);
		return primes.contains(input);
	}

}

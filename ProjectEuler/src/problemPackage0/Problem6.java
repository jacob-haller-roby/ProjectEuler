package problemPackage0;

public class Problem6 {
	
	public static void main(String[] args){
		

		long start = System.nanoTime();
		System.out.println("The Answer is: " + speedAttempt(100));
		long mid = System.nanoTime();
		System.out.println("The Answer is: " + bruteForce(100));
		long end = System.nanoTime();
		
		System.out.println("Speed Time: " + (mid - start));
		System.out.println("Brute Time: " + (end - mid));
		
	}
	
	
	private static long sumOfSquares(int upperLimit){
		
		long result = 0;
		for(int x = 1; x <= upperLimit; x++){
			result += x*x;
		}
		return result;
	}
	
	private static long squareOfSums(int upperLimit){
		
		long result = 0;
		for(int x = 1; x<= upperLimit; x++){
			result += x;
		}
		result *= result;
		return result;
	}
	
	private static long bruteForce(int upperLimit){
		return squareOfSums(upperLimit) - sumOfSquares(upperLimit);
	}
	
	private static long speedAttempt(int upperLimit){
		
		long squareOfSums = 0;
		long sumOfSquares = 0;
		
		for(int x = 1; x <= upperLimit; x++){
			squareOfSums += x;
			sumOfSquares += x*x;
		}
		squareOfSums *= squareOfSums;
		return squareOfSums - sumOfSquares;
	}

}

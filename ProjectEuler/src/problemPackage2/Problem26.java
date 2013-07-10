package problemPackage2;

public class Problem26 {
	
	/*
	 * Reading into the question:
	 * 
	 * A hint is given in the phrasing of this question.  Because we know there is exactly one 
	 * unique answer, we are able to eliminate a number of choices.
	 * 
	 * To start, we can eliminate any number that is divisible by either 5 or 2.  Because these
	 * are the prime factors of 10 and we are doing division in base 10, these values will be
	 * functional repeats for this problem.  For instance, take the values of 7, 14, 21, and 35.
	 * 
	 * 1/7 =   0.(142857) : 6
	 * 1/14 = 0.0(714285) : 6
	 * 1/21 = 0.0(476190) : 6
	 * 1/35 = 0.0(285714) : 6
	 * 
	 * While the recurring cycles are different in value, their periods are identical.  This 
	 * is because 14 = 7 * 2, 21 = 7 * 3 and 35 = 7 * 5.  2, 3, and 5 will have 
	 * no impact on cycle length.
	 * 
	 * In addition to numbers divisible by 2 and 5, we can also remove any number which
	 * can be multiplied by 2 without exceeding the limit of 1000.  This means that every
	 * value below 500 can be ignored.
	 *   
	 * This leaves only 100 numbers out of our original 1000 that need to be tested.
	 * 
	 * Two solutions become apparent.  We can either use an equation matched with prime factors
	 * to determine the length of the repeating sequences, or we can manually search for
	 * repetitions.  While using the formula would be an interesting experiment, there are
	 * 168 primes below 1000 which would each need to be analyzed for that method, while 
	 * only 100 digits are of any consequence to our search.  Thus, a hard search is more efficient.
	 * 
	 */
	
	public static void main(String[] args){
		
		long start = System.nanoTime();
		System.out.println("The Answer is: " + manuallySearch());
		long end = System.nanoTime();
		System.out.println("TIME: " + (end - start));
	}
	
	
	private static int manuallySearch(){
		
		int maxCycleLength = 0;
		int maxCycleNumber = 0;
		for(int testNumber = 503; testNumber < 1000; testNumber += 6){
			if(testNumber % 5 == 0){
				continue;
			}
			
			int cycleLength = 0;
			for(int remainder = (1000 % testNumber)*10; remainder != 1000; remainder = (remainder%testNumber)*10){
				cycleLength++;
			}
			
			if(cycleLength > maxCycleLength){
				
				maxCycleLength = cycleLength;
				maxCycleNumber = testNumber;
			}
		}
		
		return maxCycleNumber;
		
	}

}

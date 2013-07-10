package problemPackage0;

public class Problem2 {
	
	public static void main(String[] args){
		
		System.out.println("The Answer is: " + findSum(4000000));
	}

	private static int findSum(int upperLimit){
		int fibOne = 2;
		int fibTwo = 8;
		int total = 2;
		
		while (fibTwo < upperLimit){
			total += fibTwo;
			fibTwo = 4*fibTwo + fibOne;
			fibOne = (fibTwo - fibOne)/4;
		}
		
		return total;
	}
}

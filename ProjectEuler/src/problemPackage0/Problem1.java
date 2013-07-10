package problemPackage0;

public class Problem1 {

	public static void main(String[] args){
		System.out.println("The Answer is: " + multiplesOf(3, 4, 1000));

	}
	
	private static int multiplesOf(int factorA, int factorB, int upperLimit){
		
		int counterA = 0, counterB = 0, total = 0;
		
		while(counterA <= upperLimit && counterB <= upperLimit){
			if(counterA < counterB){
				total += counterA;
				counterA += factorA;
			} else if (counterA == counterB){
				counterB += factorB;
			} else {
				total += counterB;
				counterB += factorB;
			}
		}
		return total;
	}
}

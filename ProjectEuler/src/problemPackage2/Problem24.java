package problemPackage2;

public class Problem24 {

	public static void main(String[] args){
		System.out.println("The Answer is: " + permutation(1000000));
	}
	
	private static String permutation(int nth){
		nth -= 1;
		boolean[] numberArray = new boolean[10];
		
		int factorial = 1;
		for(int i = 2; i < 10; i++){
			factorial *= i;
		}
		
		int[] sortValue = new int[10];
		for(int factorialIndex = 9; factorialIndex > 0; factorialIndex--){
			while(nth >= factorial){
				nth -=factorial;
				sortValue[9-factorialIndex]++;
			}
			factorial /=factorialIndex;
		}
		
		String answer = "";
		for(int i = 0; i < 10; i++){
			int digitIndex = 0;
			for(int j = 0, limit = sortValue[i]; j <= limit; j++){
				if(numberArray[j]){
					limit++;
				}
				digitIndex = j;
			}
			numberArray[digitIndex] = true;
			answer += String.valueOf(digitIndex);
		}
		return answer;
	}
}

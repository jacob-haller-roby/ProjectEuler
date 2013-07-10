package problemPackage0;

public class Problem4 {
	
	public static void main(String[] args){
		
		System.out.println("The Answer is: " + findPalindromicMultiple(999));
		
	}

	private static int findPalindromicMultiple(int factorUpperLimit){
		
		int currentBest = 0;
		for(int a = factorUpperLimit; a > 0; a--){
			if(a*factorUpperLimit < currentBest){
				break;
			}
			for(int b = factorUpperLimit; b >= a; b--){
				if(a*b < currentBest){
					break;
				}
				
				if(testPalindrome(a*b)){
					currentBest = a*b;
					break;
				}
			}
		}
		return currentBest;
	}
	
	private static boolean testPalindrome(int input){
		String testValue = Integer.toString(input);
		for(int length = testValue.length(), index = 0; index < length; index++){
			if(testValue.charAt(index) != testValue.charAt(length - index - 1)){
				return false;
			}
		}
		return true;
	}
}

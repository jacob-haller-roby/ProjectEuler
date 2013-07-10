package problemPackage3;

public class Problem36 {
	
	public static void main(String[] args){
		
		System.out.println("The Anser is: " + palindromes());
	}
	
	private static int palindromes(){
		
		int sum = 0;
		for(int possibleDrome = 1; possibleDrome < 1000000; possibleDrome+=2){
			if(isPalindrome(Integer.toString(possibleDrome)) &&
					isPalindrome(Integer.toBinaryString(possibleDrome))){
				sum += possibleDrome;
				System.out.println(possibleDrome +":"+ Integer.toBinaryString(possibleDrome));
			}
		}
		return sum;
	}
	
	private static boolean isPalindrome(String input){
		
		for(int index = 0; index <input.length()/2; index++){
			if(input.charAt(index) != input.charAt(input.length() - index - 1)){
				return false;
			}
		}
		return true;
		
	}

}

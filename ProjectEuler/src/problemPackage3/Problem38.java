package problemPackage3;

public class Problem38 {
	
	public static void main(String[] args){
		
		System.out.println("The Answer is: " + pandigitalConcat());
	}
	
	private static String pandigitalConcat(){
		
		boolean[] digits = new boolean[10];
		digits[0] = true;
		
		int a = 9;
		digits[9] = true;
		
		for(int b = 8; b > 1; b--){
			
			digits[b] = true;
			int twoDigit = a*10 + b;
			
			for(int c = 8; c > 1; c--){
				
				if(digits[c]){
					continue;
				}
				digits[c] = true;
				int threeDigit = twoDigit*10 + c;
				
				for(int d = 8; d > 1; d--){
					
					if(digits[d]){
						continue;
					}
					digits[d] = true;
					int fourDigit = threeDigit*10 + d;
					
					String fourDigitAnswer = isPandigital(fourDigit, digits);
					if(fourDigitAnswer != "Not Pandigital"){
						return fourDigitAnswer;
					}
					
					
					
					digits[d] = false;
				}
				
				String threeDigitAnswer = isPandigital(threeDigit, digits);
				if(threeDigitAnswer != "Not Pandigital"){
					return threeDigitAnswer;
				}
				digits[c] = false;
			}	
			
			String twoDigitAnswer = isPandigital(twoDigit, digits);
			if(twoDigitAnswer != "Not Pandigital"){
				return twoDigitAnswer;
			}
			digits[b] = false;
		}
		return isPandigital(a, digits);
		
	}
	
	private static String isPandigital(int input, boolean[] digits){
		
		boolean[] testDigits = digits.clone();
		
		String answer = "" + input;
		nextN:
		for(int n = 2; n <6; n++){
			
			int concatPiece = n*input;
			answer += concatPiece;
			
			while(concatPiece > 0){
				if(testDigits[concatPiece%10]){
					return "Not Pandigital";
				}
				testDigits[concatPiece%10] = true;
				concatPiece /= 10;
			}
			
			for(boolean complete : testDigits){
				if(!complete){
					continue nextN;
				}
			}
			
			return answer;
		}
		return "ERROR";
	}

}

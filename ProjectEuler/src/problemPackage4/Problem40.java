package problemPackage4;

public class Problem40 {
	
	public static void main(String[] args){
		
		System.out.println("The Answer is: " + champernowne());
	}

	private static int champernowne(){
		
		int product = 1;
		for(int i = 1; i < 10000000; i *= 10){
			product *= findDigit(i);
		}
		return product;
		
	}
	
	private static int findDigit(int i){
		i -= 1;
		int digitLength = 1;
		int power = 9;
		int integer = 1;
		
		while(power *digitLength<= i){
			i -= power*digitLength;
			integer += power ;
			power *= 10;
			digitLength++;
		}
		
		integer += i/digitLength;
		
		for(int digitPosition = i%digitLength + 1; digitPosition < digitLength; digitPosition++){
			integer /= 10;
		}
		
		return integer % 10;
		
		
	}
}

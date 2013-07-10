package problemPackage1;

import java.util.ArrayList;
import java.util.List;

public class Problem16 {

	public static void main(String[] args){
		System.out.println("The Answer is: " + sumOfDigits(2,1000));
	}
	
	private static long sumOfDigits(int base, int exponent){
		
		List<Integer> digits = new ArrayList<Integer>();
		digits.add(1);
		for(int x = 0; x < exponent; x++){
			int size = digits.size();
			int lastDigit = digits.get(size - 1);
			lastDigit *=2;
			digits.set(size - 1, lastDigit %10);
			if(lastDigit > 9){
				digits.add(lastDigit/10);
			}
			for(int index = size - 2; index >= 0 ; index--){
				int currentDigit = digits.get(index);
				currentDigit *= 2;
				digits.set(index, currentDigit %10);
				if(currentDigit > 9){
					digits.set(index + 1, currentDigit / 10 + digits.get(index + 1));
				}
			}
		}
		
		int sum = 0;
		for (int digit : digits){
			sum += digit;
		}
		return sum;
	}
}

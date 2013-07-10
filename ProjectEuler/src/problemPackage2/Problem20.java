package problemPackage2;

import java.util.ArrayList;
import java.util.List;

public class Problem20 {
	
	public static void main(String[] args){
		System.out.println("The Answer is: " + findSumOfFactorialDigits(100));
	}
	
	private static int findSumOfFactorialDigits(int base){
		List<Integer> digits = new ArrayList<Integer>();
		digits.add(1);
		
		for(int multiplier = base; multiplier > 1; multiplier--){
			int size = digits.size();
			for(int index = 0; index < size; index++){
				digits.set(index, digits.get(index) * multiplier);
			}
			
			for(int index = 0; index < size; index++){
				try{
					digits.set(index + 1, (digits.get(index)/10) + digits.get(index + 1)); 
				} catch (Exception e) {
					if(digits.get(index) / 10 != 0){
						digits.add(digits.get(index) / 10);
						size++;
					}
				}
				digits.set(index, digits.get(index)%10);
			}
		}
		int sum = 0;
		for(int digit : digits){
			sum += digit;
		}
		return sum;
	}

}

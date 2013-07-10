package problemPackage2;

import java.util.ArrayList;
import java.util.List;

public class Problem23 {
	
	public static void main(String[] args){
		System.out.println("The Answer is: " + sumOfNonAbundantSums());
	}
	
	private static int sumOfNonAbundantSums(){
		int highestValue = 28123;
		List<Integer> abundantList = createAbundantListBelow(highestValue);
		
		boolean[] abundantSumArray = new boolean[highestValue];
		
		for(int index = 0; index < abundantList.size(); index++){
			int abundantNumber = abundantList.get(index);
			for(int index2 = index; index2 < abundantList.size(); index2++){
				int sum = abundantNumber + abundantList.get(index2);
				if( sum >= highestValue){
					break;
				}
				abundantSumArray[sum] = true;
			}
		}
		
		int total = 0;
		for(int index = 1; index < highestValue; index++){
			if(!abundantSumArray[index]){
				total += index;
			}
		}
		return total;
	}
	
	private static List<Integer> createAbundantListBelow(int upperLimit){
		List<Integer> abundantList = new ArrayList<Integer>();
		for(int x = 12; x < upperLimit; x++){
			if(isAbundant(x)){
				abundantList.add(x);
			}
		}
		return abundantList;
	}
	
	private static boolean isAbundant(int input){
		int sum = 1;
		for(int x = 2; x*x <= input; x++){
			if(input%x == 0){
				sum += x;
				sum += input / x;
				if(sum > input){
					if(x*x == input && sum -x <= input){
						return false;
					}
					return true;
				}
			}
		}
		return false;
	}

}

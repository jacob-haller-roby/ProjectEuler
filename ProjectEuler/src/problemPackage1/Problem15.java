package problemPackage1;

import java.util.ArrayList;
import java.util.List;

public class Problem15 {
	
	public static void main(String[] args){
		System.out.println("The Answer is: " + numberOfPaths(20));
	}
	
	private static long numberOfPaths(int depth){
		
		List<Integer> pascalList = pascalsTriangleLowestLevel(depth);
		
		long result = 0;
		for(long pascalNumber : pascalList){
			result += pascalNumber*pascalNumber;
		}
		
		return result;
	}
	
	private static List<Integer> pascalsTriangleLowestLevel(int depth){
		List<Integer> firstLayer = new ArrayList<Integer>();
		firstLayer.add(1);
		firstLayer.add(1);
		return pascalsTriangleLowestLevel(firstLayer, depth - 1);
	}
	
	private static List<Integer> pascalsTriangleLowestLevel(List<Integer> previousLayer, int depth){
		if(depth == 0){
			return previousLayer;
		}
		
		int previous = 0;
		List<Integer> nextLayer = new ArrayList<Integer>();
		for(int current : previousLayer){
			nextLayer.add(current + previous);
			previous = current;
		}
		nextLayer.add(1);
		
		return pascalsTriangleLowestLevel(nextLayer, depth - 1);
	}

}

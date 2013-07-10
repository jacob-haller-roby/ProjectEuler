package problemPackage1;

import java.util.ArrayList;
import java.util.List;

public class Problem14 {

	public static void main(String[] args){
		long start = System.nanoTime();
		System.out.println("The Answer is: " + longestChain(1000000));
		long mid = System.nanoTime();
		System.out.println("The Answer is: " + bruteForce(1000000));
		long end = System.nanoTime();
		System.out.println("Algorithm Time: " + (mid - start));
		System.out.println("BruteForc Time: " + (end - mid));
	}
	
	private static int bruteForce(int upperLimit){
		
		int maxDistance = 0;
		int maxNumber = 0;
		for(int i = upperLimit/2; i <=upperLimit; i++){
			long currentValue = i;
			int distance = 1;
			while (currentValue != 1){
				currentValue = ((currentValue & 1) == 1) ? (3*currentValue + 1) : (currentValue >> 1);
				distance++;
			}
			
			if(distance > maxDistance){
				maxDistance = distance;
				maxNumber = i;
			}
		}
		
		return maxNumber;
	}
	
	private static int longestChain(int upperLimit){
		
		int[] pathLengths = new int[upperLimit + 1];
		
		pathLengths[1] = 1;
		int longestChain = 1;
		int answer = 1;
		
		for(int i = upperLimit/2; i <= upperLimit; i++){
			int distance = findDistance(i, pathLengths, upperLimit);
			if(distance > longestChain){
				longestChain = distance;
				answer = i;
			}
		}
		
		return answer;
	}
	
	private static int findDistance(long i, int[] pathLengths, int upperLimit){
		int number = (int) i;
		int distance = 0;
		List<Integer> keys = new ArrayList<Integer>();
		boolean saveToMap = true;
		while(i > upperLimit || pathLengths[(int) i] == 0){
			if(i > upperLimit){
				saveToMap = false;
			}
			
			if(saveToMap){
				keys.add((int) i);
			}
			distance++;
			i = ((i & 1) == 1) ? (3*i + 1) : (i >> 1);
		}
		
		distance += pathLengths[(int) i];
		
		if(saveToMap){
			for(int key : keys){
				pathLengths[key] = distance;
				distance--;
			}
		} else {
			pathLengths[number] = distance;
		}
		return pathLengths[number];
	}
}

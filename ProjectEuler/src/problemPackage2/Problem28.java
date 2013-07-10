package problemPackage2;

public class Problem28 {
	
	public static void main(String[] args){
		System.out.println("The Answer is: " + diagonalSum(1001));
	}
	
	private static int diagonalSum(int dimension){
		
		int answer = 1;
		int side = 2;
		int squareCount = 0;
		int number = 1;
		while(side < dimension){
		
			if(squareCount == 4){
				squareCount = 0;
				side += 2;
				continue;
			}
			
			squareCount++;
			number += side;
			answer += number;
		}
		
		return answer;
	}
	

}

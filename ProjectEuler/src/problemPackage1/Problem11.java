package problemPackage1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem11 {
	
	public static void main(String[] args) throws FileNotFoundException{
		System.out.println("The Answer is: " + findLargestProduct());
	}
	
	private static int findLargestProduct() throws FileNotFoundException {
		
		List<List<Integer>> sourceMap = createMap();
		int greatestProduct = 0;
		int smallestAllowed = 0;
		
		for(int x = 0; x < 20; x++){
			for(int y = 0; y < 20; y++){
				if(sourceMap.get(y).get(x) <= smallestAllowed){
					continue;
				}
				int horizontal = horizontalProduct(x, y, smallestAllowed, sourceMap);
				int vertical = verticalProduct(x, y, smallestAllowed, sourceMap);
				int diagonalRight = diagonalRightProduct(x, y, smallestAllowed, sourceMap);
				int diagonalLeft = diagonalLeftProduct(x, y, smallestAllowed, sourceMap);
				
				if(horizontal > greatestProduct){
					greatestProduct = horizontal;
					smallestAllowed = greatestProduct/(99*99*99);
				}
				if(vertical > greatestProduct){
					greatestProduct = vertical;
					smallestAllowed = greatestProduct/(99*99*99);
				}
				if(diagonalRight > greatestProduct){
					greatestProduct = diagonalRight;
					smallestAllowed = greatestProduct/(99*99*99);
				}
				if(diagonalLeft > greatestProduct){
					greatestProduct = diagonalLeft;
					smallestAllowed = greatestProduct/(99*99*99);
				}
			}
		}
		return greatestProduct;
	}
	
	private static List<List<Integer>> createMap() throws FileNotFoundException{
		
		Scanner fileIn = new Scanner(new File("SourceFiles/problem11Source"));
		List<List<Integer>> sourceMap = new ArrayList<List<Integer>>();
		for(int y = 0; y < 20; y++){
			List<Integer> sourceMapRow = new ArrayList<Integer>();
			for(int x = 0; x < 20; x++){
				sourceMapRow.add(Integer.parseInt(fileIn.next()));
			}
			sourceMap.add(sourceMapRow);
		}
		fileIn.close();
		return sourceMap;
	}
	
	private static int horizontalProduct(int x, int y, int smallestAllowed, List<List<Integer>> sourceMap){
		if(x > 16){
			return 0;
		}
		
		int product = 1;
		for(int xDim = x; xDim < x+4; xDim++){
			int current = sourceMap.get(y).get(xDim);
			if(current <= smallestAllowed){
				return 0;
			}
			product *= current;
		}
		return product;
	}
	
	private static int verticalProduct(int x, int y, int smallestAllowed, List<List<Integer>> sourceMap){
		if(y > 16){
			return 0;
		}
		
		int product = 1;
		for(int yDim = y; yDim < y+4; yDim++){
			int current = sourceMap.get(yDim).get(x);
			if(current <= smallestAllowed){
				return 0;
			}
			product *= current;
		}
		return product;
	}
	
	private static int diagonalRightProduct(int x, int y, int smallestAllowed, List<List<Integer>> sourceMap){
		if(x > 16 || y > 16){
			return 0;
		}
		
		int product = 1;
		for(int xDim = x, yDim = y; xDim < x+4; xDim++, yDim++){
			int current = sourceMap.get(yDim).get(xDim);
			if(current <= smallestAllowed){
				return 0;
			}
			product *= current;
		}
		return product;
	}
	
	private static int diagonalLeftProduct(int x, int y, int smallestAllowed, List<List<Integer>> sourceMap){
		if(x  < 3 || y > 16){
			return 0;
		}
		
		int product = 1;
		for(int xDim = x, yDim = y; yDim < y+4; yDim++, xDim--){
			int current = sourceMap.get(yDim).get(xDim);
			if(current <= smallestAllowed){
				return 0;
			}
			product *= current;
		}
		return product;
	}

}

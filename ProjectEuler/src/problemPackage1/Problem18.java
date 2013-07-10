package problemPackage1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem18 {

	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("The Answer is: " + maxPathLength(createPyramid()));
	}

	private static List<int[]> createPyramid() throws FileNotFoundException {
		Scanner fileIn = new Scanner(new File("SourceFiles/problem18Source"));

		List<int[]> pyramid = new ArrayList<int[]>();

		for (int height = 1; fileIn.hasNext(); height++) {
			int[] pyramidRow = new int[height];

			for (int x = 0; x < height; x++) {
				pyramidRow[x] = Integer.parseInt(fileIn.next());
			}

			pyramid.add(pyramidRow);
		}
		fileIn.close();
		return pyramid;
	}

	private static int maxPathLength(List<int[]> pyramid) {

		for (int height = pyramid.size() - 1; height > 0; height--) {
			for (int x = 0; x < height; x++) {
				int path = (pyramid.get(height)[x] > pyramid.get(height)[x + 1]) ? pyramid
						.get(height)[x] : pyramid.get(height)[x + 1];
				pyramid.get(height - 1)[x] += path;
			}
		}
		return pyramid.get(0)[0];
	}

}

package helpers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NumberSetHelper {
	
	public static List<Integer> mergeListsAndRemoveDuplicates(List<Integer> listOne, List<Integer> listTwo){
		
		if(listOne.isEmpty()){
			return listTwo;
		}
		if(listTwo.isEmpty()){
			return listOne;
		}
		
		Iterator<Integer> listTwoIterator = listTwo.iterator();
		int nextTwo = listTwoIterator.next();
		List<Integer> result = new ArrayList<Integer>();
		boolean twoNotEmpty = true;
		
		for(int nextOne : listOne){
			
			while(nextOne > nextTwo && twoNotEmpty){
				result.add(nextTwo);
				if(listTwoIterator.hasNext()){
					nextTwo = listTwoIterator.next();
				} else {
					twoNotEmpty = false;
					nextTwo = 0;
				}
			}
			
			if(nextOne == nextTwo){
				if(listTwoIterator.hasNext()){
					nextTwo = listTwoIterator.next();
				} else {
					twoNotEmpty = false;
					nextTwo = 0;
				}
			}
			
			result.add(nextOne);
		}
		
		if(twoNotEmpty){
			result.add(nextTwo);
		}
		while(listTwoIterator.hasNext()){
			result.add(listTwoIterator.next());
		}
		
		return result;
	}

}

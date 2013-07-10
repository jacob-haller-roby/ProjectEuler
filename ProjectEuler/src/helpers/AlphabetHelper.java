package helpers;

public class AlphabetHelper {

	public static boolean alphabeticalTest(String a, String b){
		boolean lengthDefault = true;
		int size = a.length();
		if(size > b.length()){
			lengthDefault = false;
			size = b.length();
		}
		
		for(int x = 0; x < size; x++){
			if(a.charAt(x) < b.charAt(x)){
				return true;
			}
			
			if(a.charAt(x) > b.charAt(x)){
				return false;
			}
		}
		return lengthDefault;
	}
}

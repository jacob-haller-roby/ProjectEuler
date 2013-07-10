package problemPackage1;

import helpers.MonthsEnum;

public class Problem19 {
	
	public static void main(String[] args){
		System.out.println("The Answer is: " + countSundays());
	}
	
	private static int countSundays(){
		int days = 1;
		for(int month = 0; month < 12; month++){
			days += MonthsEnum.getDays(month, 1900);
		}
		
		int counter = 0;
		for(int year = 1901; year < 2001; year++){
			for(int month = 0; month < 12; month++){
				days %= 7;
				if(days == 0){
					counter++;
				}
				days += MonthsEnum.getDays(month, year);
			}
		}
		return counter;
	}

}

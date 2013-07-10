package helpers;

public enum MonthsEnum {

	JANUARY(31),
	FEBRUARY(28){
		@Override
		public int getDays(int year){
			if(year % 4 == 0 && year % 100 != 0){
				return 29;
			}
			return 28;
		}
	},
	MARCH(31), APRIL(30), MAY(31), JUNE(30), JULY(31), AUGUST(31), SEPTEMBER(30), OCTOBER(31), NOVEMBER(30), DECEMBER(31);
	
	private int days;
	
	private MonthsEnum(int daysInput) {
		days = daysInput;
	}
	
	public int getDays(int year){
		return days;
	}
	
	public static int getDays(int month, int year){
		return MonthsEnum.values()[month].getDays(year);
	}
}

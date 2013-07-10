package problemPackage0;

public class Problem9 {
	
	public static void main(String[] args){
		System.out.println("The Answer is: " + findProduct());
	}

	private static int findProduct(){
		for(int c = 499; c > 0; c--){
			int hypo = c*c;
			for(int a = c - 1, b = 1001 - 2*c, legs = a*a + b*b; a >=b && legs > hypo; a--, b++){
				legs = a*a + b*b;
				if(legs == hypo){
					return a*b*c;
				}
			}
		}
		return 0;
	}
}

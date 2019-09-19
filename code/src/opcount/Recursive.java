package opcount;

public class Recursive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int factorial(int i) {
		if(i==0) {
			return 1;
		}else {
			return i* factorial(i-1);
		}
	}

}

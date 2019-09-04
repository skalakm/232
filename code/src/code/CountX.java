package code;

public class CountX {
	
	public static void main(String[] args) {
		
		String input= "xaaxsfgjfghxgzxcvnvsdx";
		int output = countXSlow(input);
		int fastOutput = countXFast(input, 0);
		System.out.println(fastOutput);
	}
	
	public static int countXSlow(String input) {
		if(input.length() == 0) {
			return 0;
		}else {
			if( input.charAt(0) =='x') // is the first char 'x'?
			{
				return 1 + countXSlow(input.substring(1));
			}else {
				return countXSlow(input.substring(1));
			}
		}
	}
	
	public static int countXFast(String input, int curIndex) {
		if(input.length() == curIndex) {
			return 0;
		}else {
			if( input.charAt(curIndex) =='x') // is the current char 'x'?
			{
				return 1 + countXFast(input, curIndex+1);
			}else {
				return countXFast(input, curIndex+1);
			}
		}
	}

}

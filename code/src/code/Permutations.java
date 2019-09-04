package code;

import java.util.ArrayList;

public class Permutations {
	
	public static void main(String[] args) {
		String input = "abcdefghi";
		
		ArrayList<String> output = permute(input);
		System.out.println(output);
	}
	
	public static ArrayList<String> permute(String input){
		ArrayList<String> output = new ArrayList<String>();
		if(input.length() ==1) {
			output.add(input);
			return output;
		}else {
			for(int i = 0; i< input.length(); ++i) {
				String firstHalf = input.substring(0,i);
				String secondHalf = input.substring(i+1);
				ArrayList<String> results = permute(secondHalf+firstHalf);
				for(String r : results) {
					output.add(input.charAt(i)+r);
				}
			}
			return output;
			
			
		}
		
	}

}

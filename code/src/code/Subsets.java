package code;

import java.util.ArrayList;

public class Subsets {
	
	public static void main(String[] args) {
		
		ArrayList<String> result = subsets("", "abcdefghij");
		System.out.println(result);
	}
	
	public static ArrayList<String> subsets(String prefix, String rest){
		ArrayList<String> results = new ArrayList<>();
		
		System.out.println("rest is " + rest);
		if(rest.length()==0) {
			results.add(prefix);
			return results;
		}else {
			String newPrefixWithAddition = prefix + rest.charAt(0);
			String newRest = rest.substring(1);
			
			//leaving out the character
			results.addAll(subsets(prefix, newRest));
			
			// adding the current character
			results.addAll( subsets(newPrefixWithAddition, newRest));
			
			
			
			return results;
		}
		
	}

}

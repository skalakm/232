package opcount;

import java.util.ArrayList;

public class ReplaceFirstX {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void replaceFirstX(ArrayList<Character> arr) {
		
		for(int i = 0; i < arr.size(); ++i) {
			if(arr.get(i) == 'x') {
				arr.set(i, 'y');
				return;
			}
		}
	}

}

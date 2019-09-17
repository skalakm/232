package opcount;

public class Count0sInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int count0s(int[][] input) {
		int count = 0;
		for(int i = 0; i < input.length; i++) {
			for(int j = 0; j < input[0].length; j++) {
				if(input[i][j] == 0) {
					count++;
				}
			}
		}
		return count;
	}

}

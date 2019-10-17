package code;

public class ExamPractice {

	
	public int find(int[][] array, int target) { // assuming a square array
		for(int i = 0; i < array.length; ++i) {
			for(int j = 0; j < array.length; ++j) {
				if( (array[i]) [j] == target) {
					return i +j ;
				}
			}
		}
		return -1;
	}
}

package opcount;

public class UpperTriangleSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int sum(int[][] matrix) {
		int count = 0;
		for(int i = 0; i < matrix.length; ++i) {
			for(int j = i; j< matrix.length; ++j) {
				count+=matrix[i][j];
			}
		}
		return count;
	}
}

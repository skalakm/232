package code;
import java.util.*;

public class SplitArray {

	public static void main(String[] args) {
		
		int[] valInts = new int[] {1,2,34,5};

		ArrayList<Integer> vals = new ArrayList<>();
		vals.add(3);
		vals.add(2);
		vals.add(6);
		vals.add(4);
		vals.add(4);
		vals.add(7);
		vals.add(4);
		vals.add(24);
		vals.add(6);
		vals.add(2);
		vals.add(7);
		vals.add(3);
		vals.add(6);
		
		System.out.println(splitArray(vals,0,0,0));

	}
	
	public static boolean splitArray(ArrayList<Integer> nums,
			int s1, int s2, int curIndex) {
		
		if(nums.size() == curIndex) {
			return s1==s2;
		}else {
			boolean putInGroup1 = splitArray(nums, s1+nums.get(curIndex),
					s2, curIndex+1);
			boolean putInGroup2 = splitArray(nums, s1, s2+nums.get(curIndex), curIndex+1);
			return putInGroup1||putInGroup2;
		}
		
		
	}
	
	public static boolean splitArray(ArrayList<Integer> nums,
			int s1, int s2, ArrayList<Integer> g1, ArrayList<Integer> g2, int curIndex)
	{
		return true;
	}

}

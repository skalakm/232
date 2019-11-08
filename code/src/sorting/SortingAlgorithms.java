package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;


public class SortingAlgorithms {

	
	public static void main(String[] args) {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		IntStream.range(0,10).forEach(s -> nums.add(s));
		Collections.shuffle(nums);
		System.out.println(nums);
		selectionSort(nums);
		System.out.println(nums);
		ArrayList<Pair> pairs = new ArrayList<Pair>();
		Random r = new Random();
		IntStream.range(0, 10).forEach(s-> pairs.add(new Pair(r.nextInt(5),r.nextInt(5) )));
		System.out.println(pairs);
		selectionSort(pairs);
		System.out.println(pairs);
	}
	
	public static <K extends Comparable<K>> ArrayList<K> selectionSort(ArrayList<K> vals){
		
			for(int i = 0; i < vals.size(); ++i) {
				// find min from i to end of list
				K min = vals.get(i);
				int minIndex = i;
				for(int j =i+1; j < vals.size(); ++j) {
					// if cur element is less than min
					if( min.compareTo(vals.get(j)) >= 0) {
						min = vals.get(j);
						minIndex = j;
					}
				}
				// swap the curIndex and the minIndex
				K temp = vals.get(i);
				vals.set(i, vals.get(minIndex));
				vals.set(minIndex, temp);
				//System.out.println(vals);
			}
			return vals;
	}
	
	public static <K extends Comparable<K>> List<K> mergeSort(List<K> vals){
		if(vals.size() <= 1) {
			return vals;
		}
		int mid = vals.size()/2;
		List<K> firstHalf = mergeSort(vals.subList(0, mid));
		List<K> secondHalf = mergeSort(vals.subList(mid, vals.size()));
		List<K> result = new ArrayList<K>();
		int firstHalfIndex = 0;
		int secondHalfIndex = 0;
		while(firstHalfIndex < firstHalf.size() && secondHalfIndex < secondHalf.size()) {
			K first = firstHalf.get(firstHalfIndex);
			K second = secondHalf.get(secondHalfIndex);
			if(first.compareTo(second) >0) {
				result.add(second);
				secondHalfIndex++;
			}else {
				result.add(first);
				firstHalfIndex++;
			}
		}
		while(firstHalfIndex < firstHalf.size()) {
			result.add(firstHalf.get(firstHalfIndex));
			firstHalfIndex++;
		}
		while(secondHalfIndex < secondHalf.size()) {
			result.add(secondHalf.get(secondHalfIndex));
			secondHalfIndex++;
		}
	}
	
	public static class Pair implements Comparable<Pair> {
		int x,y;
		Pair(int x, int y){
			this.x =x;
			this.y = y;
		}
		@Override
		public int compareTo(Pair o) {
			if( x < o.x ) {
				return -1;
			}else if( x == o.x) {
				return 0;
			}else {
				return 1;
			}
		}
		public String toString() {
			return "x:"+x+"-y:" + y;
		}
	}
}

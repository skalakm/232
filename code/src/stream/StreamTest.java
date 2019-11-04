package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {

	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(6, 12, 1, 4, 5, 7, 0, 2));

		Stream<Integer> theStream = a.stream();

		// theStream.forEach(System.out::println);

		// theStream.forEach(StreamTest::printPlus2);
		//theStream.map(StreamTest::square).map(StreamTest::square).forEach(System.out::println);

		//theStream.forEach(StreamTest::square);
		// IntStream.range(0,10).forEach(System.out::println);
		//theStream.filter(StreamTest::isEven).forEach(System.out::println);
		IntStream.range(0,100).filter(StreamTest::isEven).filter(StreamTest::isDivisBy3)
		.forEach(System.out::println);
		IntStream.range(0,100).map(StreamTest::square).filter(StreamTest::isDivisBy3)
		.forEach(System.out::println);
		
		IntStream.range(0,100).filter(StreamTest::isDivisBy3).map(StreamTest::square)
		.forEach(System.out::println);
		List<Integer> divisibleBy6 = (List<Integer>) theStream.
				filter(StreamTest::isDivisBy3).filter(StreamTest::isEven)
				.collect( Collectors.toList());
		
		
		int result =IntStream.range(0,100).filter(StreamTest::isDivisBy3).map(StreamTest::square).
		reduce(0, StreamTest::add);

		System.out.println("sum of stuff " + result);
		System.out.println(divisibleBy6);
		result = IntStream.range(1, 100).filter(StreamTest::divisBy9).map(StreamTest::square)
			.reduce(1, StreamTest::product);
		

		System.out.println("product of stuff " + result);
		IntStream.range(1, 100).filter( s -> s%10== 0).forEach(System.out::println);;
				
		
		
	}
	public static int product(int a, int b) {
		return a*b;
	}
	
	public static boolean divisBy9(int i) {
		return i%9 == 0;
	}
	
	public static int add(int a, int b) {
		return a + b;
	}
	

	public static void printPlus2(Integer i) {
		System.out.println(i + 2);
	}

	public static int square(Integer i) {
		//System.out.println("squaring " + i);
		return i * i;
	}
	
	public static boolean isEven(int i) {
		if(i%2 == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean isDivisBy3(int i) {
		return i%3==0;
	}
	

}

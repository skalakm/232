package stream;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class LambdaExamples {

	public static void main(String[] args) {

		IntStream.range(0, 100).filter(LambdaExamples::divisBy2).forEach(System.out::println);

		IntStream.range(0, 100).filter((int i) -> {
			return i % 2 == 0;
		}).forEach(System.out::println);

		IntStream.range(0, 100).filter(i -> i % 2 == 0).forEach(System.out::println);

		System.out.println(IntStream.range(1, 100).filter(StreamTest::divisBy9).map(StreamTest::square).reduce(1,
				StreamTest::product));

		System.out.println(IntStream.range(1, 100).filter((i) -> {
			return i % 9 == 0;
		}).map((i) -> {
			return i * i;
		}).reduce(1, (a, b) -> {
			return a * b;
		}));

		System.out.println(IntStream.range(1, 100).filter((i) -> i % 9 == 0).map(i -> i * i).reduce((a, b) -> a * b));

		// want to make an ArrayList of primes
		IntStream.range(0, 1000).filter(s -> {
			for (int i = 2; i < s; ++i) {
				if (s % i == 0) {
					return false;
				}
			}
			return true;
		}).forEach(System.out::println);

		ArrayList<Integer> primes = new ArrayList<Integer>();
		IntStream.range(0, 100).filter(s -> {
			for (int i = 2; i < s; ++i) {
				if (s % i == 0) {
					return false;
				}
			}
			return true;
		}).forEach((e) -> primes.add(e));

		primes.stream().forEach(System.out::println);
		System.out.println("starting parrallel");
		primes.parallelStream().filter((s) -> (s % 4) == 1).forEach(System.out::println);

		primes.parallelStream().filter((s) -> (s % 4) == 1).forEach(System.out::println);

		ArrayList<LambdaExamples> list = new ArrayList<LambdaExamples>();
		IntStream.range(0, 10).forEach(s -> list.add(new LambdaExamples(s)));
		list.stream().map(s -> {
			s.x = s.x + 1;
			return s;
		}).forEach(s -> System.out.println(s.x));

		list.stream().forEach(s -> System.out.println(s.x));

		int result = IntStream.range(8, 301).filter(s -> {
			for (int i = 3; i < s; i = i + 2) {
				if (s % i == 0) {
					return false;
				}
			}
			return true;
		}).filter(s -> {
			return (s % 7 == 3) && (s % 9 == 4);
		}).reduce(0, (a, b) -> {
			System.out.println("adding " + a + " " + b);
			return a + b;
		});
		System.out.println(result);

		IntStream.range(8, 301).filter(s -> {
			for (int i = 3; i < s; i = i + 2) {
				if (s % i == 0) {
					return false;
				}
			}
			return true;
		}).filter(s -> {
			return (s % 7 == 3) && (s % 9 == 4);
		}).reduce((a, b) -> 
		
		{
			if(a > b) { return a;} else { return b;}
		}
		
				
				).ifPresent(System.out::println);
	}

	public static boolean divisBy2(int i) {
		return i % 2 == 0;
	}

	int x;

	public LambdaExamples(int myX) {
		x = myX;
	}
}

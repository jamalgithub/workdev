import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;

public class LambdaExpressionsTest {

	@Test
	public void sumOfOddNumbers_Usual() {
		List<Integer> numbers = Arrays.asList(1, 3, 4, 6, 2, 7);
		
		int sum = 0; 
		
		for (int number : numbers)
			if (number % 2 != 0)
				sum += number; 
		
		assertEquals(11, sum);
	}

	//No changes to state
	@Test
	public void sumOfOddNumbers_FunctionalProgrammingExample() {
		
		List<Integer> numbers = Arrays.asList(1, 3, 4, 6, 2, 7);
		//IntStream str = Arrays.stream(new int[] {1, 3, 4, 6, 2, 7});

		int sum = numbers.stream() // Create Stream
						//.filter(number -> (number % 2 != 0))
						.filter(LambdaExpressionsTest::isOdd) // Intermediate Operation
						//.reduce(0, (n1, n2) -> n1 + n2) 
						.reduce(0, Integer::sum); // Terminal Operation

		// number -> (number % 2 != 0) => Lambda Expression
		// Integer::sum => Method Reference
		// What is Functional Interface

		assertEquals(11, sum);
	}

	@Test
	public void lambdaExpression_predicate() {
		//List<Integer> numbers = Arrays.asList(1, 3, 4, 6, 2, 7);
		List<Integer> numbers = Arrays.asList(3, 1, 4, 1, 6, 1, 2, 7);
		numbers.stream()
				.filter((number) -> (number % 2 != 0)) //Predicate  // Intermediate Operation
				//.forEach(number -> System.out.print(number)); //Consumer
				.distinct() // Intermediate Operation
				.sorted()  // Intermediate Operation
				.forEach(System.out::print);  // Terminal Operation
		// 137 
	}
	
	static boolean isOdd(int number) {
		return number % 2 != 0;
	}
	
	int i = 1_000_000;
	//.map(String::toLowerCase)
	//.map(s -> String.toLowerCase(s))
}

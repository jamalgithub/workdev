package com.madhusudhan.j8.streams.commonops;

import java.util.IntSummaryStatistics;
import java.util.regex.Pattern;

/**
 * int, long, double ===> Int, Long, Double
 * @author jamal
 *
 */
public class Statistics {

	public static void dataAndMethodCalculation() {
		String limerick = "There was a young lady named Bright " + "who traveled much faster than light "
				+ "She set out one day " + "in a relative way " + "and came back the previous night ";

		IntSummaryStatistics statistics = 
				Pattern.compile(" ")
				.splitAsStream(limerick)
				//.peek(s -> System.out.printf("%s ",s))
				.mapToInt(word -> word.length())
				//.peek(i -> System.out.printf("%d ",i))
				.summaryStatistics();

		System.out.printf("\nNumber of words = %d" + "\nSum of the length of the words = %d"
						+ "\nMinimum word size = %d" + "\nMaximum word size %d" + "\nAverage word size = %f \n",
				statistics.getCount(), statistics.getSum(), statistics.getMin(), statistics.getMax(),
				statistics.getAverage());
	}

	public static void main(String[] args) {
		Statistics.dataAndMethodCalculation();
	}

}

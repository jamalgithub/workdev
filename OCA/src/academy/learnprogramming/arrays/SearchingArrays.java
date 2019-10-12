package academy.learnprogramming.arrays;

import java.util.Arrays;

/**
 * @author goran on 9/07/2017.
 */
public class SearchingArrays {

    public static void main(String[] args) {

        int[] numbers = {1, 3, 5, 6, 7};

        System.out.println(Arrays.binarySearch(numbers, 2));
        System.out.println(Arrays.binarySearch(numbers, 5));
        System.out.println(Arrays.binarySearch(numbers, 7));
        System.out.println(Arrays.binarySearch(numbers, 1));
        System.out.println(Arrays.binarySearch(numbers, 3));
        System.out.println(Arrays.binarySearch(numbers, 6));
        System.out.println(Arrays.binarySearch(numbers, 4));

        int[] notSortedNumbers = {5, 4, 10, 8, 6};
//        Arrays.sort(notSortedNumbers);

        System.out.println(Arrays.toString(notSortedNumbers));
        System.out.println(Arrays.binarySearch(notSortedNumbers, 5));
        System.out.println(Arrays.binarySearch(notSortedNumbers, 8));
        
        int[][][] threeDArray = {
                {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}},
                {{10, 11, 12}, {13, 14, 15}, {16, 17, 18}},
                {{19, 20, 21}, {22, 23, 24}, {25, 26, 27}}
        };
        
        //Arrays.sort(threeDArray);
        System.out.println(threeDArray);
        System.out.println(Arrays.toString(threeDArray));
        System.out.println(Arrays.deepToString(threeDArray));
        
    }
}

package academy.learnprogramming.arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author goran on 11/07/2017.
 */
public class ListArrayConversion {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Tony");
        names.add("Jimmy");
        names.add("Anthony");

        Object[] namesArray = names.toArray();
        System.out.println(namesArray.length);
        namesArray[0] = "Adil";
        System.out.println(Arrays.toString(namesArray)); // [Adil, Jimmy, Anthony]
        System.out.println(names); // [Tony, Jimmy, Anthony]

        String[] stringArray = names.toArray(new String[0]);
        stringArray[0] = "Alae";
        System.out.println(Arrays.toString(stringArray));
        System.out.println(names);

        String[] anotherStringArray = names.toArray(new String[names.size()]);

        String[] petsArray = {"dog", "cat", "parrot"};
//        List<String> petsList = Arrays.asList(petsArray);
        List<String> petsList = Arrays.asList(petsArray); // returns fixed size list
        System.out.println(petsList.size());
        
//      petsList.add("newDog"); // UnsupportedOperationException
//      petsList.remove(1); // UnsupportedOperationException

        petsList.set(0, "bird");
        System.out.println(petsList);
        System.out.println(Arrays.toString(petsArray));

        petsArray[0] = "husky";
        System.out.println(petsList);
        System.out.println(Arrays.toString(petsArray));

        List<String> list = Arrays.asList("one", "two", "three");
        System.out.println(list);
//        list.add("four");
    }
}

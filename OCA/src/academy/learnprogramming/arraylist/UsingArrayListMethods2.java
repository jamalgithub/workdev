package academy.learnprogramming.arraylist;

import java.util.ArrayList;
import java.util.List;

/**
 * @author goran on 11/07/2017.
 */
public class UsingArrayListMethods2 {

    public static void main(String[] args) {
        List<String> pets = new ArrayList<>();

        System.out.println(pets.isEmpty());
        System.out.println(pets.size());

        if(pets.isEmpty()) {
            System.out.println("no pets");
        }

        if(pets.size() == 0) {
            System.out.println("no pets");
        }

        pets.add("cat");
        System.out.println(pets.isEmpty());
        System.out.println(pets.size());

        pets.clear();
        System.out.println(pets.isEmpty());
        System.out.println(pets.size());

        pets.add("dog");
        System.out.println(pets.contains("cat")); // false
        System.out.println(pets.contains("dog")); // true

        List<String> newPets = new ArrayList<>();
        newPets.add(new String("dog"));

        System.out.println(pets.equals(newPets));

        newPets.add("cat");
        System.out.println(pets.equals(newPets));
        //System.out.println(pets==newPets);

        pets.add(0, "cat");
        System.out.println(pets);
        System.out.println(newPets);

        // size and elements are equal but order of elements is not equal
        System.out.println(pets.equals(newPets));
    }
}

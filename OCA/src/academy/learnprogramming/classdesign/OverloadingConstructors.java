package academy.learnprogramming.classdesign;

/**
 * @author goran on 14/07/2017.
 */

class Dog3 {
    private String name;
    private String breed;
    private double weight;

    public Dog3(String name) {
//        this.name = name;
//        breed = "husky";
//        weight = 30.0;

//        Dog(name, "husky"); // does not compile
//        new Dog(name, "husky"); // compiles but does not do what we want
//        System.out.println("constructor 1");
        this(name, "husky");
        System.out.println("constructor 1");
    }

    public Dog3(String name, String breed) {
//        this.name = name;
//        this.breed = breed;
//        weight = 30.0;
        this(name, breed, 30.0);
        System.out.println("constructor 2");
    }

    public Dog3(String name, String breed, double weight) {
        this.name = name;
        this.breed = breed;
        this.weight = weight;
        System.out.println("constructor 3");
    }

    public void print() {
        System.out.println(name + " " + breed + " " + weight);
    }
}

public class OverloadingConstructors {

    public static void main(String[] args) {
        Dog3 dog1 = new Dog3("Jimmy");
        dog1.print();

        Dog3 dog2 = new Dog3("Anthony", "shepard");
        dog2.print();

        Dog3 dog3 = new Dog3("Rex", "german shepard", 40);
        dog3.print();
    }
}

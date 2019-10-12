package academy.learnprogramming.classdesign;

/**
 * @author goran on 14/07/2017.
 */

class Dog1 {

    private String color;

//    public Dog(String color) {
//        System.out.println("constructor");
//        this.color = color;
//    }

    public void printColor() {
        System.out.println("color= " + color);
    }

//    public dog() {}
//    public void Dog() {} // not constructor since it has return type
}

class Cat1 {
    private String color;
    private int height;
    private int length;

    public Cat1(int length, int theHeight) {
//        length = this.length;
        this.length = length;
        height = theHeight;
        color = "white";
    }

    public void printInfo() {
        System.out.println("Cat length= " + this.length + " height= " + height + " color= " + color);
    }
}

public class ClassConstructors {

    public static void main(String[] args) {
//        Dog dog = new Dog("gray");
//        dog.printColor();

        Cat1 cat = new Cat1(10, 12);
        cat.printInfo();
    }
}

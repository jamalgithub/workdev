package academy.learnprogramming.classdesign;

/**
 * @author goran on 18/07/2017.
 */
public interface Walk {

    default int getSpeed() {
        return 5;
    }
}

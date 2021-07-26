package finalSection;//like javascript!!!!

import java.util.function.Consumer;

public class Callbacks {
    public static void main(String[] args) {

        hello("John", "Doe", null);
        hello("Alex", null, value -> {
            System.out.println("no lastName provided for " + value);//value is firstName.
        });

        hello2("Arnold", null,
                () -> {
                    System.out.println("no lastName provided");
                });

    }

    static void hello(String firstName, String lastName, Consumer<String> callback) {//a function as a parameter
        System.out.println(firstName);
        if (lastName != null) {
            System.out.println(lastName);
        } else {
            callback.accept(firstName);
        }
    }

    //runnable as a parameter
    static void hello2(String firstName, String lastName, Runnable callback) {//a function as a parameter
        System.out.println(firstName);
        if (lastName != null) {
            System.out.println(lastName);
        } else {
            callback.run();
        }
    }


}
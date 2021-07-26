package finalSection;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Lambdas {

    public static void main(String[] args) {

        Function<String, String> upperCaseName = name -> name.toUpperCase(); // only one input (before de arrow) and one output after the arrow

        BiFunction<String, Integer, String> upperCaseName2 = (name, age) -> { //(name, age) -> is THE lambda
            if(name.isBlank()) throw new IllegalArgumentException("");
            System.out.println(age);
            return name.toUpperCase();
        };

        System.out.println(upperCaseName2.apply("Alex",20));
    }
}

package functionalInterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {
        //Function example
        int increment = incrementByOneFunction.apply(1);
        System.out.println(increment);

        int multiplyResult = multiplyBy10Function.apply(increment);
        System.out.println(multiplyResult);

        Function<Integer, Integer> add1AndThenMultiplyBy10 =
                incrementByOneFunction.andThen(multiplyBy10Function);

        multiplyResult = add1AndThenMultiplyBy10.apply(multiplyResult);
        System.out.println(multiplyResult);

        System.out.println("BiFunction");
        System.out.println(incrementByOneAndMultiplyBiFunction.apply(4,100));

    }

    static Function<Integer, Integer> incrementByOneFunction =
            number -> number + 1;

    static Function<Integer, Integer> multiplyBy10Function =
            number -> number * 10;

    //imperativo
    static int incrementByOneAndMultiply(int number, int numToMultiplyBy){
        return (number + 1) * numToMultiplyBy;
    }

    //BiFunction two arguments!!
    static BiFunction <Integer, Integer, Integer> incrementByOneAndMultiplyBiFunction =
            (numberToIncrementByOne, numberToMultiplyBy) -> (numberToIncrementByOne +1) * numberToMultiplyBy;

}

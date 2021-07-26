package functionalInterface;

import org.w3c.dom.ls.LSOutput;

import java.util.function.Predicate;

public class _Predicate {
    public static void main(String[] args) {
        System.out.println("Imperative functions");
        System.out.println(isPhoneNumberValid("07000000000"));
        System.out.println(isPhoneNumberValid("09009877321"));
        System.out.println(isPhoneNumberValid("0900921"));


        System.out.println("Predicate");
        System.out.println(isPhoneNumberValidPredicate.test("07000000000"));
        System.out.println(isPhoneNumberValidPredicate.test("09009877321"));
        System.out.println(isPhoneNumberValidPredicate.test("0900921"));

        System.out.println("Phone number valid, and contains number three: "+
                isPhoneNumberValidPredicate.and(containsNumberThree).test("07000000000"));

        System.out.println("Phone number valid, and contains number three: "+
                isPhoneNumberValidPredicate.and(containsNumberThree).test("07009877321"));

        System.out.println("Phone number valid, and contains number three: "+
                isPhoneNumberValidPredicate.and(containsNumberThree).test("0900921"));

    }


    //imperative
    static boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.startsWith("07") && phoneNumber.length() == 11;
    }

    //Predicate
    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber ->
            phoneNumber.startsWith("07") && phoneNumber.length() == 11;

    static Predicate<String> containsNumberThree = phoneNumber ->
            phoneNumber.contains("3");

}

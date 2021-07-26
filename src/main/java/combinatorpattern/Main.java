package combinatorpattern;

import java.time.LocalDate;

import static combinatorpattern.CustomerRegistrationValidator.*;

public class Main {
    public static void main(String[] args) {

        Customer customer = new Customer(
                "Alice",
                "alice@gmail.com",
                "+022353433",
                LocalDate.of(2015,1,1)
        );

        //System.out.println(new CustomerValidatorService().isValid(customer));

        //combinator permits chaining of functions
        //Using combinator pattern
        ValidationResult result = isEmailValid()
                .and(isPhoneNumberValid())
                .and(isAdult())
                .apply(customer);//previous methods are "lazy", you need apply to apply the function to the customer.

        System.out.println(result);

        if (result != ValidationResult.SUCCESS){
            throw new IllegalStateException(result.name());
        }
    }

}

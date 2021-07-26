package functionalInterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {
    public static void main(String[] args) {
        System.out.println("Imperative");
        Customer flor = new Customer("Flor","666");
        greetCustomer(flor);

        //Consumer functional interface
        System.out.println("Declarative");
        greetCustomerConsumer.accept(flor);
        greetCustomerBiConsumer.accept(flor,false);


    }

    //imperative method
    static void greetCustomer(Customer customer){
        System.out.println("Hello"+ customer.customerName + ", thanks for registering phone number " + customer.customerPhoneNumber);
    }

    //declarative
    static Consumer<Customer> greetCustomerConsumer = customer ->
            System.out.println("Hello " + customer.customerName
                    +", thanks for registering your phone number "
                    + customer.customerPhoneNumber  );

    //BiConsumer showPhone
    static BiConsumer<Customer, Boolean> greetCustomerBiConsumer = (customer, showPhone) ->
            System.out.println("Hello " + customer.customerName
                    +", thanks for registering your phone number "
                    + (showPhone ? customer.customerPhoneNumber : "***************" ));


    static class Customer {
        private final String customerName;
        private final String customerPhoneNumber;

        Customer(String customerName, String customerPhoneNumber) {
            this.customerName = customerName;
            this.customerPhoneNumber = customerPhoneNumber;
        }
    }
}

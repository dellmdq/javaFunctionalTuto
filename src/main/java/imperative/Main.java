package imperative;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> personList = List.of(
                new Person("Erik", Gender.MALE),
                new Person("Pepe",Gender.MALE),
                new Person("Marcela",Gender.FEMALE),
                new Person("Tito",Gender.MALE),
                new Person("Marcelo",Gender.MALE),
                new Person("Flor",Gender.FEMALE),
                new Person("Fabi",Gender.MALE));

        //System.out.println(personList);

        //Imperative
        System.out.println("Imperative");
        List<Person> maleList = new ArrayList<>();
        for (Person person: personList) {
            if(Gender.MALE.equals(person.gender)){
                maleList.add(person);
            }
        }
        //System.out.println(maleList);
        for (Person male : maleList) {
            System.out.println(male);
        }

        //Declarative stream(), filter(), forEach() collect()
        System.out.println("Declarative way.");
        System.out.println("Showing filtered list");
        personList.stream()
                .filter(person -> Gender.MALE.equals(person.gender))
                .forEach(System.out::println);

        System.out.println("Creating, filtering and showing list with declarative programming.");
        List<Person> femaleList = personList.stream()
                .filter(person -> Gender.FEMALE.equals(person.gender))
                .collect(Collectors.toList());
        femaleList.forEach(System.out::println);



    }//fin main static


    //----------------
    static class Person {
        private final String name;
        private final Gender gender;

        Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender {
        MALE, FEMALE
    }
}

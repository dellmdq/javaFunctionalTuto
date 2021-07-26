package streams;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static streams._Stream.Gender.*;

public class _Stream {
    public static void main(String[] args) {
        List<Person> personList = List.of(
                new Person("Erik", MALE),
                new Person("Pepe", MALE),
                new Person("Marcela", FEMALE),
                new Person("Tito", MALE),
                new Person("Marcelo", MALE),
                new Person("Flor", FEMALE),
                new Person("Adrian", PREFER_NOT_TO_SAY),
                new Person("Fabi", MALE)
        );

    //    personList.stream()
      //          .map(person -> person.gender)//gets genres
        //        .collect(Collectors.toSet())//puts them in a set so there no duplicates
          //      .forEach(System.out::println);


        //looking for females. I know it sounds wrong!!!
        Predicate<Person> personPredicate = person -> FEMALE.equals(person.gender);
        Predicate<Person> personPredicatePNTS = person -> PREFER_NOT_TO_SAY.equals(person.gender);


        boolean containsOnlyFemales = personList.stream()
                .allMatch(personPredicate);

        System.out.println(containsOnlyFemales);

        boolean containsAtLeastOneFemale = personList.stream()
                .anyMatch(personPredicate);

        System.out.println(containsAtLeastOneFemale);

        boolean notContainPreferNotToSayGender = personList.stream()
                .noneMatch(personPredicatePNTS);

        System.out.println(notContainPreferNotToSayGender);


    }//fin main

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
        MALE, FEMALE, PREFER_NOT_TO_SAY
    }
}

package com.softserveinc.ddob.stream;

import com.softserveinc.ddob.model.Person;

import java.util.Arrays;
import java.util.List;

public class AnotherIntermediateOperationsExample {
    public static void main(String[] args) {
        List<Person> personList = Arrays.asList(
                new Person("John", 18),
                new Person("Kate", 21),
                new Person("Ann", 15),
                new Person("Tim", 15),
                new Person("Jim", 12),
                new Person("Jack", 22),
                new Person("Jane", 49),
                new Person("Tim", 43),
                new Person("Susan", 34),
                new Person("Kate", 23),
                new Person("Jim", 42)
        );

        personList
                .stream()
                .map(Person::getName)
                .distinct()
                .sorted()
                .forEach(System.out::println);
    }
}

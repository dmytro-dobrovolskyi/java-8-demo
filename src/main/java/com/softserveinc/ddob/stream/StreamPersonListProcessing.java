package com.softserveinc.ddob.stream;

import com.softserveinc.ddob.model.Person;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamPersonListProcessing {
    public static void main(String[] args) {
        List<Person> personList = Arrays.asList(
                new Person("John", 18),
                new Person("Jim", 21),
                new Person("Kate", 15),
                new Person("Василь", 12),
                new Person("Петро", 49),
                new Person("Орест", 34)
        );

        List<String> adultNames = personList
                .stream()    // Returns the Stream instance
                .filter(person -> person.getAge() > 18)    // Takes Predicate<Person> as parameter
                .map(Person::getName)    // Takes Function<Person, String> as parameter
                .collect(Collectors.toList());    // Returns results list

        System.out.println(adultNames);
    }
}

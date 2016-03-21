package com.softserveinc.ddob.stream;

import com.softserveinc.ddob.model.Person;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

public class FlatMapExample {
    public static void main(String[] args) {
        List<Person> personList = Arrays.asList(
                new Person("John", 18),
                new Person("Kate", 21),
                new Person("Ann", 15),
                new Person("Tim", 19)
        );

        personList
                .forEach(person -> IntStream
                        .range(0, 3)
                        .forEach(index -> person.addPhoneNumber(
                                String.valueOf(UUID.randomUUID().getMostSignificantBits())
                        ))
                );

        personList
                .stream()
                .flatMap(person -> person.getPhoneNumbers().stream())
                .forEach(System.out::println);
    }
}

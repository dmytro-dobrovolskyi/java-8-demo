package com.softserveinc.ddob.stream;

import com.softserveinc.ddob.model.Person;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class SimpleStream {
    public static Stream<Person> personStream() {
        return Stream.of(
                new Person("John"),
                new Person("Jim"),
                new Person("Kate")
        );
    }

    public static Stream<Person> personStreamFromList() {
        List<Person> personList = Arrays.asList(
                new Person("John"),
                new Person("Jim"),
                new Person("Kate")
        );

        return personList.stream();
    }
}

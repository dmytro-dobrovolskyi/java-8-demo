package com.softserveinc.ddob.stream;

import com.softserveinc.ddob.model.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ForeachLoopPersonListProcessing {
    public static void main(String[] args) {
        List<Person> personList = Arrays.asList(
                new Person("John", 18),
                new Person("Jim", 21),
                new Person("Kate", 15),
                new Person("Василь", 12),
                new Person("Петро", 49),
                new Person("Орест", 34)
        );

        List<String> adultNames = new ArrayList<>();

        for (Person person : personList) {
            if (person.getAge() > 18) {
                adultNames.add(person.getName());
            }
        }

        System.out.println(adultNames);
    }
}

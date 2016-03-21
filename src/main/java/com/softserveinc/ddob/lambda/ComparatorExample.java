package com.softserveinc.ddob.lambda;

import com.softserveinc.ddob.model.Person;

import java.util.Comparator;

public class ComparatorExample {
    public static Comparator<Person> personByAgeComparator() {
        return (firstPerson, secondPerson) -> {
            int firstPersonAge = firstPerson.getAge();
            int secondPersonAge = secondPerson.getAge();

            return firstPersonAge - secondPersonAge;
        };
    }

    public static Comparator<Person> personByAgeComparatorAnonymous() {
        return new Comparator<Person>() {
            @Override
            public int compare(Person firstPerson, Person secondPerson) {
                int firstPersonAge = firstPerson.getAge();
                int secondPersonAge = secondPerson.getAge();

                return firstPersonAge - secondPersonAge;
            }
        };
    }
}

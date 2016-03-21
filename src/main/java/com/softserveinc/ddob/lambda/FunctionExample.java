package com.softserveinc.ddob.lambda;

import com.softserveinc.ddob.model.Person;

import java.util.function.Function;

public class FunctionExample {
    public static Function<Person, String> toNameLambda() {
        return person -> person.getName();
    }

    public static Function<Person, String> toNameAnonymous() {
        return new Function<Person, String>() {
            @Override
            public String apply(Person person) {
                return person.getName();
            }
        };
    }

    public static Function<Person, String> toNameMethodReference() {
        return Person::getName;
    }

    public static Function<String, Person> toPersonMethodReference() {
        return Person::new;
    }
}

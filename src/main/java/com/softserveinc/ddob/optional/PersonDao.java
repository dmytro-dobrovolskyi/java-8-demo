package com.softserveinc.ddob.optional;

import com.softserveinc.ddob.model.Person;

import java.util.Optional;

public interface PersonDao {
    Person findByNameClassic(String name);

    Optional<Person> findByNameOptional(String name);
}

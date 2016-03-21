package com.softserveinc.ddob.model;

import com.sun.istack.internal.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString(of = "name")
public class Person {
    @NotNull
    private final String name;
    private final List<String> phoneNumbers = new ArrayList<>();

    private int age;

    @Setter
    private DriverLicense driverLicense;


    public Person(String name) {
        this.name = name;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void addPhoneNumber(String phoneNumber) {
        phoneNumbers.add(phoneNumber);
    }
}

package com.softserveinc.ddob.lambda.decompilation;

import com.softserveinc.ddob.functionalinterface.Applier;
import com.softserveinc.ddob.model.Person;

public class App {
    public static void main(String[] args) {
        Applier<Person> personApplier = something -> System.out.println("Applying " + something + "... Done!");

        personApplier.apply(new Person("Name"));
    }
}


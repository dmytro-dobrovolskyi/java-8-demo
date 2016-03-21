package com.softserveinc.ddob.functionalinterface;

@FunctionalInterface
public interface Applier<T> {
    void apply(T something);
}

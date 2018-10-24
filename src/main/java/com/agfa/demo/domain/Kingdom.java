package com.agfa.demo.domain;

public interface Kingdom {

    String type();
    boolean isAnimal();
    boolean is(String type);
    Kingdom giveName(String name);

    String printString();
}

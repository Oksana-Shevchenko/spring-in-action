package com.spring.webFlow.pizza;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import static org.apache.commons.lang.WordUtils.*;

public enum Topping implements Serializable {

    MUSHROOM, PINEAPPLE, TOMATO, ONION, BEACON;

    public static List<Topping> asList() {
        Topping[] all = Topping.values();
        return Arrays.asList(all);
    }

    @Override
    public String toString() {
        return capitalizeFully(name().replace('_',' '));
    }
}

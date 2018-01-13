package org.jdcoffre.mlc.lib.data;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Cellar {

    private String name;
    private List<Bottle> bottles = new ArrayList<>();

    public Cellar(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addBottle(Bottle bottle) {
        bottles.add(bottle);
    }

    public Collection<Bottle> getBottles() {
        return bottles;
    }
}


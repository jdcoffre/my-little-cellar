package org.jdcoffre.mlc.server.api;


public class Cellar {

    private final Shelf[] shelfves ;
    private String name;

    public Cellar(final Integer high, final Integer width) {
        shelfves = new Shelf[high];
        for(int i = 0 ; i < high ; i++){
            shelfves[i] = new Shelf(width);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private class Shelf {
        private final String[] bottles;

        private Shelf(final Integer width) {
            bottles = new String[width];
        }
    }
}

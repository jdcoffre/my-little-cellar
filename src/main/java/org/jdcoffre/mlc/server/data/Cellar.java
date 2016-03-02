package org.jdcoffre.mlc.server.data;


public class Cellar {

    private final Shelf[] shelfves ;
    private final Integer high;
    private final Integer width;
    private String name;

    public Cellar(final Integer high, final Integer width) {
        this.high = high;
        this.width = width;
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

    public Integer getHigh() {
        return high;
    }

    public Integer getWidth() {
        return width;
    }
    

    public Shelf getShelve(Integer high) {
        return shelfves[high];
    }

    public class Shelf {
        private final Bottle[] bottles;

        private Shelf(final Integer width) {
            bottles = new Bottle[width];
        }

        public Bottle getBottle(int i) {
            return bottles[i];
        }

        public void setBottle(int i, Bottle bottle) {
            bottles[i] = bottle;
        }
    }
}

package org.jdcoffre.mlc.server.api;

public class Cellar {

    private String name;

    public Cellar(){
        // Jackson deserialization
    }

    public Cellar(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

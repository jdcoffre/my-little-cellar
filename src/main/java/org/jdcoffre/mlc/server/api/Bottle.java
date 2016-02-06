package org.jdcoffre.mlc.server.api;

import org.hibernate.validator.constraints.NotEmpty;

public class Bottle {

    @NotEmpty
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

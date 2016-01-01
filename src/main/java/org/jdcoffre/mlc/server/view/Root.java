package org.jdcoffre.mlc.server.view;


import io.dropwizard.views.View;

public class Root extends View {

    private static final String FREEMARKER_SOURCE = "root.ftl";

    public Root() {
        super(FREEMARKER_SOURCE);
    }
}

package org.jdcoffre.mlc.desktop.cellar;

import javafx.scene.control.Label;

public class CellarLabel extends Label {

    public static final String ID = "cellar-label";

    public CellarLabel (){
        super("Cellar :");
        setId(ID);
    }
}

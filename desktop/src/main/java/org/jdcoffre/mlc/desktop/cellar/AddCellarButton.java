package org.jdcoffre.mlc.desktop.cellar;

import javafx.scene.control.Button;

public class AddCellarButton extends Button {

    public static final String ID = "add-cellar-button";

    AddCellarButton(final CellarPane rootPane){
        super("+");

        setId(ID);
        setOnAction(rootPane);
    }


}

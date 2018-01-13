package org.jdcoffre.mlc.desktop;

import javafx.scene.control.Button;

public class AddCellarButton extends Button {

    public static final String ADD_CELLAR_BUTTON = "add-cellar";

    AddCellarButton(){
        super("+");
        setId(ADD_CELLAR_BUTTON);
    }
}

package org.jdcoffre.mlc.desktop.cellar;

import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class ErrorMessageArea extends Text {

    public static final String ID = "cellar-error-area";

    ErrorMessageArea(){
        super();

        setId(ID);
        setFill(Color.FIREBRICK);
    }

}

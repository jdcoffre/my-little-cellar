package org.jdcoffre.mlc.desktop;

import javafx.scene.layout.StackPane;

public class RootPane extends StackPane {

    RootPane(){
        super();
        getChildren().add(new AddCellarButton());
    }

}

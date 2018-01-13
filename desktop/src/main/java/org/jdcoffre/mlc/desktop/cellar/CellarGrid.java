package org.jdcoffre.mlc.desktop.cellar;

import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;

public class CellarGrid extends GridPane {

    public CellarGrid(CellarPane cellarPane){
        super();

        setHgap(10);
        setVgap(10);
        setPadding(new Insets(10, 10, 10, 10));

        add(new CellarLabel(), 0,0);
        add(new CellarDropDown(), 1,0);
        add(new AddCellarField(), 2, 0);
        add(new AddCellarButton(cellarPane), 3, 0);
    }
}

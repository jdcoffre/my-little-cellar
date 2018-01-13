package org.jdcoffre.mlc.desktop.cellar;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

import java.util.List;

public class CellarDropDown extends ComboBox{

    public static final String ID = "cellar-dropdown";

    CellarDropDown(){
        super();
        setId(ID);
    }

    void setAvailableCellars(List<String> cellars){
        ObservableList<String> options = FXCollections.observableArrayList(cellars);
        getItems().setAll(options);
    }
}

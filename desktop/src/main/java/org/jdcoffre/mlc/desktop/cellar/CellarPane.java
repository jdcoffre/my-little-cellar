package org.jdcoffre.mlc.desktop.cellar;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import org.jdcoffre.mlc.desktop.Controller;

public class CellarPane extends GridPane implements EventHandler<ActionEvent> {

    private final Controller controller;

    public CellarPane(final Controller controller){
        super();

        this.controller = controller;

        setAlignment(Pos.CENTER);
        setHgap(10);
        setVgap(10);
        setPadding(new Insets(25, 25, 25, 25));

        add(new CellarLabel(), 0,0);
        add(new CellarField(), 1, 0);
        add(new AddCellarButton(this), 2, 0);
    }

    @Override
    public void handle(ActionEvent event) {
        CellarField cellarField = (CellarField) lookup("#" + CellarField.ID);
        controller.addCellar(cellarField.getText());
    }
}

package org.jdcoffre.mlc.desktop.cellar;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import org.jdcoffre.mlc.desktop.Controller;
import org.jdcoffre.mlc.lib.MLCExecption;

public class CellarPane extends GridPane implements EventHandler<ActionEvent> {

    private final Controller controller;

    public CellarPane(final Controller controller){
        super();

        this.controller = controller;

        setPadding(new Insets(10, 10, 10, 10));
        add(new ErrorMessageArea(), 0, 0);

        GridPane fieldsArea  = new GridPane();
        fieldsArea.setHgap(10);
        fieldsArea.setVgap(10);
        fieldsArea.setPadding(new Insets(10, 10, 10, 10));
        fieldsArea.add(new CellarLabel(), 0,0);
        fieldsArea.add(new CellarField(), 1, 0);
        fieldsArea. add(new AddCellarButton(this), 2, 0);
        add(fieldsArea, 0, 1);
    }

    @Override
    public void handle(ActionEvent event) {
        ErrorMessageArea errorMessage = (ErrorMessageArea) lookup("#" + ErrorMessageArea.ID);
        errorMessage.setText("");
        try {
            CellarField cellarField = (CellarField) lookup("#" + CellarField.ID);
            controller.addCellar(cellarField.getText());
        } catch (MLCExecption mlcExecption) {
            errorMessage.setText(mlcExecption.getMessage());
        }
    }
}

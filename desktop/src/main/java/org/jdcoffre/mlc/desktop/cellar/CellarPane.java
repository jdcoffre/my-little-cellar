package org.jdcoffre.mlc.desktop.cellar;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.layout.FlowPane;
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
        add(new CellarGrid(this), 0, 1);

        updateDropDown();

    }

    @Override
    public void handle(ActionEvent event) {
        ErrorMessageArea errorMessage = (ErrorMessageArea) lookup("#" + ErrorMessageArea.ID);
        errorMessage.setText("");
        try {
            AddCellarField cellarField = (AddCellarField) lookup("#" + AddCellarField.ID);
            controller.addCellar(cellarField.getText());
            updateDropDown();
        } catch (MLCExecption mlcExecption) {
            errorMessage.setText(mlcExecption.getMessage());
        }
    }

    private void updateDropDown(){
        CellarDropDown cellarDropDown = (CellarDropDown) lookup("#" + CellarDropDown.ID);
        cellarDropDown.setAvailableCellars(controller.getCellarNames());
    }
}

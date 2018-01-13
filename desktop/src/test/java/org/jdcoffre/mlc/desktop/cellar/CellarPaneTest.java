package org.jdcoffre.mlc.desktop.cellar;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import org.jdcoffre.mlc.desktop.Controller;
import org.jdcoffre.mlc.lib.MLCExecption;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.isA;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.base.NodeMatchers.hasText;

public class CellarPaneTest extends ApplicationTest {

    private static final Controller controller = mock(Controller.class);

    @Override
    public void start(Stage stage) {
        Parent sceneRoot = new CellarPane(controller);
        Scene scene = new Scene(sceneRoot, 500, 100);
        stage.setScene(scene);
        stage.show();
    }

    @Test
    public void validateContentOfCellarPane(){
        verifyThat("#" + AddCellarButton.ID, isA(AddCellarButton.class));
        verifyThat("#" + AddCellarField.ID, isA(AddCellarField.class));
        verifyThat("#" + CellarLabel.ID, isA(CellarLabel.class));
        verifyThat("#" + ErrorMessageArea.ID, isA(ErrorMessageArea.class));
        verifyThat("#" + CellarDropDown.ID, isA(CellarDropDown.class));
    }


    @Test
    public void inCaseOfErrorMessageIsDisplayedInCorrespondingArea() throws MLCExecption {
        verifyThat("#" + ErrorMessageArea.ID, hasText(""));
        String errorMessage = "you are not allowed to do this";
        doThrow(new MLCExecption(errorMessage)).when(controller).addCellar(any(String.class));
        clickOn("#" + AddCellarButton.ID);

        verifyThat("#" + ErrorMessageArea.ID, hasText(errorMessage));

        reset(controller);
        clickOn("#" + AddCellarButton.ID);
        verifyThat("#" + ErrorMessageArea.ID, hasText(""));
    }

    @Test
    public void cellarNamesLoadedInDropDown(){
        List<String> cellars = new ArrayList<>();
        cellars.add("Cellar1");
        when(controller.getCellarNames()).thenReturn(cellars);


        clickOn("#" + AddCellarButton.ID);
        verifyThat("#" + CellarDropDown.ID, (ComboBox<String> c) -> c.getItems().contains("Cellar1"));
        reset(controller);
    }

}
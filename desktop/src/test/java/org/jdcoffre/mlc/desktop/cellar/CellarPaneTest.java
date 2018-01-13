package org.jdcoffre.mlc.desktop.cellar;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.jdcoffre.mlc.desktop.Controller;
import org.jdcoffre.mlc.lib.MLCExecption;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import static org.hamcrest.CoreMatchers.isA;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.base.NodeMatchers.hasText;

public class CellarPaneTest extends ApplicationTest {

    private static final Controller controller = mock(Controller.class);

    @Override
    public void start(Stage stage) {
        Parent sceneRoot = new CellarPane(controller);
        Scene scene = new Scene(sceneRoot, 400, 100);
        stage.setScene(scene);
        stage.show();
    }

    @Test
    public void validateContentOfCellarPane(){
        verifyThat("#" + AddCellarButton.ID, isA(AddCellarButton.class));
        verifyThat("#" + CellarField.ID, isA(CellarField.class));
        verifyThat("#" + CellarLabel.ID, isA(CellarLabel.class));
        verifyThat("#" + ErrorMessageArea.ID, isA(ErrorMessageArea.class));
    }

    @Test
    public void addCellarNameShouldCallRelatedControllerMethod() throws MLCExecption {
        String cellarName = "addCellarNameTest";
        point("#" + CellarField.ID);
        write(cellarName);
        clickOn("#" + AddCellarButton.ID);

        verify(controller, times(1)).addCellar(cellarName);
    }

    @Test
    public void InCaseOfErrorMessageIsDisplayedInCorrespondingArea() throws MLCExecption {
        verifyThat("#" + ErrorMessageArea.ID, hasText(""));
        String errorMessage = "you are not allowed to do this";
        doThrow(new MLCExecption(errorMessage)).when(controller).addCellar(any(String.class));
        String cellarName = "addCellarNameTest";
        point("#" + CellarField.ID);
        write(cellarName);
        clickOn("#" + AddCellarButton.ID);

        verifyThat("#" + ErrorMessageArea.ID, hasText(errorMessage));
        reset(controller);
    }

}
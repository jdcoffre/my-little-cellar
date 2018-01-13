package org.jdcoffre.mlc.desktop.cellar;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.jdcoffre.mlc.desktop.Controller;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import static org.hamcrest.CoreMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.testfx.api.FxAssert.verifyThat;

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
    }

    @Test
    public void addCellarNameShouldCallRelatedControllerMethod(){
        String cellarName = "addCellarNameTest";
        point("#" + CellarField.ID);
        write(cellarName);
        clickOn("#" + AddCellarButton.ID);

        verify(controller, times(1)).addCellar(cellarName);
    }

}
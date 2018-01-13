package org.jdcoffre.mlc.desktop.cellar;


import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.jdcoffre.mlc.lib.MLCExecption;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class CellarGridTest extends ApplicationTest{

    private static final CellarPane cellarPane = mock(CellarPane.class);

    @Override
    public void start(Stage stage) {
        Parent sceneRoot = new CellarGrid(cellarPane);
        Scene scene = new Scene(sceneRoot, 500, 50);
        stage.setScene(scene);
        stage.show();
    }

    @Test
    public void addCellarNameShouldCallRelatedControllerMethod() throws MLCExecption {
        String cellarName = "addCellarNameTest";
        point("#" + AddCellarField.ID);
        write(cellarName);
        clickOn("#" + AddCellarButton.ID);

        verify(cellarPane, times(1)).handle(any());
    }

}
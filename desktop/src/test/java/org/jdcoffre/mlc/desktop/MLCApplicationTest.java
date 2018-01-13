package org.jdcoffre.mlc.desktop;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.testfx.api.FxAssert.verifyThat;

public class MLCApplicationTest extends ApplicationTest {

    @Override
    public void start(Stage stage) {
        Parent sceneRoot = new RootPane();
        Scene scene = new Scene(sceneRoot, 100, 100);
        stage.setScene(scene);
        stage.show();
    }

    @Test
    public void applicationShouldContainAddCellarButton(){
        verifyThat(AddCellarButton.ADD_CELLAR_BUTTON, notNullValue());
    }

}
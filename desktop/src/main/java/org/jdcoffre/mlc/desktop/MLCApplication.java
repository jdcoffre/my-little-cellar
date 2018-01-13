package org.jdcoffre.mlc.desktop;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MLCApplication extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {
        final Scene scene = new Scene(new RootPane(), 300, 250);

        primaryStage.setTitle("My Little Cellar");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

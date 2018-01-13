package org.jdcoffre.mlc.desktop;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.jdcoffre.mlc.desktop.cellar.CellarPane;
import org.jdcoffre.mlc.lib.MyLittleCellar;

public class MLCApplication extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        final MyLittleCellar mlc = new MyLittleCellar();
        final Controller controller = new Controller(mlc);
        final Scene scene = new Scene(new CellarPane(controller), 400, 250);

        primaryStage.setTitle("My Little Cellar");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

package NotUsed;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

    private Scene scene;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        AnchorPane root = (AnchorPane) Loader.getMenu();
        scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Traffic Optimizer");
        primaryStage.show();

    }
}

package NotUsed;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class Loader {

    private static Loader ourInstance = new Loader();

    private Parent menu;
    private Parent newRoadObject;

    public static Loader getInstance() {
        return ourInstance;
    }

    private Loader() {
        try {
            menu = FXMLLoader.load(getClass().getClassLoader().getResource("../../resources/NotUsed/Menu.fxml"));
            newRoadObject = FXMLLoader.load(getClass().getClassLoader().getResource("../../resources/NotUsed/NewRoadObjectForm.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Parent getMenu() {
        return ourInstance.menu;
    }

    public static Parent getNewRoadObject() {
        return ourInstance.newRoadObject;
    }
}

package mvc.model.road.object;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

public class RoadObjectSimple {

    private final SimpleStringProperty name;
    private final SimpleIntegerProperty x;
    private final SimpleIntegerProperty y;
    private final SimpleLongProperty length;

    public RoadObjectSimple(SimpleStringProperty name, SimpleIntegerProperty x, SimpleIntegerProperty y, SimpleLongProperty length) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.length = length;
    }

    public RoadObjectSimple(RoadObject roadObject) {
        this.name = new SimpleStringProperty(roadObject.getClass().getSimpleName());
        this.x = new SimpleIntegerProperty(roadObject.getX());
        this.y = new SimpleIntegerProperty(roadObject.getY());
        this.length = new SimpleLongProperty(roadObject.getLength());
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public int getX() {
        return x.get();
    }

    public SimpleIntegerProperty xProperty() {
        return x;
    }

    public int getY() {
        return y.get();
    }

    public SimpleIntegerProperty yProperty() {
        return y;
    }

    public long getLength() {
        return length.get();
    }

    public SimpleLongProperty lengthProperty() {
        return length;
    }
}
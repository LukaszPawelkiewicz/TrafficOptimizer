package mvc.model.simulation.observer.common;

import mvc.model.road.object.RoadObject;
import mvc.model.simulation.observer.Observer;

import java.util.List;

public class RoadObjectObserver extends Observer<RoadObject> {

    private static Observer<RoadObject> ourInstance = new RoadObjectObserver();

    public static List<RoadObject> getRoadObjects() {
        return ourInstance.getObjects();
    }

    public static RoadObjectObserver getInstance() {
        return (RoadObjectObserver) ourInstance;
    }

    private RoadObjectObserver() {
    }
}

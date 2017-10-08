package mvc.model.road.common;

import mvc.model.road.object.RoadObject;
import mvc.model.simulation.observer.Observer;
import mvc.model.simulation.observer.common.RoadObjectObserver;

public class Crossing extends RoadObject {

    public Crossing(int x, int y, RoadObjectObserver observer) {
        super(observer);
        this.x = x;
        this.y = y;
    }

}

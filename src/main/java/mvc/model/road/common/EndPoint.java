package mvc.model.road.common;

import mvc.model.road.object.RoadObject;
import mvc.model.simulation.observer.Observer;
import mvc.model.simulation.observer.common.RoadObjectObserver;

public class EndPoint extends RoadObject {


    public EndPoint(int x, int y, RoadObjectObserver observer) {
        super(observer);
        this.x = x;
        this.y = y;
    }

}

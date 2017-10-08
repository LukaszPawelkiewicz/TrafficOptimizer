package mvc.model.road;

import mvc.model.road.object.RoadObject;

public class RouteRoadObject {

    private RoadObject current;
    private RoadObject next;

    /**
     * Create route list
     *
     * @param current current (not null)
     * @param next    next, if null -> end
     */
    public RouteRoadObject(RoadObject current, RoadObject next) {
        super();
        this.current = current;
        this.next = next;
    }

    public RoadObject getCurrent() {
        return current;
    }

    public void setCurrent(RoadObject current) {
        this.current = current;
    }

    public RoadObject getNext() {
        return next;
    }

    public void setNext(RoadObject next) {
        this.next = next;
    }
}

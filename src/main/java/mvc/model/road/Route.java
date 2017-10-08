package mvc.model.road;

import mvc.model.road.object.RoadObject;
import mvc.model.road.common.EndPoint;
import mvc.model.road.common.StartPoint;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Route {

    private StartPoint startPoint;
    private EndPoint endPoint;
    private long distance;      //(meters)
    private final LinkedList<RouteRoadObject> path = new LinkedList<>();

    public Route() {
        super();
    }

    public Route(RoadObject start, RoadObject end) {
        super();
        this.startPoint = (StartPoint) start;
        this.endPoint = (EndPoint) end;
    }

    public void activateStart() {
        if (path.isEmpty()) {
            path.add(new RouteRoadObject(startPoint, null));
        }
    }

    public void activateEnd() {
        if (!path.isEmpty()) {
            path.getLast().setNext(endPoint);
            path.add(new RouteRoadObject(endPoint, null));
        }
    }

    public void addNextRoadObjectToPath(RoadObject roadObject) {
        if (!path.isEmpty()) {
            path.getLast().setNext(roadObject);
            path.add(new RouteRoadObject(roadObject, null));
        }
    }

    public void addInsideRoadObjectTopath(RoadObject roadObject, int index) {
        if (!path.isEmpty()) {
            RoadObject tmp = path.get(index - 1).getNext();
            path.get(index - 1).setNext(roadObject);
            path.add(index, new RouteRoadObject(roadObject, tmp));
        }
    }

    public void sumDistance() {
        distance = 0;
        for (RouteRoadObject object : path) {
            distance += object.getCurrent().getLength();
        }
    }

    public void removeRoadObjectFromPath(RoadObject roadObject) {
        //TODO
    }

    //getters/setters
    public StartPoint getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(StartPoint startPoint) {
        this.startPoint = startPoint;
    }

    public EndPoint getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(EndPoint endPoint) {
        this.endPoint = endPoint;
    }

    public long getDistance() {
        return distance;
    }

    public void setDistance(long distance) {
        this.distance = distance;
    }

    public LinkedList<RouteRoadObject> getPath() {
        return path;
    }

}

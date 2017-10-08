package mvc.model.road.object;

import mvc.model.simulation.observer.Observable;
import mvc.model.simulation.observer.Observer;
import mvc.model.simulation.observer.common.RoadObjectObserver;

public abstract class RoadObject implements Observable {

    protected int x;
    protected int y;
    protected long length = 0;
    protected RoadObjectObserver observer;

    public RoadObject(RoadObjectObserver observer) {
        this.observer = observer;
        call();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public long getLength() {
        return length;
    }

    public void setLength(long length) {
        this.length = length;
    }

    @Override
    public void addObserver(Observer o) {
        this.observer = (RoadObjectObserver) o;
    }

    @Override
    public void removeObserver(Observer o) {
        observer.removeObject(this);
        this.observer = null;
    }

    @Override
    public void call() {
        observer.addObject(this);
    }
}


package mvc.model.simulation.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Observer<T> {

    protected final List<T> objects = new ArrayList<>();

    public List<T> getObjects() {
        return objects;
    }

    public void addObject(T object) {
        this.objects.add(object);
    }

    public void removeObject(T object) {
        this.objects.remove(object);
    }

}

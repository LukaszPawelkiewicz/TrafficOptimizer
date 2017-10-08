package mvc.model.simulation.observer;

public interface Observable {

    public void addObserver(Observer o);
    public void removeObserver(Observer o);
    public void call();

}

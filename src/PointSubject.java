import java.util.ArrayList;
import java.util.List;

public class PointSubject implements Observable {
    @Override
    public void attach(Observer o) {
        if (o != null) {
            observers.add(o);
        }
    }

    @Override
    public void detach(Observer o) {
        if (o != null) {
            observers.remove(o);
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
    private List<Observer> observers = new ArrayList();
}

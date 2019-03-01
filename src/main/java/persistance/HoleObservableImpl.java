package persistance;

import java.util.ArrayList;
import java.util.List;

public class HoleObservableImpl implements HoleObservable {
    private List<Observer> subscribers = new ArrayList<>(2);

    @Override
    public void subscribe(Observer observer) {
        subscribers.add(observer);
    }

    @Override
    public void updateSubscribers(long id) {
        subscribers.forEach(subscriber ->subscriber.update(id));
    }
}

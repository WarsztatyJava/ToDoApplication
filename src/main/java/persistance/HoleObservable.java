package persistance;


public interface HoleObservable {

    void subscribe(Observer observer);
    void updateSubscribers(long id);

}

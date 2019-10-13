package observer2;

public interface Subject {

	void subscribe(Subscriber subscriber);

	void unsubscribe(Oberver subscriber);

	void notifySubscribers();

	void upload(String title);

}
package observer2;

import java.util.ArrayList;
import java.util.List;

public class Channel implements Subject {
	String title;
	private List<Subscriber> subs = new ArrayList<>();
	
	/* (non-Javadoc)
	 * @see observer2.Subject#subscribe(observer2.Subscriber)
	 */
	@Override
	public void subscribe(Subscriber subscriber) {
		subs.add(subscriber);
	}
	
	/* (non-Javadoc)
	 * @see observer2.Subject#unsubscribe(observer2.Oberver)
	 */
	@Override
	public void unsubscribe(Oberver subscriber) {
		subs.remove(subscriber);
	}
	
	/* (non-Javadoc)
	 * @see observer2.Subject#notifySubscribers()
	 */
	@Override
	public void notifySubscribers() {
		subs.stream().forEach(s -> s.update());
	}
	
	/* (non-Javadoc)
	 * @see observer2.Subject#upload(java.lang.String)
	 */
	@Override
	public void upload(String title) {
		this.title = title;
		notifySubscribers();
	}
}

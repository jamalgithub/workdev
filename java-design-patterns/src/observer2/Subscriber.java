package observer2;

public class Subscriber implements Oberver {
	private String name;
	private Channel channel;
		
	public Subscriber(String name) {
		super();
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see observer2.Oberver#update()
	 */
	@Override
	public void update() {
		System.out.println(name+" Video uploaded "+channel.title);
	}
	
	/* (non-Javadoc)
	 * @see observer2.Oberver#subscribeChannel(observer2.Channel)
	 */
	@Override
	public void subscribeChannel(Channel channel) {
		this.channel = channel;
	}
}

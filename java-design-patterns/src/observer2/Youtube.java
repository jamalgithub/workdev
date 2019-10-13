package observer2;

public class Youtube {

	public static void main(String[] args) {
		Channel jijo = new Channel();
		Subscriber sub1 = new Subscriber("said");
		Subscriber sub2 = new Subscriber("adil");
		Subscriber sub3 = new Subscriber("foad");
		Subscriber sub4 = new Subscriber("ahmed");
		Subscriber sub5 = new Subscriber("karim");
		
		jijo.subscribe(sub1);
		jijo.subscribe(sub2);
		jijo.subscribe(sub3);
		jijo.subscribe(sub4);
		jijo.subscribe(sub5);
		
		jijo.unsubscribe(sub3);
		
		sub1.subscribeChannel(jijo);
		sub2.subscribeChannel(jijo);
		sub3.subscribeChannel(jijo);
		sub4.subscribeChannel(jijo);
		sub5.subscribeChannel(jijo);
		
		jijo.upload("Learn Java!!");
	}

}

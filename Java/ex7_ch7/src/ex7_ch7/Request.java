package ex7_ch7;

public class Request extends Message{
	private static String Message = "Hi add me to your contact list";

	public Request(User Sender, User Receiver) {
		super(Sender, Receiver, Message);
		
	}

}
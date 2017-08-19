package ex7_ch7;

public class Message {
	private User Sender;
	public User getSender() {
		return Sender;
	}

	public User getReceiver() {
		return Receiver;
	}

	public String getMessage() {
		return Message;
	}

	private User Receiver;
	private String Message;
	
	public Message(User Sender, User Receiver, String Message){
		this.Receiver = Receiver;
		this.Sender = Sender;
		this.Message = Message;
	}
}

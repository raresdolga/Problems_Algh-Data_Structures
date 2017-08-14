package ex4_ch7;

public class Ticket {
	private Date enteredTime;
	private Date payedTime;
	Date period;
	public Ticket(Date now, Date payedTime, Date period){
		enteredTime = now;
		this.payedTime = payedTime;
		this.period = period; 
	}
	
	public Date getEnteredTime(){
		return enteredTime;
	}
	
	public Date getPayedTime(){
		return payedTime;
	}
	public Date getPeriod(){
		return period;
	}
	
}

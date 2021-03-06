package ex4_ch7;

import java.time.LocalDateTime;
import java.util.HashMap;

public class GateSystem {
	private int maxCapacity;
	private HashMap<Car,Ticket> cars;
	
	
	public GateSystem(int maxCapacity){
		this.maxCapacity = maxCapacity;
		cars = new HashMap<>();
	}
	
	public boolean checkIfFull(){
		if(cars.keySet().size() > maxCapacity){
			return true;
		}
		return false;
	}
	
	public Ticket pay(Date period){
		LocalDateTime today = LocalDateTime.now();
		Date now = new Date();
		now.day = today.getDayOfMonth();
		now.hour = today.getHour();
		now.minute = today.getMinute();
		Date endTime = new Date();
		endTime.minute = (now.minute + period.minute)%60;
		endTime.hour = (now.hour + period.hour)%24;
		endTime.hour += (now.minute + period.minute)/60;
		endTime.day = (now.day + period.day);
		endTime.day += (now.hour + period.hour)/24;
		
		Ticket t = new Ticket(now,endTime,period);
		return t;
	}
	public void enterCar(Car car, Date period){
		if(!checkIfFull()){
			Ticket t = pay(period);
			cars.put(car,t); 
		}
	}
	
	public void exitCar(Car c){
		Ticket t = cars.get(c);
		Date d = t.getPayedTime();
		LocalDateTime now = LocalDateTime.now();
		if(now.getDayOfMonth()>d.day || now.getHour() > d.hour || now.getMinute() > d.minute){
			System.out.println("you have to pay More");
			Date extra = new Date();
			extra.day = - now.getDayOfMonth() + d.day;
			extra.hour = - now.getHour() + d.hour;
			extra.minute = - now.getMinute() + d.minute;
			pay(extra);
		}
			cars.remove(c);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

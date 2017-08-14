package ex2_ch7;

public abstract class Employee {
	public int age;
	public String name;
	public String adress;
	public String rank;
	private boolean free;

	public boolean getFree() {
		return free;
	}

	public void respondCall(Call c){
		this.free = false;
	}
	public void endCall(){
		this.free = true;
	}
	
	public abstract void passCall();
}

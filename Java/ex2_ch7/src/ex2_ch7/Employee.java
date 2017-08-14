package ex2_ch7;

public abstract class Employee {
	public int age;
	public String name;
	public String adress;
	public String rank;
	private boolean free;

	public Employee(int age, String name, String adress, String rank){
		this.age = age;
		this.name = name;
		this.adress = adress;
		this.rank = rank;
		free = true;
	}
	public boolean getFree() {
		return free;
	}

	public void respondCall(Call c){
		this.free = false;
	}
	public void endCall(){
		this.free = true;
	}
	
}

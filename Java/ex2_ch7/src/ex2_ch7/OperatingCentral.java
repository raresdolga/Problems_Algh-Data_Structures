package ex2_ch7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class OperatingCentral {
	private HashMap<String, LinkedList<Call>> calls;
	private ArrayList<Employee> empls;
	private ArrayList<Respondent> res;
	public OperatingCentral() {
		calls = new HashMap<String,LinkedList<Call>>();
		empls = new ArrayList<>();
	}
	
	public Employee getFreeEmp(String type){
		for (Employee emp :empls)
			if(emp.rank.equals(type)) {
				if(emp.getFree())
					return emp;
			}
		return null;
	}
	
	public Employee getFree(){
		for(Respondent r : res)
			if(r.getFree())
				return r;
		return null;
	}
	
	public void handleCall(Call c){
		Employee r = getFree();
		if(r != null){
			r.respondCall(c);
			if(c.rankOfSolver != "respondent"){
				Employee emp = getFreeEmp(c.rankOfSolver);
				r.endCall();
				assign_next();
				if(emp == null)
					calls.get(c.rankOfSolver).add(c);
				else {
					emp.respondCall(c);
				}
			}
		}
		else
			calls.get("respondent").add(c);
	}
	private void assign_next(){
		if(calls.get("respondent").size() > 0){
			Call cal = calls.get("respondent").removeFirst();
			handleCall(cal);
		}
	}
			
	public static void main (String args[]){
		
	}
	
}

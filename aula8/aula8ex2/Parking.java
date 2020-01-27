package aula8ex2;

import java.util.HashMap;

public class Parking {
	
	static HashMap<Employee, Boolean> allow = new HashMap<>();
	
	public static void allow(Employee emp) {
		if(emp.getSalary() > avg()) {
			allow.put(emp, true);
			System.out.println(emp + " is now allowed on the parking lot");
		}else {
			allow.put(emp, false);
			System.out.println(emp + " isnt allowed on the parking lot");
		}
	}
	
	public static double avg() {
		double sum=0;
		for(Employee e : allow.keySet()) {
			sum+=e.getSalary();
		}
		return sum/allow.size();
	}

}

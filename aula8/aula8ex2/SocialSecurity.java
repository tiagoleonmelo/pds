package aula8ex2;

import java.util.HashSet;

public class SocialSecurity {
	static HashSet<Employee> registos = new HashSet<>();
	
	public static void regist(Employee emp) {
		registos.add(emp);
	}
	
}

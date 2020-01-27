package lab7;

import java.util.Random;

public class Teste {

	public static void main(String[] args) {
		EmployeeInterface j1 = new Employee("Rui");
		TeamMember f1 = new TeamMember(new Employee("Luis"));
		TeamLeader x1 = new TeamLeader(new Employee("Ana"));
		TeamLeader x2 = new TeamLeader(j1);
		TeamLeader x3 = new TeamLeader(f1);
		Manager t1 = new Manager(j1);
		Manager t2 = new Manager(new TeamLeader(new TeamMember(new Employee("Bruna"))));
		EmployeeInterface lista[] = { j1, f1, x1, x2, x3, t1, t2 };
		
		
		Random rand=new Random();
		
		for(EmployeeInterface ji:lista)
		{
			ji.work();
			ji.start(new Date(rand.nextInt(31)+1,rand.nextInt(12)+1,rand.nextInt(1990 - 1950 + 1)+1950));
		}
	}

}

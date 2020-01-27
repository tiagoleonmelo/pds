package lab7;

public class TeamMember extends EmpDecorator {

	TeamMember(EmployeeInterface j) {
		super(j);
	}
	@Override public void work() {
		j.work();
		System.out.print("being a team member -- ");
	}
	public void colaborate() {
		System.out.println("colaborating");
	}
	
	
}

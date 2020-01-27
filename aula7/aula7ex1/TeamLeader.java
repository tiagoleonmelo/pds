package lab7;

public class TeamLeader extends EmpDecorator {

	TeamLeader(EmployeeInterface j) {
		super(j);
	}
	@Override public void work() {
		j.work();
		System.out.print("being a team leader -- ");
	}
	public void plan() {
		System.out.println("planning");
	}
	
	
}

package lab7;

public class Manager extends EmpDecorator {

	Manager(EmployeeInterface j) {
		super(j);
	}
	@Override public void work() {
		j.work();
		System.out.print("being a manager -- ");
	}
	public void manage() {
		System.out.println("managing");
	}
	
	
}


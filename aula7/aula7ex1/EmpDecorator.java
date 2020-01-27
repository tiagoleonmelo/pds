package lab7;

public abstract class EmpDecorator implements EmployeeInterface {
	protected EmployeeInterface j;
	EmpDecorator(EmployeeInterface j) { this.j = j; }
	public void work() { j.work(); }
	public void start(Date date) { j.start(date); }
	public void terminate(Date date) { j.terminate(date); }

}

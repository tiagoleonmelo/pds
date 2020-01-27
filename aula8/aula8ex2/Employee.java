package aula8ex2;

public class Employee extends Person{
	private double salary;
	
	public Employee(String n, double s) {
		super(n);
		salary = s;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public String toString() {
		return this.getName() + ", income: " + this.salary;
	}
}

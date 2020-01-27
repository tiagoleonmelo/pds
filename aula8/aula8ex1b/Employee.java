package aula8ex1b;

public class Employee {
	private double salary;
	private String name;
	private Person p;

	public Employee(String n, double s) {
		name=n;
		salary = s;
		this.p=new Person(n);
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}
	public BankAccount getBankAccount() {
		return p.getBankAccount();
	}
}

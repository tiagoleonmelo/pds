package aula8ex2;

public class Cartao {
	String name;
	double salary;
	
	public Cartao(Employee emp) {
		this.name = emp.getName();
		this.salary = emp.getSalary();
	}
	
	public String toString() {
		return name + ", " + salary;
	}
}

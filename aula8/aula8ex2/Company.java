package aula8ex2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Company {
	public static User user;
	private List<Employee> emps = new ArrayList<>();
	private List<Cartao> cartoes = new ArrayList<>();
	
	public void admitPerson(String name, double salary) {
		Employee e = new Employee(name, salary);
		emps.add(e);
		SocialSecurity.regist(e);
		Insurance.regist(e);
		Parking.allow(e);
		cartoes.add(new Cartao(e));
	}
	
	public void paySalaries(int month) {
		for (Employee e : emps) {
			BankAccount ba = e.getBankAccount();
			ba.deposit(e.getSalary());
		}
	}
	
	public List<Employee> employees() {
		return Collections.unmodifiableList(emps);
	}
}

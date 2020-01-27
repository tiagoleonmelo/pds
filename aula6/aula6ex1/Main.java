package aula6;

public class Main {

	public static void main(String[] args) {
		
		Database db = new Database();

		Employee e1 = new Employee("Jonny Banana", 8080, 1500);
		Employee e2 = new Employee("The Wrapped One", 213, 1500);
		Employee e3 = new Employee("Pizza", 542, 1500);
		Employee e4 = new Employee("F. Mendes", 7609, 1500);

		db.addEmployee(e1);
		db.addEmployee(e2);
		db.addEmployee(e3);
		db.addEmployee(e4);
		
		Registos r = new Registos();

		Empregado em1 = new Empregado("Jonny", "Banana", 8080, 1500);
		Empregado em2 = new Empregado("The Wrapped","One", 213, 1500);
		Empregado em3 = new Empregado("Piz","za", 542, 1500);
		Empregado em4 = new Empregado("F.","Mendes", 7609, 1500);

		r.insere(em1);
		r.insere(em2);
		r.insere(em3);
		r.insere(em4);
		
		Data d = new Data();
		
		d.addEmployee(e1);
		d.addEmployee(e2);
		d.addEmployee(e3);
		d.addEmployee(e4);
		d.addEmployee(em1);
		d.addEmployee(em2);
		d.addEmployee(em3);
		d.addEmployee(em4);
		
		d.allTheData();
		
	}

}

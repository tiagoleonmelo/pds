package lab7;

public class Employee implements EmployeeInterface {
	private String nome;
	Employee(String n){
		this.nome=n;
	}

	@Override
	public void start(Date date) {
		System.out.println("Started working at "+date);
		
	}

	@Override
	public void terminate(Date date) {
		System.out.println("Finished working at "+date);
		
	}

	@Override
	public void work() {
		System.out.print("\n"+ nome+" is working ");
		
	}

}

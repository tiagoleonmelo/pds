package aula6;

public class Data extends Database{
	private Registos reg = new Registos();
	
	// Polymorphism based solution
	
	public boolean addEmployee(Employee employee) {
		return super.addEmployee(employee);
	}
	
	public void addEmployee(Empregado employee) {
		reg.insere(employee);
	}
	
	public void removeEmployee(long emp_num) {
		super.deleteEmployee(emp_num);
	}
	
	public void removeEmployee(int codigo) {
		reg.remove(codigo);
	}
	
	public boolean isEmployee(long emp_num) {
		for(Employee emp:super.getAllEmployees())
			if(emp.getEmpNum() == emp_num)
				return true;
		return false;
	}
	
	public boolean isEmployee(int codigo) {
		return reg.isEmpregado(codigo);
	}
	
	public void setLegacy(Registos r) {
		this.reg = r;
	}
	
	public void allTheData() {
		for (Employee a: super.getAllEmployees()) {
			System.out.print(a.getName()+ " "+a.getEmpNum()+ " "+a.getSalary() +"; ");
		}
		System.out.println();
		for (Empregado b: reg.listaDeEmpregados()) {
			System.out.print(b.nome()+" "+b.apelido()+" "+b.codigo()+" "+b.salario()+"; ");
		}
	
	}

}

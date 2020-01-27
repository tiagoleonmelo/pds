package aula6;

import java.util.Vector;

class Database { // Data elements
	private Vector<Employee> employees; // Stores the employees
	
	public Database() {
		employees = new Vector<>();
	}
	
	public boolean addEmployee(Employee employee) {
		// Code to add employee
		return this.employees.add(employee);
	}
	
	public void deleteEmployee(long emp_num) {
		// Code to delete employee
		for(Employee emp : this.employees)
			if(emp.getEmpNum()==emp_num)
				this.employees.remove(emp);
	}
	
	public Employee[] getAllEmployees() {
		// Code to retrieve collection
		return this.employees.toArray(new Employee[this.employees.size()]);
	}
	
}


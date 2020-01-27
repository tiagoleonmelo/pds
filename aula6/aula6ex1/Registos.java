package aula6;

import java.util.List;
import java.util.ArrayList;

class Registos {
	// Data elements
	private ArrayList<Empregado> empregados; // Stores the employees

	public Registos() {
		empregados = new ArrayList<>();
	}

	public void insere(Empregado emp) {
		// Code to insert employee
		this.empregados.add(emp);
	}

	public void remove(int codigo) {
		// Code to remove employee
		if(isEmpregado(codigo))
			for(Empregado emp : this.empregados)
				if(emp.codigo()==codigo)
					this.empregados.remove(emp);
	}

	public boolean isEmpregado(int codigo) {
		// Code to find employee
		for(Empregado emp : this.empregados)
			if(emp.codigo()==codigo)
				return true;
		
		return false;
	}

	public List<Empregado> listaDeEmpregados() {
		// Code to retrieve collection
		return empregados;
	}
}

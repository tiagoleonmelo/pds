package aula11ex3;

public class Emprestado implements State {

	@Override
	public void execute(Book b, operation op) {
		switch (op) {
		case devolve:
			b.setState(new Disponivel());
			System.out.println("Devolvido");
			break;
		default: System.out.println("NOT AVAILABLE!");
		}

	}
	public String print() {
		return this.getClass().getSimpleName();
	}
	

}
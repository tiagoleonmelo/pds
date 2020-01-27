package aula11ex3;

public class Inventario implements State {

	@Override
	public void execute(Book b, operation op) {
		switch (op) {
		case regista:
			b.setState(new Disponivel());
			System.out.println("Registado");
			break;
		default: System.out.println("NOT AVAILABLE!");
		}

	}
	public String print() {
		return this.getClass().getSimpleName();
	}

}

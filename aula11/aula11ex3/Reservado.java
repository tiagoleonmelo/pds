package aula11ex3;

public class Reservado implements State {

	@Override
	public void execute(Book b, operation op) {
		switch (op) {
		case cancela:
			b.setState(new Disponivel());
			System.out.println("Reserva Cancelada");
			break;
		default: System.out.println("NOT AVAILABLE!");
		}

	}
	public String print() {
		return this.getClass().getSimpleName();
	}
	

}

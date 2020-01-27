package aula11ex3;

public class Disponivel implements State {

	@Override
	public void execute(Book b, operation op) {
		switch (op) {
		case requisita:
			b.setState(new Emprestado());
			System.out.println("Emprestado");
			break;
		case reserva:
			b.setState(new Reservado());
			System.out.println("Reservado");
			break;
		default: System.out.println("NOT AVAILABLE!");
		}

	}
	public String print() {
		return this.getClass().getSimpleName();
	}
	

}

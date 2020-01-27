package aula9ex2;

public class Controller<E> {
	private Command<E> com;

	public void setCom(Command<E> com) {
		this.com = com;
	}
	
	public void execute(E el) {
		this.com.execute(el);
	}
	public void undo() {
		this.com.undo();
	}
	
	
}

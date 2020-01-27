package aula11ex3;

public interface State {
	void execute (Book b, operation op);
	String print();
}

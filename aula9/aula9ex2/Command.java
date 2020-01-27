package aula9ex2;

public interface Command<E> {
	void undo();
	void execute(E el);

}

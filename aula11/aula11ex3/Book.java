package aula11ex3;

public class Book {
	private String title;
	private int ISBN;
	private int ano;
	private String autor;
	private State state;
	public Book(String title, int iSBN, int ano, String autor) {
		super();
		this.title = title;
		ISBN = iSBN;
		this.ano = ano;
		this.autor = autor;
	}
	public void setState(State s) {
		this.state=s;
	}
	@Override
	public String toString() {
		return "Book [title=" + title + ", state=" + state.print() + "]";
	}
	public void execute(operation op) {
		this.state.execute(this,op);
	}
	
	

}

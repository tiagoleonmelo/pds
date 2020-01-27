package aula11ex3;

import java.util.ArrayList;

public class Biblioteca {
	private ArrayList<Book> livros= new ArrayList<>();

	public Biblioteca(ArrayList<Book> livros) {
		this.livros = livros;
	}
	public void print () {
		for (Book l : livros) {
			System.out.println(l.toString());
		}
	}
	public void operacao(int i, operation op) {
		this.livros.get(i).execute(op);
		this.print();
	}
	
	
	

}

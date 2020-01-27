package aula10ex1;

import java.util.ArrayList;

public class Gestor extends Observer{
	
	private String nome;
	private ArrayList<Produto> prods = new ArrayList<>();
	
	public Gestor(String nome, Produto s) {
		this.nome = nome;
		this.prod= s;
		this.prod.attach(this); // Observers register themselves
	}

	@Override
	public void update() {
		System.out.println(nome + " saw " + this.prod + " going to " + this.prod.getPrice());		
	}
	
	public void addProd(Produto p) {
		this.prods.add(p);
	}

}
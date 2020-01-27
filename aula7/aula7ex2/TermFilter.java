package aula7ex2;

import java.util.Scanner;

public class TermFilter extends Decorator{
	
	private Scanner sc;

	public TermFilter(Reader tr) {
		super(tr);
		this.sc = new Scanner(tr.next());
	}
	
	@Override
	public boolean hasNext() {
		return sc.hasNext() || tr.hasNext();
	}


	@Override
	public String next() {
		if(!sc.hasNext()) 
			sc = new Scanner(tr.next());	// passar para o prox paragrafo
		
		return sc.next();
	}
	
	

}

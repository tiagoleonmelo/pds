package aula7ex2;

import java.util.Scanner;

public class ReverseFilter extends Decorator{
	
	Scanner sc;

	public ReverseFilter(Reader tr) {
		super(tr);
		sc = new Scanner(tr.next());
	}
	
	@Override
	public boolean hasNext() {
		return sc.hasNext() || tr.hasNext();
	}


	@Override
	public String next() {
		if(!sc.hasNext()) 
			sc = new Scanner(tr.next());	// passar para o prox paragrafo
		
		String word = sc.next(); 
		  
        StringBuilder sb = new StringBuilder(); 
  
        // append a string into StringBuilder input1 
        sb.append(word); 
  
        // reverse StringBuilder input1 
        sb = sb.reverse(); 
  
        // return reversed String 
        return sb.toString();
	}
	
}

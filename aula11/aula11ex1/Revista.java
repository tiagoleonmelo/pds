package aula11ex1;

import java.util.ArrayList;

public class Revista {
	
	Strategy sorting_alg;
	ArrayList<Telemovel> content = new ArrayList<Telemovel>();
	
	public Revista(ArrayList<Telemovel> c) {
		this.content = c;
	}
	
	public Revista() {
		content = new ArrayList<Telemovel>();
	}
	
	public void setStrategy(Strategy s) {
		this.sorting_alg = s;
	}
	
	public ArrayList<Telemovel> sort(Attribute a) {
		return sorting_alg.sort(content, a);
	}
	
	

}

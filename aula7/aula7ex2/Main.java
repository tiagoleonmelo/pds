package aula7ex2;

import java.io.FileNotFoundException;

public class Main {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		TextReader tr = new TextReader("puzzle.txt");
		while(tr.hasNext()) {
			System.out.println(tr.next());
		}
		
		TermFilter tf = new TermFilter(new TextReader("puzzle.txt"));
		while(tf.hasNext()) {
			System.out.println(tf.next());
		}
		
		ReverseFilter rf = new ReverseFilter(new TextReader("puzzle.txt"));
		while(rf.hasNext()) {
			System.out.println(rf.next());
		}
		
		ReverseFilter crf = new ReverseFilter(new CoderFilter(new TextReader("puzzle.txt")));
		while(crf.hasNext()) {
			System.out.println(crf.next());
		}
		
		CoderFilter cf = new CoderFilter(new TextReader("puzzle.txt"));
		while(cf.hasNext()) {
			System.out.println(cf.next());
		}
	}

}

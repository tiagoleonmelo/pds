package aula7ex2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TextReader implements Reader{

	private File f;
	private Scanner sc;
	
	public TextReader(String fname) throws FileNotFoundException {
		this.f=new File(fname);
		this.sc = new Scanner(f);
	}

	@Override
	public boolean hasNext() {
		return sc.hasNextLine();
	}

	@Override
	public String next() {
		return sc.nextLine();
		
	}
	
	
}

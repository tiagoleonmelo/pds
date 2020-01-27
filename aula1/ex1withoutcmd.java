package aula1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ex1withoutcmd {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		File file = new File("sdl_01.txt");

		WordSoup ws = new WordSoup(file);
		
		ArrayList<Solution> sol = ws.solver();
		
		ws.printsol(sol);
		
	}

}

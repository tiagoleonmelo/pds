package a1pdsg45;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class WSGenerator_g45 {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("wordlist.txt");
		WordSoup ws = new WordSoup(file);
		
		String newfile=ws.PuzzleGenerator();
		File nfile = new File(newfile);
		WordSoup puzzle=new WordSoup(nfile);
		ArrayList<Solution> sol = puzzle.solver();
		ws.printsol(sol);

	}

}

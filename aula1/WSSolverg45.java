package aula1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class WSSolverg45 {

	public static void main(String[] args) throws FileNotFoundException {
		int nargs = args.length;
		String filename = "";
		long startTime=0;
		if (nargs == 2) {
			filename = args[1];
			if (args[0].equals("--timing")) {
				startTime = System.currentTimeMillis();
			} else {
				System.out.println("Wrong optional arg, only available one is --timing");
				System.exit(0);
			}
		} else if (nargs == 1) {
			filename = args[0];
		} else {
			System.out.println("Wrong number of args");
			System.exit(0);
		}
		File file = new File(filename);

		WordSoup ws = new WordSoup(file);

		ArrayList<Solution> sol = ws.solver();
		
		if(nargs==2) {
			long stopTime = System.currentTimeMillis();
			long elapsedTime = stopTime - startTime;
			System.out.println("Elapsed time (secs): "+elapsedTime/1000.0);

		}

		ws.printsol(sol);
	}

}

package P01;

import java.util.*;

public class E102 {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		
		String filename = "wordlist_1.txt";
		String filename2 = "sdl_01.txt";
		Puzzle puzzle = new Puzzle(filename, filename2);
		puzzle.getWords();
		WSGenerator gerador = new WSGenerator(puzzle);
		WSSolver solver;
		char[][] soup;
		boolean condicion;
		
		do {
			condicion = false;
			soup = gerador.makesoup();
			puzzle.setSoupgrid(soup);
			solver = new WSSolver(puzzle);
			Map<String,List<String>> map = solver.find();
			for(String key : map.keySet())
				if(map.get(key).size() != 0)
					condicion = true;
		}while(condicion);
		
		Checker verify = new Checker(filename2);
		verify.gridchecker();
		
		gerador.place();
		puzzle.save();
		
		puzzle.printgrid();
		
		for(String s : puzzle.getWordslist())
			System.out.print(s + " ");
		
		long finish = System.currentTimeMillis();
		long timeElapsed = finish - start;
		System.out.println("Elapsed time (milisecs):" + timeElapsed);
		
	}

}

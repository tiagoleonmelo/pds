package P01;

import java.io.*;
import java.util.*;

public class E101 {

	public static void main(String[] args) throws IOException {
		long start = System.currentTimeMillis();
		
		String filename = "soup.txt";
		Checker verify = new Checker(filename);
		verify.gridchecker();
		Puzzle puzzle = new Puzzle(filename);
		//obrigatório chamar essas duas funções
		puzzle.getSoup();
		puzzle.getWords();
		WSSolver solver = new WSSolver(puzzle);
		Map<String,List<String>> map = solver.find();
		for(String key : map.keySet()) {
			if(map.get(key).size() != 0)
				System.out.printf("%-15s %-5s %3s,%-3s %s\n", key, key.length(), map.get(key).get(1), map.get(key).get(2), map.get(key).get(0));
		}
		
		long finish = System.currentTimeMillis();
		long timeElapsed = finish - start;
		System.out.println("Elapsed time (milisecs):" + timeElapsed);

	}
}

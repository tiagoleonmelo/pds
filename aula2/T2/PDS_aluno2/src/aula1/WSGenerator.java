package aula1;

import java.io.*;
import java.util.*;

public class WSGenerator {

	public static void main(String[] args) throws IOException {
		String filename = "wordlist.txt";
		List<String> words = getwords(filename);
		System.out.println(words);

	}
	
	public static List<String> getwords(String filename) throws IOException {
		List<String> words = new ArrayList<>();
		Scanner sopa = new Scanner(new FileReader(filename));
		
		while(sopa.hasNextLine()) {
			String line = sopa.nextLine();
				for (String s : line.split("[, \n ; ]")) {
					if(s.length() > 2) {
						if(!words.contains(s.toUpperCase())) {
							words.add(s.trim().toUpperCase());
						}
						else {
							System.err.println("Word list contains duplicated words. Aborting execution");
							sopa.close();
							System.exit(0);
						}
					}
					if (s.length() < 3 && !s.equals("")) {
						System.err.println("Word '" + s + "' is smaller than 3 characters. "
								+ "Aborting execution...");
						sopa.close();
						System.exit(0);
					}
					if (!s.matches("[a-zA-Z]+") && !s.equals("")) {
						System.err.println("Word '" + s + "' contains non-alphabetic characters. "
								+ "Aborting execution...");
						sopa.close();
						System.exit(0);
					}
					if (s.matches("[A-Z]+") && !s.equals("")) {
						System.err.println("Word '" + s + "' only contains upper case characters. "
								+ "Aborting execution...");
						sopa.close();
						System.exit(0);
					}
				}
			}
			for(String s : words) {
				for(String c : words) {
					if(s != c) {
						if(s.contains(c)) {
							System.err.println("Word list contains redundant words. Aborting execution...");
							System.exit(0);
						}
					}
				}
			}
		
		sopa.close();
		return words;
	}
}

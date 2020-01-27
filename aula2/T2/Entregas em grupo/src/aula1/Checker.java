package P01;

import java.io.*;
import java.util.*;

public class Checker {
	
	private String filename;

	public Checker(String filename) {
		this.filename = filename;
	}

	
	public void gridchecker() {
		Scanner input;
		
		try {
			input = new Scanner(new FileReader(this.filename));
			int ln = 0;
			String first = input.nextLine();
			int width = first.length();
			//System.out.println("Grid width = " + width);
			input.reset();
			while (input.hasNextLine()) {
				String line = input.nextLine();
				if(!line.matches(".*[, ;].*")) {
					ln++;
					char[] letters = line.toCharArray();
					for(char c : letters) {
						if(Character.isLowerCase(c)) {
							System.err.println("Grid contains lower case letter. Aborting execution...");
							input.close();
							System.exit(0);
						}
						if(!Character.isAlphabetic(c)) {
							System.err.println("Grid contains non-alphabetic character. Aborting execution...");
							input.close();
							System.exit(0);
						}
					}
				}
			}
			if(ln > 60 || width > 60) {
				System.err.println("Grid size exceeds maximum of 60x60. Aborting execution...");
				input.close();
				System.exit(0);
			}
			if(ln+1 != width) {
				System.err.println("Grid is not square. Aborting execution...");
				input.close();
				System.exit(0);
			}
			input.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}

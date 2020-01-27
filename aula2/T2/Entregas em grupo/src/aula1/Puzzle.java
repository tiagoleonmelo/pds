package P01;

import java.io.*;
import java.util.*;

public class Puzzle implements SoupData {

	private String filename;
	private String filename2;
	private List<String> wordslist;
	private char[][] soupgrid;

	public Puzzle(String filename) {
		this.filename = filename;
		this.wordslist = new ArrayList<>();
		this.soupgrid = null;
	}
	
	public Puzzle(String filename, String filename2) {
		this.filename = filename;
		this.filename2 = filename2;
		this.wordslist = new ArrayList<>();
		this.soupgrid = null;
	}
	
	@Override
	public List<String> getWords() {
		Scanner input;
		
		try {
			input = new Scanner(new FileReader(this.filename));
			
			while(input.hasNextLine()) {
				String line = input.nextLine();
				if(line.matches(".*[, ;].*")) {
					for (String s : line.split("[, \n ; ]")) {
						if(s.length() > 2) {
							if(!wordslist.contains(s.toUpperCase())) {
								wordslist.add(s.trim().toUpperCase());
							}
							else {
								System.err.println("Word list contains duplicated words. Aborting execution");
								input.close();
								System.exit(0);
							}
						}
						if (s.length() < 3 && !s.equals("")) {
							System.err.println("Word '" + s + "' is smaller than 3 characters. "
									+ "Aborting execution...");
							input.close();
							System.exit(0);
						}
						if (!s.matches("[a-zA-Z]+") && !s.equals("")) {
							System.err.println("Word '" + s + "' contains non-alphabetic characters. "
									+ "Aborting execution...");
							input.close();
							System.exit(0);
						}
						if (s.matches("[A-Z]+") && !s.equals("")) {
							System.err.println("Word '" + s + "' only contains upper case characters. "
									+ "Aborting execution...");
							input.close();
							System.exit(0);
						}
					}
				}
				for(String s : wordslist) {
                    for(String c : wordslist) {
					    if(s != c) {
					    	if(s.contains(c)) {
					        	System.err.println("Word list contains redundant words. Aborting execution...");
					            System.exit(0);
					        }
					    }
                    }
				}
			}
			
			input.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return wordslist;
	}

	@Override
	public char[][] getSoup() {
		Scanner input;
		
		try {
			input = new Scanner(new FileReader(this.filename));

			int size = 0;
			int ln = 0;
			while (input.hasNextLine()) {
				String line = input.nextLine();
				
				if(size == 0) {
					size = line.length();
					soupgrid = new char[size][size];				
				}
				
				if(size > 0 && !line.matches(".*[, ;].*")) {
					
					int cn = 0;
					char[] lineinput = line.toCharArray();
					for (char c : lineinput) {
						soupgrid[ln][cn] = c;
						cn++;
					}
					ln++;
				}
				
			}
			input.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return soupgrid;
	}

	public List<String> getWordslist() {
		return wordslist;
	}

	public void setWordslist(List<String> wordslist) {
		this.wordslist = wordslist;
	}

	public char[][] getSoupgrid() {
		return soupgrid;
	}

	public void setSoupgrid(char[][] soupgrid) {
		this.soupgrid = soupgrid;
	}

	public void save() {
		BufferedWriter output;
		try {
			output = new BufferedWriter(new FileWriter(this.filename2, false));
			for(int i=0; i < soupgrid.length; i++) {
				for(int j=0; j < soupgrid.length; j++) {
					output.write(soupgrid[i][j]);
				}
				output.write("\n");
			}
			for(String s : wordslist) {
				output.write(s.toLowerCase() + ", ");
			}
			output.write("\n");
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public  void printgrid() {
        for(char[] ca : this.soupgrid) {
			for(char c : ca) {
				System.out.print(c + " ");
			}
			System.out.println();
		}
	}
}

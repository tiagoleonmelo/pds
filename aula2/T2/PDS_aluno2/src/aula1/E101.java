package aula1;

import java.io.*;
import java.util.*;

public class E101 {

	public static void main(String[] args) throws IOException {
		String filename = "soup.txt";
		if(gridchecker(filename) == 0) {
			char[][] soupgrid = readsoup(filename);
			List<String> words = getwords(filename);
			//System.out.println("Words to find:");
			//for(String s : words) {
				//System.out.print(s + " ");
			//}
			//System.out.println("\nSoup:");
			//printgrid(soupgrid);
			for (String s : words) {
				findword(s, soupgrid);
			}
		}
	}
	
	public static void printgrid(char[][] grid) {
		for(char[] ca : grid) {
			for(char c : ca) {
				System.out.print(c + " ");
			}
			System.out.println();
		}
	}
	
	public static List<String> getwords(String filename) throws IOException{
		List<String> words = new ArrayList<>();
		Scanner sopa = new Scanner(new FileReader(filename));
		
		while(sopa.hasNextLine()) {
			String line = sopa.nextLine();
			if(line.matches(".*[, ;].*")) {
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
		}
		
		sopa.close();
		return words;
	}
	
	public static int gridchecker(String filename) throws IOException {
		Scanner sopa = new Scanner(new FileReader(filename));
		int ln = 0;
		String first = sopa.nextLine();
		int width = first.length();
		//System.out.println("Grid width = " + width);
		sopa.reset();
		while (sopa.hasNextLine()) {
			String line = sopa.nextLine();
			if(!line.matches(".*[, ;].*")) {
				ln++;
				char[] letters = line.toCharArray();
				for(char c : letters) {
					if(Character.isLowerCase(c)) {
						System.err.println("Grid contains lower case letter. Aborting execution...");
						sopa.close();
						System.exit(0);
					}
					if(!Character.isAlphabetic(c)) {
						System.err.println("Grid contains non-alphabetic character. Aborting execution...");
						sopa.close();
						System.exit(0);
					}
				}
			}
		}
		if(ln > 60 || width > 60) {
			System.err.println("Grid size exceeds maximum of 60x60. Aborting execution...");
			sopa.close();
			System.exit(0);
		}
		if(ln+1 != width) {
			System.err.println("Grid is not square. Aborting execution...");
			sopa.close();
			System.exit(0);
		}
		sopa.close();
		return 0;
	}
	
	public static char[][] readsoup(String filename) throws IOException {
		Scanner sopa = new Scanner(new FileReader(filename));
		
		char[][] soupgrid = null;
		int size = 0;
		int ln = 0;
		while (sopa.hasNextLine()) {
			String line = sopa.nextLine();
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
		sopa.close();
		return soupgrid;
	}

	public static int findword(String s, char[][] soupgrid) {
		for(int i = 0; i < soupgrid.length; i++) {
            for(int j = 0; j < soupgrid.length; j++) {
            	
            	if(i + s.length() < soupgrid.length && finddown(i,j,s,soupgrid)) {
            		System.out.printf("%-15s %-5d %d,%-3d down\n", s, s.length(), (i+1), (j+1));
            		return 1;
            	}else if(i - s.length() >= 0 && findup(i,j,s,soupgrid)) {
                	System.out.printf("%-15s %-5d %d,%-3d up\n", s, s.length(), (i+1), (j+1));
                	return 1;
            	}else if(j + s.length() < soupgrid.length && findright(i,j,s,soupgrid)) {
            		System.out.printf("%-15s %-5d %d,%-3d right\n", s, s.length(), (i+1), (j+1));
            		return 1;
            	}else if(j - s.length() >= 0 && findleft(i,j,s,soupgrid)) {
                	System.out.printf("%-15s %-5d %d,%-3d left\n", s, s.length(), (i+1), (j+1));
                	return 1;
            	}else if(i - s.length() >= 0 && j - s.length() >= 0 && findupleft(i,j,s,soupgrid)) {
                	System.out.printf("%-15s %-5d %d,%-3d upleft\n", s, s.length(), (i+1), (j+1));
                	return 1;
            	}else if(i + s.length() < soupgrid.length && j + s.length() < soupgrid.length && finddownright(i,j,s,soupgrid)) {
            		System.out.printf("%-15s %-5d %d,%-3d downright\n", s, s.length(), (i+1), (j+1));
            		return 1;
            	}else if(i - s.length() >= 0 && j + s.length() < soupgrid.length && findupright(i,j,s,soupgrid)) {
                	System.out.printf("%-15s %-5d %d,%-3d upright\n", s, s.length(), (i+1), (j+1));
                	return 1;
            	}else if(i + s.length() < soupgrid.length && j - s.length() >= 0 && finddownleft(i,j,s,soupgrid)) {
            		System.out.printf("%-15s %-5d %d,%-3d downleft\n", s, s.length(), (i+1), (j+1));
            		return 1;
            	}
            }
		}
		return 0;
    }
    
    public static boolean finddown(int i, int j, String s, char[][] soupgrid) {
    	String word = Character.toString(soupgrid[i][j]);
    	
    	for(int k = i+1; k < i+s.length(); k++) {
    		word += Character.toString(soupgrid[k][j]);
    	}
    	//System.out.println("down");
    	return s.equals(word);
    }
    
    public static boolean findup(int i, int j, String s, char[][] soupgrid) {
    	String word = Character.toString(soupgrid[i][j]);
    	
    	for(int k = i-1; k > i-s.length(); k--) {
    		word += Character.toString(soupgrid[k][j]);
    	}
    	//System.out.println("up");
    	return s.equals(word);
    }

    public static boolean findleft(int i, int j, String s, char[][] soupgrid) {
    	String word = Character.toString(soupgrid[i][j]);
    	
    	for(int k = j-1; k > j-s.length(); k--) {
    		word += Character.toString(soupgrid[i][k]);
    	}
    	//System.out.println("left");
    	return s.equals(word);
    }
    
    public static boolean findright(int i, int j, String s, char[][] soupgrid) {
    	String word = Character.toString(soupgrid[i][j]);
    	
    	for(int k = j+1; k < j+s.length(); k++) {
    		word += Character.toString(soupgrid[i][k]);
    	}
    	//System.out.println("right");
    	return s.equals(word);
    }
    
    public static boolean findupleft(int i, int j, String s, char[][] soupgrid) {
    	String word = Character.toString(soupgrid[i][j]);
    	
    	for(int k = i-1, n = j-1; k > i-s.length() && n > j-s.length(); k--, n--) {
    			word += Character.toString(soupgrid[k][n]);
    	}
    	//System.out.println(word + i + j);
    	return s.equals(word);
    }

    public static boolean findupright(int i, int j, String s, char[][] soupgrid) {
    	String word = Character.toString(soupgrid[i][j]);
    	
    	for(int k = i-1, n = j+1; k > i-s.length() && n < j+s.length(); k--, n++) {
    			word += Character.toString(soupgrid[k][n]);
    	}
    	//System.out.println(word + i + j);
    	return s.equals(word);
    }

    public static boolean finddownleft(int i, int j, String s, char[][] soupgrid) {
    	String word = Character.toString(soupgrid[i][j]);
    	
    	for(int k = i+1, n = j-1; k < i+s.length() && n > j-s.length(); k++, n--) {
    			word += Character.toString(soupgrid[k][n]);
    	}
    	//System.out.println(word + i + j);
    	return s.equals(word);
    }

    public static boolean finddownright(int i, int j, String s, char[][] soupgrid) {
    	String word = Character.toString(soupgrid[i][j]);
    	
    	for(int k = i+1, n = j+1; k < i+s.length() && n < j+s.length(); k++, n++) {
    			word += Character.toString(soupgrid[k][n]);
    	}
    	//System.out.println(word + i + j);
    	return s.equals(word);
    }
}

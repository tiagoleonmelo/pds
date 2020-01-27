package P01;

import java.util.List;
import java.util.Random;

public class WSGenerator {

	private static char[][] soupgrid;
	private static List<String> wordslist;
	
	public WSGenerator(Puzzle puzzle) {
		this.soupgrid = puzzle.getSoupgrid();
		this.wordslist = puzzle.getWordslist();
	}
	
	public char[][] makesoup() {
		int size = (new Random().nextInt(50)) + 10;
		soupgrid = new char[size][size];
		for(int i=0; i < size; i++) {
			for(int j=0; j < size; j++) {
				char c = (char) (new Random().nextInt(26) + 'A');
				soupgrid[i][j] = c;
			}
		}
		return soupgrid;
	}

	public void place() {
 		for(String s : wordslist) {
 			placeword(s);
 		}
 	}
 	
	private static void placeword(String s) {
		int i = new Random().nextInt(soupgrid.length);
		int j = new Random().nextInt(soupgrid.length);
        boolean verify = true;

        while(verify) {
        	int rand = new Random().nextInt(9);
        	
			switch(rand) {
				case 1:
	            	if(i + s.length() < soupgrid.length) {
	            		verify = placedown(i,j,s);
	            		break;
	            	}
				case 2:
	            	if(i - s.length() >= 0) {
	            		verify = placeup(i,j,s);
	            		break;
	            	}
				case 3:
	            	if(j + s.length() < soupgrid.length) {
	            		verify = placeright(i,j,s);
	            		break;
	            	}
				case 4:
	            	if(j - s.length() >= 0) {
	            		verify = placeleft(i,j,s);
	            		break;
	            	}
				case 5:
	            	if(i - s.length() >= 0 && j - s.length() >= 0) {
	            		verify = placeupleft(i,j,s);
	            		break;
	            	}
				case 6:
	            	if(i + s.length() < soupgrid.length && j + s.length() < soupgrid.length) {
	            		verify = placedownright(i,j,s);
	            		break;
	            	}
				case 7:
	            	if(i - s.length() >= 0 && j + s.length() < soupgrid.length) {
	            		verify = placeupright(i,j,s);
	            		break;
	            	}
				case 8:
	            	if(i + s.length() < soupgrid.length && j - s.length() >= 0) {
	            		verify = placedownleft(i,j,s);
	            		break;
	            	}
			}
        }
    }

	private static boolean placedown(int i, int j, String s) {
		for(int k = i, m = 0; m < s.length(); k++, m++) {
			soupgrid[k][j] = s.charAt(m);
		}
		return false;
	}
	    
	private static boolean placeup(int i, int j, String s) {
		for(int k = i, m = 0; m < s.length(); k--, m++) {
			soupgrid[k][j] = s.charAt(m);
		}
		return false;
	}
	
	private static boolean placeleft(int i, int j, String s) {
		for(int k = j, m = 0; m < s.length(); k--, m++) {
			soupgrid[i][k] = s.charAt(m);
		}
		return false;
	}
	
	private static boolean placeright(int i, int j, String s) {
		for(int k = j, m = 0; m < s.length(); k++, m++) {
			soupgrid[i][k] = s.charAt(m);
		}
		return false;

	}
	
	private static boolean placeupleft(int i, int j, String s) {
		for(int k = i-1, m = 0, n = j-1; m < s.length(); k--, n++, m++) {
			soupgrid[k][n] = s.charAt(m);
		}
		return false;
	}
	
	private static boolean placeupright(int i, int j, String s) {
		for(int k = i-1, m = 0, n = j+1; m < s.length(); k--, n++, m++) {
			soupgrid[k][n] = s.charAt(m);
		}
		return false;
	}
	
	private static boolean placedownleft(int i, int j, String s) {
		for(int k = i+1, m = 0, n = j-1;  m < s.length(); k++, n--, m++) {
			soupgrid[k][n] = s.charAt(m);
		}
		return false;
	}
	
	private static boolean placedownright(int i, int j, String s) {
		for(int k = i+1, m = 0, n = j+1; m < s.length(); k++, n++, m++) {
			soupgrid[k][n] = s.charAt(m);
		}
		return false;
	}
	
	public char[][] getSoupgrid() {
		return soupgrid;
	}

	public static void setSouplist(char[][] soup) {
		WSGenerator.soupgrid = soup;
	}

}

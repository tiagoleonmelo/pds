package P01;

import java.util.*;

public class WSSolver {
	
	private static char[][] soupgrid;
	private static List<String> wordslist;
	private static Map<String,List<String>> map;

 	public WSSolver(Puzzle puzzle)  {
		this.soupgrid = puzzle.getSoupgrid();
		this.wordslist = puzzle.getWordslist();
		this.map = new LinkedHashMap<>();
	}

 	public Map<String,List<String>> find() {
 		for(String s : wordslist) {
 			map.put(s, findword(s));
 		}
 		return map;
 	}
 	
	private static List<String> findword(String s) {
		List<String> list = new ArrayList<>();
		for(int i = 0; i < soupgrid.length; i++) {
            for(int j = 0; j < soupgrid.length; j++) {
            	
            	if(s.charAt(0) == soupgrid[i][j]) {
	            	if(i + s.length() < soupgrid.length && finddown(i,j,s)) {
	            		//System.out.printf("%-15s %-5d %d,%-3d %s\n", s, s.length(), (i+1), (j+1), Position.Down.toString());
	            		list.add(Position.Down.toString()); list.add(Integer.toString(i+1)); list.add(Integer.toString(j+1));
	            		return list;
	            	}else if(i - s.length() >= 0 && findup(i,j,s)) {
	                	//System.out.printf("%-15s %-5d %d,%-3d %s\n", s, s.length(), (i+1), (j+1), Position.Up.toString());
	                	list.add(Position.Up.toString()); list.add(Integer.toString(i+1)); list.add(Integer.toString(j+1));
	            		return list;
	            	}else if(j + s.length() < soupgrid.length && findright(i,j,s)) {
	            		//System.out.printf("%-15s %-5d %d,%-3d %s\n", s, s.length(), (i+1), (j+1), Position.Right.toString());
	            		list.add(Position.Right.toString()); list.add(Integer.toString(i+1)); list.add(Integer.toString(j+1));
	            		return list;
	            	}else if(j - s.length() >= 0 && findleft(i,j,s)) {
	                	//System.out.printf("%-15s %-5d %d,%-3d %s\n", s, s.length(), (i+1), (j+1), Position.Left.toString());
	                	list.add(Position.Left.toString()); list.add(Integer.toString(i+1)); list.add(Integer.toString(j+1));
	            		return list;
	            	}else if(i - s.length() >= 0 && j - s.length() >= 0 && findupleft(i,j,s)) {
	                	//System.out.printf("%-15s %-5d %d,%-3d %s\n", s, s.length(), (i+1), (j+1), Position.Up_Left.toString());
	                	list.add(Position.Up_Left.toString()); list.add(Integer.toString(i+1)); list.add(Integer.toString(j+1));
	            		return list;
	            	}else if(i + s.length() < soupgrid.length && j + s.length() < soupgrid.length && finddownright(i,j,s)) {
	            		//System.out.printf("%-15s %-5d %d,%-3d %s\n", s, s.length(), (i+1), (j+1), Position.Down_Right.toString());
	            		list.add(Position.Down_Right.toString()); list.add(Integer.toString(i+1)); list.add(Integer.toString(j+1));
	            		return list;
	            	}else if(i - s.length() >= 0 && j + s.length() < soupgrid.length && findupright(i,j,s)) {
	                	//System.out.printf("%-15s %-5d %d,%-3d %s\n", s, s.length(), (i+1), (j+1), Position.Up_Right.toString());
	                	list.add(Position.Up_Right.toString()); list.add(Integer.toString(i+1)); list.add(Integer.toString(j+1));
	            		return list;
	            	}else if(i + s.length() < soupgrid.length && j - s.length() >= 0 && finddownleft(i,j,s)) {
	            		//System.out.printf("%-15s %-5d %d,%-3d %s\n", s, s.length(), (i+1), (j+1), Position.Down_Left.toString());
	            		list.add(Position.Down_Left.toString()); list.add(Integer.toString(i+1)); list.add(Integer.toString(j+1));
	            		return list;
	            	}
            	}
            }
		}
		return list;
    }

	private static boolean finddown(int i, int j, String s) {
		String word = Character.toString(soupgrid[i][j]);
		
		for(int k = i+1; k < i+s.length(); k++) {
			word += Character.toString(soupgrid[k][j]);
		}
		//System.out.println("down");
	    	return s.equals(word);
	    }
	    
	private static boolean findup(int i, int j, String s) {
		String word = Character.toString(soupgrid[i][j]);
		
		for(int k = i-1; k > i-s.length(); k--) {
			word += Character.toString(soupgrid[k][j]);
		}
		//System.out.println("up");
		return s.equals(word);
	}
	
	private static boolean findleft(int i, int j, String s) {
		String word = Character.toString(soupgrid[i][j]);
		
		for(int k = j-1; k > j-s.length(); k--) {
			word += Character.toString(soupgrid[i][k]);
		}
		//System.out.println("left");
		return s.equals(word);
	}
	
	private static boolean findright(int i, int j, String s) {
		String word = Character.toString(soupgrid[i][j]);
		
		for(int k = j+1; k < j+s.length(); k++) {
			word += Character.toString(soupgrid[i][k]);
		}
		//System.out.println("right");
		return s.equals(word);
	}
	
	private static boolean findupleft(int i, int j, String s) {
		String word = Character.toString(soupgrid[i][j]);
		
		for(int k = i-1, n = j-1; k > i-s.length() && n > j-s.length(); k--, n--) {
				word += Character.toString(soupgrid[k][n]);
		}
		//System.out.println(word + i + j);
		return s.equals(word);
	}
	
	private static boolean findupright(int i, int j, String s) {
		String word = Character.toString(soupgrid[i][j]);
		
		for(int k = i-1, n = j+1; k > i-s.length() && n < j+s.length(); k--, n++) {
				word += Character.toString(soupgrid[k][n]);
		}
		//System.out.println(word + i + j);
		return s.equals(word);
	}
	
	private static boolean finddownleft(int i, int j, String s) {
		String word = Character.toString(soupgrid[i][j]);
		
		for(int k = i+1, n = j-1; k < i+s.length() && n > j-s.length(); k++, n--) {
				word += Character.toString(soupgrid[k][n]);
		}
		//System.out.println(word + i + j);
		return s.equals(word);
	}
	
	private static boolean finddownright(int i, int j, String s) {
		String word = Character.toString(soupgrid[i][j]);
		
		for(int k = i+1, n = j+1; k < i+s.length() && n < j+s.length(); k++, n++) {
				word += Character.toString(soupgrid[k][n]);
		}
		//System.out.println(word + i + j);
		return s.equals(word);
	}

	
}

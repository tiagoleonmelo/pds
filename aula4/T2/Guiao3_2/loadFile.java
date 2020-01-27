package Guiao3_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;

public class loadFile {
	private ArrayList <String> commands;
	private ArrayList <Person> PersonList;
	private TreeMap <Integer,ArrayList<Person>> Map;
	
	public loadFile () {
		commands = new ArrayList <>();
		PersonList = new ArrayList <>();
		Map = new TreeMap <>();;
;	}
	
	public void read (String nameFile)
	{
		File fl = new File("C:\\Users\\Andre\\eclipse-workspace\\PDS\\" + nameFile);
		Scanner sc = null;
		try 
		{
			sc = new Scanner(fl);
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Ficheiro em falta!!!\n" + e);
		}
		
		while(sc.hasNextLine()) 
		{
			String line = sc.nextLine();
			String[] words_array = line.split(" ");
			if (words_array[0].equals("add")) {
				Person p1 = new Person (words_array[1],Integer.parseInt(words_array[2]), Integer.parseInt(words_array[3]));
				PersonList.add(p1);				
				                                                                
			}
			else {
				commands.add(words_array[0]);
			}
			
		}	
		
		
		
	}
	public ArrayList <String> getCommands() {
		return commands;
	}
	public ArrayList <Person> getPersonList() {
		return PersonList;
	}

	
	
	
	
}

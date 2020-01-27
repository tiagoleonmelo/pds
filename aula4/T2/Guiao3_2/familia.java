package Guiao3_2;

import java.util.*;
import java.util.Map.Entry;


public class familia  {
	
	private ArrayList <Person> family = new ArrayList <>();;
	private ArrayList <ArrayList <Person> > Rua = new ArrayList <>(); //usar na classe rua
	private ArrayList <Integer> habitaciones;
	private TreeMap <Person, ArrayList <Integer> > localizacao = new TreeMap <>(); // contem o start e o end das portas dos habitantes
	private TreeMap <ArrayList <Integer>, ArrayList<Person> > position_fam = new TreeMap <>(); // contem as posicoes de todas as familias
	
	public familia (loadFile data) {
		ArrayList <Person> PersonList = data.getPersonList();
		for (int i = 0; i < PersonList.size(); i++) {
			habitaciones = new ArrayList <Integer> ();
			Person person =  PersonList.get(i);
			//System.out.println(person.toString());
			habitaciones.add(person.getStart());
			habitaciones.add(person.getEnd());
			//System.out.println(habitaciones.get(0) + "	" + habitaciones.get(1));
			
			for (Entry<ArrayList<Integer>, ArrayList<Person>> entry : position_fam.entrySet()){
				
				if(entry.getKey().get(0) == habitaciones.get(0) && entry.getKey().get(1) == habitaciones.get(1) ) {					
					System.out.println(person.toString());
					position_fam.get(habitaciones).add(person);
					System.out.println(person.toString());
					System.out.println(position_fam.get(habitaciones));
				}
				else {
					System.out.println(person.toString());
					family.add(person);
					position_fam.put(habitaciones,family);
					System.out.println(person.toString());
					family = new ArrayList <> ();
				}
				//System.out.println(person.toString());
				//System.out.println("1234");
		}
		}	
			
			
/**
			for (Entry <Person, ArrayList <Integer>> entry : localizacao.entrySet()) {
				family = new ArrayList <>();
				if (entry.getValue() == habitaciones) {
					addMember(person);
					addMember(entry.getKey());
					Rua.add(family);
				}
				else {
					
				}
				
	**/			
		
				
		}
			



	public TreeMap<ArrayList<Integer>, ArrayList<Person>> getPosition_fam() {
		return position_fam;
	}





			/**
			for (ArrayList <Integer> morada : localizacao.values()) {
				  if (morada.get(0) == person.getStart() && morada.get(1) == person.getEnd()) {
					  addMember(person);
				  }
			}	
			
			for (Entry <Person, ArrayList<Integer>> entry : localizacao.entrySet()) {
	            if (entry.getValue().equals("c")) {
	                System.out.println(entry.getKey());
	            }
			}
			**/
		
	
	
	public void addMember (Person person){
		family.add(person);
	}
	
}

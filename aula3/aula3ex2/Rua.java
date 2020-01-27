package aula3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

public class Rua {
	
	private HashMap<Integer, Familia> street = new HashMap<Integer, Familia>();
	
	//TODO: ident the things properly;
	
	public Rua(File file, boolean commandFile) throws FileNotFoundException {
		
		Scanner sc;
		
		if(commandFile) {
			sc = new Scanner(file);
		}else {		
			sc = new Scanner(System.in);
		}
		
		String op;
		String[] words;

loopie:	while(true) {
	
			if(!commandFile)
				System.out.print("Load, Map, Add, Remove, List, Lookup, Clear, Quit\nCommand: ");
			
			op = sc.nextLine();
			words = op.split(" ");
			
			switch(words[0].toLowerCase()) {
			
				case "load":
					if(words.length != 2) {
						System.out.println("ERRO_LOAD: Nr de Args errado");
						break;
					}
					fileRead(words[1]);
					break;
					
				case "map":
					System.out.print(toString());
					break;
					
				case "add":
					if(words.length != 4) {
						System.out.println("ERRO_ADD: Nr de Args errado");
						break;
					}
					add(words[1], Integer.parseInt(words[2]), Integer.parseInt(words[3]));
					break;
					
				case "remove":
					if(words.length != 2) {
						System.out.println("ERRO_REMOVE: Nr de Args errado");
						break;
					}
					remove(words[1]);
					break;
					
				case "list":
					list();
					break;
					
				case "lookup":
					if(words.length != 2) {
						System.out.println("ERRO_LOOKUP: Nr de Args errado");
						break;
					}
					lookup(words[1]);
					break;
					
				case "clear":
					System.out.println("Clearing the Street Info..");
					clear();
					break;
					
				case "quit":
					System.out.println("Quitting..");
					break loopie;
					
				default:
					System.out.println("Select a valid option");
					break;
			}
			
		}
		
		sc.close();

	}
	
	public void add(String nome, int x1, int x2) {
		
		Intervalo inter = Intervalo.newIntervalo(x1, x2);
		Membro m = Membro.newMembro(nome, inter);
		Familia temp;
		
		for(Integer i : this.street.keySet()) {		// n gosto de isto aqui - verificaçao da condiçao 1
			
			if(this.street.get(i).containsMember(nome)) {
				
				System.out.println("ERRO: Esse nome já esta em uso");
				return;
				
			}
			
		}
		
		for(int i = x1-1; i <= x2-1; i++) {		// inserting the new member in every location
			
			temp = this.street.get(i);
			
			if(temp == null) {
				street.put(i, new Familia());
			}
			
			this.street.get(i).add(m);
			

		}
		
	}
	
	public void fileRead(String filename) throws FileNotFoundException {
		
		File file = new File(filename);
		Scanner sc = new Scanner(file);
		String line;
		String[] words;
		
		while(sc.hasNextLine()) {
			
			line = sc.nextLine();
			
			if(line.startsWith(">")) {
				continue;
			}
						
			words = line.split("[- ]");
			add(words[2],Integer.parseInt(words[0]),Integer.parseInt(words[1]));
		}
		
		sc.close();
		
	}
	
	public void remove(String name) {
		boolean erro = true;
		
		for(Integer i : this.street.keySet()) {
		
			if(this.street.get(i).removeMember(name)) {	// tentar remover o membro de todas as familias
				erro = false;
				
				for(int j = Collections.max(this.street.keySet(),null); j >= 0 ; j--) {					
					if(this.street.get(j).isEmpty()) {
						this.street.remove(j);
					}else {
						break;
					}
					
				}
			}	
			
		}
		
		if(erro) {		
			System.out.println("ERRO_RMV: Esse nome não existe nesta rua");
		}
		
		
	}
	
	public void list() {
		TreeSet<Membro> set = new TreeSet<>();
		for(int i : this.street.keySet()) {	// getting the family in a given number
			
			for(Intervalo inter : this.street.get(i).members.keySet()) {	// getting the members in a given intervalo
				
				for(Membro m : this.street.get(i).members.get(inter)) {
										
					set.add(m);
					
				}
				
			}
			
		}
		
		for(Membro m : set) {
			
			System.out.println(m + " " + m.getInter());
			
		}
	}
	
	public void lookup(String name) {
		
		// eu quero o intervalo onde este nome se encontra e todos os membros q estao nesse intervalo
		Familia temp;
		
loopie:	for(Integer i : this.street.keySet()) {		// :/
			
			if(this.street.get(i).containsMember(name)) {
				
				temp = this.street.get(i);
				
				for(Intervalo inter : temp.members.keySet()) {
					
					for(Membro m : temp.members.get(inter)) {
						
						if(m.getNome().equals(name)) {
							
							System.out.println(inter + " : "+name); // fix this
							break loopie;
							
						}
						
					}
					
				}
				
			}
			
		}
		
	}
	
	public void clear() {
					
		this.street.clear(); 	// clearing every entry on the map
			
	}
	
	public String toString() {
		String str = "";
		
		if(this.street.keySet().size() == 0) {
			str+="Map is Empty\n";
			return str;
		}
		
		for(int i = 0; i <= Collections.max(this.street.keySet(),null); i++) {
			
			str+=Integer.toString(i+1) + "	" + (street.get(i) == null ? " " : street.get(i)) + "\n";
			
		}
		
		return str;
	}
		

	public static void main(String[] args) throws FileNotFoundException {
		
		int nargs = args.length;
		File file = null;
		boolean commandFile = false;
		if(nargs == 1) {
			file = new File(args[0]);
			commandFile = true;
		}
	
		new Rua(file, commandFile);
		
	}

}

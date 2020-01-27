//package aula3_ex2;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFrom  {
	
	private String filename;
	private List <String> content;
	private List<Member> group;
	
	public ReadFrom(String filename){
		this.filename=filename;
		content = new ArrayList<>();
		group = new ArrayList<>();
	}
	
	public void insertFromFile(){
		Scanner sc;
		try {
			sc= new Scanner(new File(filename));
			
			while(sc.hasNext()){
				String aux = sc.nextLine();
				if(!aux.contains(">")){
					aux = aux.replace("-", " ");
					content.add(aux);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public List<String> getContent() {
		
		return content;
	}
	
	public List<Member> splitIntoMember(){
			
		Scanner sc;
		int x1;
		int x2;
		String nome;
		Member member;
		for(int i = 0; i<content.size();i++){
			String aux = content.get(i);
			sc=new Scanner(aux);
			while(sc.hasNext()){
				x1 = sc.nextInt();
				x2 = sc.nextInt();
				nome = sc.next();
				member = new Member(nome, x1, x2);
				if(member.validName()){
					group.add(member);
				}
				//System.out.println(x1+" " + x2+" " + nome); //Dedug
				
			}
		}
		return group;

	}
	public List<Member> getGroup()
	{
		return group;
	}
	
	
	
	
	

}







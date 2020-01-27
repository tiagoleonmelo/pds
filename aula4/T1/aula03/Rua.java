//package aula3_ex2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Rua {

	private List<Member> place;
	private ReadFrom read;

	public List<Member> getMember() {
		return place;
	}

	public void addMember(Member mem) {
		place.add(mem);
	}

	public boolean removeMember(String memName) {
		boolean rem=false;
		for (int i = 0; i < place.size(); i++) {
			if (place.get(i).getNome().equals(memName)) {
				place.remove(i);
				rem=true;
			}
			else
				rem=false;
		}
		return rem;
	}

	public void searchMember(String nome) {
		for (int i = 0; i < place.size(); i++) {
			Member test = place.get(i);
			if (test.getNome().equals(nome)) {
				System.out.println(test.getX1() + "-" + test.getX2() + " " + test.getNome());
			}
		}
	}
	
	public void searchX1(int x1){
		for (int i = 0; i < place.size(); i++) {
			Member test = place.get(i);
			if (test.getX1()==x1) {
				System.out.println(test.getNome());
			}
		}
	}
		
	

	public void list() {
		OrdenaRua comparator = new OrdenaRua();
		Collections.sort(place, comparator);

	}

	public Rua() {
		place = new ArrayList<>();
	}

	public void loadFileName(String f) {
		read = new ReadFrom(f);
		read.insertFromFile();
		place = read.splitIntoMember();

	}
	
	public void clear(){
		place.clear();
	}
	
	public void lookUp(String name)
	{
		int[] intervalo=new int[2];
		Familia f=new Familia();
		boolean exist=false;
		for(int i=0;i<place.size();i++)
		{
			if(place.get(i).getNome().equals(name))
			{
				intervalo[0]=place.get(i).getX1();
				intervalo[1]=place.get(i).getX2();
				exist= true;
			}

		}
		if (exist == true) {
			for (int i = 0; i < place.size(); i++) {
				if (place.get(i).getX1() >= intervalo[0]
						&& place.get(i).getX2() <= place.get(i).getX2()) {
					f.addMember(place.get(i));
				}
			}
			List<Member> l=f.getGroup();
			System.out.print(intervalo[0]+ " "+ intervalo[1]+": ");
			for(int i=0;i<f.getGroup().size();i++)
			{
				System.out.print(""+ f.group.get(i).getNome()+" ");	
			}
			System.out.println("");


		}

		
	}

	public String toString() {
		String s = "";
		for (Member i : place) {
			s += i.toString() + "\n";
		}
		return s;
	}


}

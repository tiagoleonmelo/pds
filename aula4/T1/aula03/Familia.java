//package aula3_ex2;

import java.util.ArrayList;
import java.util.List;

public class Familia {
	List<Member> group;


	public Familia() {
		group = new ArrayList<>();
	}

	public void addMember(Member mem) {

		group.add(mem);
		
	}

	public void removeMember(Member mem) {

		for (int i = 0; i < group.size(); i++) {
			if (group.get(i).equals(mem)) {
				group.remove(i);
			}
		}
	}

	public String toString() {
		String s = "";
		for (int i = 0; i < group.size(); i++) {
			s += group.get(i).toString() + "\n";
		}
		return s;
	}

	public void searchMember(String nome) {
		for (int i = 0; i < group.size(); i++) {
			Member test = group.get(i);
			if (test.getNome().equals(nome)) {
				System.out.println(test.getX1() + "-" + test.getX2() + " " + test.getNome());
			}
		}
	}

	public int size() {
		return group.size();
	}

	public List<Member> getGroup() {
		return group;
	}

}

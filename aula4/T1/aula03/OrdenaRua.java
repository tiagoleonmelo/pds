//package aula3_ex2;

import java.util.Comparator;

public class OrdenaRua implements Comparator<Member> {
	public int compare(Member m1,Member m2)
	{
		  return m1.getNome().
	                compareTo(m2.getNome());
	}

}

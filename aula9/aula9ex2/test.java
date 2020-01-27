package aula9ex2;

import java.util.ArrayList;
import java.util.Collection;

public class test {

	public static void main(String[] args) {
		Controller<Double> a= new Controller<>();
		
		ArrayList<Double> list=new ArrayList<>();
		
		GenericCollection<Double> col=new GenericCollection<>(list); 
		
		Command<Double> c1=new AddElementCom<Double>(col);
		Command<Double> c2=new DelElementCom<Double>(col);
		
		a.setCom(c1);
		a.execute(3.4);
		print(list);
		a.execute(7.8);
		print(list);
		a.undo();
		print(list);
		a.execute(10.0);
		print(list);
		
		System.out.println("mudança comando");
		
		a.setCom(c2);
		print(list);
		a.execute(3.4);
		print(list);
		a.undo();
		print(list);

	}
	public static <E> void print(Collection<E> c) {
		System.out.print("--");
		for (E el: c) {
			System.out.print(el+"-");
		}
		System.out.println("--");
		
	}

}

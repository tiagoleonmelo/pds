package aula11ex1;

import java.util.ArrayList;

public class demo {

	public static void main(String[] args) {
		Telemovel t1=new Telemovel("QuadCore",125.99,32,"5mp");
		Telemovel t2=new Telemovel("OctaCore",510.99,8,"10mp");
		Telemovel t3=new Telemovel("QuadCore",235.99,32,"12mp");
		ArrayList<Telemovel> catalogo= new ArrayList<>();
		
		catalogo.add(t1);
		catalogo.add(t2);
		catalogo.add(t3);

		Revista c = new Revista(catalogo);
		c.setStrategy(new BubbleSort());
		System.out.println("Result: " + c.sort(Attribute.PRECO));
		System.out.println("Result: " + c.sort(Attribute.MEMORIA));
		System.out.println("Result: " + c.sort(Attribute.CAMARA));
		
	}

}
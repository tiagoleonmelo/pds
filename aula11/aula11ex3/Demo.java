package aula11ex3;

import java.util.ArrayList;

public class Demo {

	public static void main(String[] args) {
		Book l1= new Book("O silencio dos inocentes",1234,1999,"autor1");
		l1.setState(new Inventario());
		Book l2= new Book("Lord of the Flies",1678,1990,"autor2");
		l2.setState(new Inventario());
		Book l3= new Book("Harry Potter",1498,1976,"autor3");
		l3.setState(new Inventario());
		ArrayList<Book> biblioteca= new ArrayList<>();
		biblioteca.add(l1);
		biblioteca.add(l2);
		biblioteca.add(l3);
		
		Biblioteca b =new Biblioteca(biblioteca);
		
		b.operacao(0, operation.regista);
		b.operacao(0, operation.devolve);
		b.operacao(0, operation.requisita);
		b.operacao(2, operation.regista);
	}

}

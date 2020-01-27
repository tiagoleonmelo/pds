package aula9exercicio1;

import java.util.Iterator;
import java.util.ListIterator;

public class VectorGenericTest {

	public static void main(String[] args) {
		
		//# Initializing Vector #//
		
		VectorGeneric<Integer> test = new VectorGeneric<>();
		
		for(int i = 0; i < 10; i++)
			test.addElem(i);
		
		/*########################*/
		
		Iterator<Integer> it = test.Iterator();
		Iterator<Integer> iter = test.Iterator();
		

		System.out.print("Testing the Iterator() method and applying both instances to the same collection:\n>>> ");

		while(it.hasNext()) {
			System.out.print(it.next() + "; ");
		}
		System.out.print("\n>>> ");
		
		while(iter.hasNext()) {
			System.out.print(iter.next() + "; ");
		}
		System.out.println();
		
		/*#################################################################*/

		System.out.print("Testing the listIterator() method and applying both instances to the same collection: \n>>> ");

		ListIterator<Integer> lit1 = test.listIterator();
		ListIterator<Integer> lit2 = test.listIterator();

		while(lit1.hasNext()) {
			System.out.print(lit1.next() + "; ");
		}
		System.out.print("\n>>> ");

		while(lit2.hasNext()) {
			System.out.print(lit2.next() + "; ");
		}
		System.out.println();

		/*#################################################################*/
		
		System.out.print("Testing the listIterator(int) method and applying both instances to the same collection: \n>>> ");

		ListIterator<Integer> litIndex1 = test.listIterator(5);
		ListIterator<Integer> litIndex2 = test.listIterator(2);
		// ListIterator<Integer> litIndex3 = test.listIterator(60);

		while(litIndex1.hasNext()) {
			System.out.print(litIndex1.next() + "; ");
		}
		System.out.print("\n>>> ");

		while(litIndex2.hasNext()) {
			System.out.print(litIndex2.next() + "; ");
		}
		System.out.println();

	}

}

package aula6ex2;

public class Main {

	public static void main(String[] args) {
		
		// list of contacts were gonna be using throughout our demo
		
		Contact c1=new Contact(538, "Johnny Banana");
		Contact c2=new Contact(478932, "Undercity Huckster");
		Contact c3=new Contact(7428, "Amgems");
		Contact c4=new Contact(1, "Maria");
		Contact c5=new Contact(420, "Bug");

		// same storage can be used by virtually any contact list, so we only need to create one of each type		
		ContactStorageTXT txt = new ContactStorageTXT();	// txt storage
		ContactStorageBIN bin= new ContactStorageBIN();		// binary storage

		ContactList cl= new ContactList();	// empty contact list that isnt associated with any storage
		
		cl.add(c1);
		cl.add(c2);
		cl.add(c3);
		cl.add(c4);	
		cl.add(c5);	

		System.out.println("Contact list before being saved:\n >>> " + cl+"\n");
		
		cl.saveAndClose(txt);
		System.out.println("Contact list after being saved to a file:\n >>> " + cl+"\n");

		cl.openAndLoad(txt);
		System.out.println("Contact list after being read from a file:\n >>> " + cl+"\n");
		
		// // // // // // // // // // // // // // // // // // // // // // // // // // // // // // 
		
		ContactList cl1=new ContactList(txt); // different constructor now (associated with a txt storage)

		cl1.add(c1);
		cl1.add(c2);
		cl1.add(c3);
		cl1.add(c4);
		
		System.out.println("Contact list1 (made with a store) before being saved:\n >>> " + cl1+"\n");

		cl1.saveAndClose();
		System.out.println("Contact list1 (made with a store) after being saved to a txt file:\n >>> " + cl1+"\n");

		cl1.openAndLoad(txt);
		System.out.println("Contact list1 (made with a store) after being read from a txt file:\n >>> " + cl1+"\n");
		
		// Lets save the contacts to a binary file now
				
		cl1.saveAndClose(bin);
		System.out.println("Contact list1 (made with a store) after being saved to a binary file:\n >>> " + cl1+"\n");

		cl1.openAndLoad(bin);
		System.out.println("Contact list1 (made with a store) after being read from a binary file:\n >>> " + cl1+"\n");


	}
}

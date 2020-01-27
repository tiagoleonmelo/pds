package aula6ex2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ContactStorageBIN implements ContactsStorageInterface{
	
	FileOutputStream output;
	FileInputStream input;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Contact> loadContacts() {
		try {
			input = new FileInputStream(new File("contacts"));
			ObjectInputStream oi = new ObjectInputStream(input);
			ArrayList<Contact> c = (ArrayList) oi.readObject();
			
			if(c == null || c.isEmpty()) {
				System.out.println("erro");
			}
			
			input.close();
			oi.close();
			
			System.out.println("read "+c+" from a binary file successfully");
			return c;
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error initializing stream [LOAD]");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return null;		
	}

	@Override
	public boolean saveContacts(List<Contact> list) {
		// write list in a txt file
		try {
			output = new FileOutputStream(new File("contacts"));
			ObjectOutputStream o = new ObjectOutputStream(output);
			
			o.writeObject(list);
			
			output.close();
			o.close();
			
			System.out.println("wrote "+list+" in a binary file successfully");
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			return false;
		} catch (IOException e) {
			System.out.println("Error initializing stream [SAVE]");
			return false;
		}
		
		return true;
	}

}

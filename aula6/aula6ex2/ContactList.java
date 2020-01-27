package aula6ex2;

import java.util.ArrayList;
import java.util.List;

public class ContactList implements ContactsInterface{

	private List<Contact> contactList;
	private ContactsStorageInterface store;	// we chose adding a possible attribute store to be possible to invoke the argumentless method saveAndClose()
	
	public ContactList() {
		this.contactList=new ArrayList<>();
	}
	
	public ContactList(ContactsStorageInterface store) {
		this.contactList=new ArrayList<>();
		this.store=store;
	}

	@Override
	public void openAndLoad(ContactsStorageInterface store) {
		// loads from file
		//store.saveContacts(this.contactList); // saving the already here contacts
		this.contactList=store.loadContacts(); // "appending" the contacts from the file
		this.store=store;
	}

	@Override
	public void saveAndClose() {
		// loads to file
		if(this.store != null) {
			store.saveContacts(contactList);
			return;
		}
		
		System.out.println("ERROR: No store associated with this conctact list");
	}

	@Override
	public void saveAndClose(ContactsStorageInterface store) {
		store.saveContacts(contactList);
	}

	@Override
	public boolean exist(Contact contact) {
		return this.contactList.contains(contact);
	}

	@Override
	public Contact getByName(String name) {
		for(Contact c : this.contactList) {
			if(c.getName().equals(name)) {
				return c;
			}
		}
		return null;
	}

	@Override
	public boolean add(Contact contact) {
		return this.contactList.add(contact);
	}

	@Override
	public boolean remove(Contact contact) {
		return this.contactList.remove(contact);
	}

	public List<Contact> getContactList() {
		return contactList;
	}

	public void setContactList(List<Contact> contactList) {
		this.contactList = contactList;
	}
	
	public String toString() {
		String s = "";
		
		for(Contact c : this.contactList) {
			s+=c+"; ";
		}
		
		return s;
	}
	
	
}

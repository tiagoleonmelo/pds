package aula6ex2;

public class Contact implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int number;
	private String name;
	
	public Contact(int number, String name) {
		super();
		this.number = number;
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name + ": "+number;
	}

}

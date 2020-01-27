package Guiao3_2;

public class Person {
	
	private String name;
	private int start;
	private int end;
	
	public Person (String name, int start, int end){
		this.name = name;
		this.start = start;
		this.end = end;
	}

	public String getName() {
		return name;
	}

	public int getStart() {
		return start;
	}

	public int getEnd() {
		return end;
	}

	@Override
	public String toString() {
		return  name;
	}
	
	
	
	
	
}

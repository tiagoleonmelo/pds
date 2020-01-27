package aula1;

public class Solution {
	
	private Point p;
	private Directions d;
	private String name;
	
	public Solution(Point p, Directions d, String name) {
		this.p = p;
		this.d = d;
		this.name = name;
	}

	@Override
	public String toString() {
		return name.toUpperCase() + "			" + name.length() + "	" + p + "	"+ d;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	// LIST           4      5,8    left 
	
	

}

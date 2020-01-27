package aula5ex2;

public class Lunch {
	private String drink;
	private String mainCourse;
	private String side;
	
	// remaining methods
	
	public String getDrink() {
		return drink;
	}
	public void setDrink(String drink) {
		this.drink = drink;
	}
	public String getMainCourse() {
		return mainCourse;
	}
	public void setMainCourse(String mainCourse) {
		this.mainCourse = mainCourse;
	}
	public String getSide() {
		return side;
	}
	public void setSide(String side) {
		this.side = side;
	}
	@Override
	public String toString() {
		return "Lunch [drink=" + drink + ", mainCourse=" + mainCourse + ", side=" + side + "]";
	}
	
}

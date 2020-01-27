package aula5ex2;

public class CentralCantineLunchBuilder implements LunchBuilder {
	
	private Lunch l = new Lunch();

	@Override
	public void buildDrink() {
		this.l.setDrink("Agua");
	}

	@Override
	public void buildMainCourse() {
		this.l.setMainCourse("Grelhada Mista");
	}

	@Override
	public void buildSide() {
		this.l.setSide("Queijo Fresco");
	}

	@Override
	public Lunch getMeal() {
		// TODO Auto-generated method stub
		return l;
	}

}

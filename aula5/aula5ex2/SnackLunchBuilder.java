package aula5ex2;

public class SnackLunchBuilder implements LunchBuilder {

	private Lunch l = new Lunch();

	@Override
	public void buildDrink() {
		this.l.setDrink("Sumo");
	}

	@Override
	public void buildMainCourse() {
		this.l.setMainCourse("Pão com panado");
	}

	@Override
	public void buildSide() {
		this.l.setSide("Rissol");
	}

	@Override
	public Lunch getMeal() {
		return l;
	}

}

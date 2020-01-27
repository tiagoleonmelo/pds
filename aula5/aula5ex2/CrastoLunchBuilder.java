package aula5ex2;

public class CrastoLunchBuilder implements LunchBuilder {
	
	private Lunch l = new Lunch();

	@Override
	public void buildDrink() {
		this.l.setDrink("Vinho Tinto");
	}

	@Override
	public void buildMainCourse() {
		this.l.setMainCourse("Bacalhau à Lagareiro");
	}

	@Override
	public void buildSide() {
		this.l.setSide("Broa");
	}

	@Override
	public Lunch getMeal() {
		return l;
	}

}

package aula5ex2;

public class LunchDirector {		// works like the waiter class in the Pizza example in the slides
	
	LunchBuilder lb;

	public LunchDirector(LunchBuilder lunchb) {
		this.lb = lunchb;
	}

	public void constructMeal() {
		lb.buildDrink();
		lb.buildMainCourse();
		lb.buildSide();	
	}
	
	public Lunch getMeal() {
		return lb.getMeal();
	}

}

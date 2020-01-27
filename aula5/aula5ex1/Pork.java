package aula5ex1;

public class Pork implements Commodity {

	@Override
	public Temperature getTemperature() {
		return Temperature.WARM;
	}

	@Override
	public State getState() {
		return State.Solid;
	}
	
	public String toString() {
		return "Pork " + this.getTemperature() + " and " + this.getState();
	}

}

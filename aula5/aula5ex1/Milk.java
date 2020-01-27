package aula5ex1;

public class Milk implements Commodity{

	@Override
	public Temperature getTemperature() {
		return Temperature.WARM;
	}

	@Override
	public State getState() {
		return State.Liquid;
	}
	
	public String toString() {
		return "Milk " + this.getTemperature() + " and " + this.getState();
	}
	
	

}

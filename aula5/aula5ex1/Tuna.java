package aula5ex1;

public class Tuna implements Commodity{

	@Override
	public Temperature getTemperature() {
		return Temperature.COLD;
	}

	@Override
	public State getState() {
		return State.Solid;
	}
	
	public String toString() {
		return "Tuna " + this.getTemperature() + " and " + this.getState();
	}

}

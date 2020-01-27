package aula5ex1;

public class FruitJuice implements Commodity{
	
	private Fruit FruitName=Fruit.Orange;

	@Override
	public Temperature getTemperature() {
		return Temperature.COLD;
	}

	@Override
	public State getState() {
		return State.Liquid;
	}
	
	public void setFruitName(Fruit fr) {
		this.FruitName = fr;
	}
	
	public Fruit getFruitName() {
		return this.FruitName;
	}
	
	public String toString() {
		return this.FruitName + " Juice, " + this.getTemperature() + " and " + this.getState();
	}
	
	

}

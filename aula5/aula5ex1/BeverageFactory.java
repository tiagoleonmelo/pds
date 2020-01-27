package aula5ex1;

public class BeverageFactory {

	public static Commodity createBeverage(Temperature t) {
		if(t.equals(Temperature.COLD)) {
			return new FruitJuice();
		}
		
		return new Milk();
	}

}

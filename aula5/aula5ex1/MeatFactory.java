package aula5ex1;

public class MeatFactory {

	public static Commodity createMeat(Temperature t) {
		if(t.equals(Temperature.COLD)) {
			return new Tuna();
		}
		
		return new Pork();
	}

}

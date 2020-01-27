package aula5ex1;

public class ContainerFactory {

	public static Container createContainerFor(Commodity commodity) {
		
		if(commodity.getState()==State.Liquid) {
			if(commodity.getTemperature()==Temperature.COLD)
				return new PlasticBottle();
			return new TermicBottle();
		}
		
		if(commodity.getTemperature()==Temperature.COLD)		// if we get to this point, commodity's state == solid
			return new PlasticBag();
		return new Tupperware();
		
	}

}

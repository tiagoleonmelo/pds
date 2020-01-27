package aula12ex2mvc.view;

import aula12ex2mvc.model.Thermometer;
import aula12ex2mvc.model.ThermometerListener;

public class ConsoleDisplay implements ThermometerListener {
	
	private Thermometer thermometer;

	public ConsoleDisplay(Thermometer t) {
		thermometer = t;
	}
	@Override
	public void temperatureChanged() {
		System.out.println("New temperature: " + thermometer.getTemperature());
		
	}

}

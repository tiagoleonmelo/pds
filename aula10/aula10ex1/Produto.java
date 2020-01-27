package aula10ex1;

import java.util.ArrayList;

public class Produto {
	
	private static int i = 0;
	private int id;
	private String descript;
	private double basePrice;
	private double price = 0;
	private STATE s;
	private Cliente highestBidder;
	
	private ArrayList<Observer> obs = new ArrayList<>();
	
	public Produto(String desc, double basePrice, STATE s) {
		this.descript=desc;
		this.basePrice=basePrice;
		this.s=s;
		this.id=i;
		i++;
	}
	
	public void attach(Observer o) {
		if(!this.obs.contains(o)) {
			this.obs.add(o);
		}
	}

	public STATE getS() {
		return s;
	}

	public void setS(STATE s) {
		this.s = s;
		notifyObservers();
	}
	
	public void setPrice(double price, Cliente c) {
		if(price > this.basePrice && price > this.price) {
			this.price = price;
			this.highestBidder = c;
			notifyObservers();
		}
	}
	
	private void notifyObservers() {
		for(Observer observ: this.obs) {
			observ.update();
		}
	}
	
	public double getPrice() {
		if(this.price == 0) {
			return this.basePrice;
		}
		return this.price;
	}
	
	@Override
	public String toString() {
		return descript + " ID: " + id + " STATE:"+this.s;
	}
	
	public Cliente getHighestBidder() {
		return this.highestBidder;
	}

}

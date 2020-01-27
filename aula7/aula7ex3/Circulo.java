package lab7ex3;

public class Circulo extends Figure {
	private String cor;

	public Circulo(String cor) {
		this.cor = cor;
	}

	@Override
	public void draw() {
		System.out.println(this.getClass().getSimpleName()+ " "+cor);
		
	}
	
	

}

package lab7ex3;

public class Quadrado extends Figure {
	private String cor;

	public Quadrado(String cor) {
		this.cor = cor;
	}

	@Override
	public void draw() {
		System.out.println(this.getClass().getSimpleName()+ " "+cor);
		
	}
	
	

}

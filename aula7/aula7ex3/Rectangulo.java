package lab7ex3;

public class Rectangulo extends Figure {
	private String cor;

	public Rectangulo(String cor) {
		this.cor = cor;
	}

	@Override
	public void draw() {
		System.out.println(this.getClass().getSimpleName()+ " "+cor);
		
	}
	
	

}

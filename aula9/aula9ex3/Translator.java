package aula9exercicio3;

public abstract class Translator {
	
	protected Translator nextTranslator = null;
	protected Language l;
	
	public Translator() {
	}
	
	public Translator(Translator nt) {
		this.nextTranslator = nt;
	}
	
	public abstract void handle(String h, Language l);
	
		
}

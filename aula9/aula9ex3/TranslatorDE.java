package aula9exercicio3;

public class TranslatorDE extends Translator {
	
	Language l = Language.DE;
	
	public TranslatorDE() {
	}

	public TranslatorDE(Translator nt) {
		super(nt);
	}

	@Override
	public void handle(String h, Language l) {
		
		if(l.equals(this.l)) {
			System.out.println("Ich realisiere PDS sehr gerne :)");
		}else {
			if(this.nextTranslator != null) {
				this.nextTranslator.handle(h, l);
			}else {
				System.out.println("There isn't a translator for the language " + l);
			}
		}
		
	}

}

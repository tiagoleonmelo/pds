package aula9exercicio3;

public class TranslatorUK extends Translator {
	
	Language l = Language.UK;
	
	public TranslatorUK() {
	}
	
	public TranslatorUK(Translator nt) {
		super(nt);
	}

	@Override
	public void handle(String h, Language l) {
		
		if(l.equals(this.l)) {
			System.out.println("I really wish I understood PDS :)");
		}else {
			if(this.nextTranslator != null) {
				this.nextTranslator.handle(h, l);
			}else {
				System.out.println("There isn't a translator for the language " + l);
			}
		}
		
	}

}

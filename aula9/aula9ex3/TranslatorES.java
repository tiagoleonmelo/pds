package aula9exercicio3;

public class TranslatorES extends Translator {
	
	Language l = Language.ES;

	public TranslatorES() {
	}
	
	public TranslatorES(Translator nt) {
		super(nt);
	}

	@Override
	public void handle(String h, Language l) {
		
		if(l.equals(this.l)) {
			System.out.println("Me gustaría ver PDS :)");
		}else {
			if(this.nextTranslator != null) {
				this.nextTranslator.handle(h, l);
			}else {
				System.out.println("There isn't a translator for the language " + l);
			}
		}
		
	}

}

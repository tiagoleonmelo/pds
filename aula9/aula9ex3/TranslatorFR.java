package aula9exercicio3;

public class TranslatorFR extends Translator{
	
	Language l = Language.FR;
	
	public TranslatorFR() {
	}
	
	public TranslatorFR(Translator nt) {
		super(nt);
	}

	@Override
	public void handle(String h, Language l) {
		
		if(l.equals(this.l)) {
			System.out.println("Je voulais vraiment réaliser PDS :)");
		}else {
			if(this.nextTranslator != null) {
				this.nextTranslator.handle(h, l);
			}else {
				System.out.println("There isn't a translator for the language " + l);
			}
		}
		
	}

}

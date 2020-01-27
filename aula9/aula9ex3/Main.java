package aula9exercicio3;

public class Main {

	public static void main(String[] args) {
		
		String translatable = "Gostava mesmo de perceber PDS :)";
		
		Translator translator = new TranslatorDE(new TranslatorES(new TranslatorFR(new TranslatorUK())));
		
		translator.handle(translatable, Language.DE);
		translator.handle(translatable, Language.ES);
		translator.handle(translatable, Language.FR);
		translator.handle(translatable, Language.UK);
		translator.handle(translatable, Language.NL);		

	}

}

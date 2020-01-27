package lab7ex3;

public class Main {

	public static void main(String[] args) {
		Bloco principal = new Bloco("Main");
		Bloco top = new Bloco("Top");
		Bloco bot = new Bloco("Bottom");
		top.add(new Rectangulo("jogo"));
		principal.add(top);
		principal.add(bot);
		bot.add(new Circulo("rosa"));
		bot.add(new Quadrado("verde"));
		top.add(new Bloco("Outra área"));
		principal.draw();
		
//		Bloco principal = new Bloco("Main"); //teste mais avançado
//		Bloco top = new Bloco("Top");
//		Bloco bot = new Bloco("Bottom");
//		top.add(new Rectangulo("jogo"));
//		principal.add(top);
//		principal.add(bot);
//		bot.add(new Circulo("rosa"));
//		bot.add(new Quadrado("verde"));
//		Bloco oa = new Bloco("Outra área");
//		oa.add(new Rectangulo("s"));
//		oa.add(new Circulo("s"));
//		Bloco m1=new Bloco("mais um bloco");
//		m1.add(new Circulo("dvgsf"));
//		oa.add(m1);
//		oa.add(new Rectangulo("bu"));
//		top.add(oa);
//		top.add(new Circulo("x"));
//		principal.draw();

	}

}

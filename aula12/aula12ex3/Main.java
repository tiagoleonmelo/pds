package aula12ex3;

public class Main {
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		Ship s = new Ship("BelaRia", 200);
		s.setOwner(new Owner("Manuel"));
		s.setPassageiros(new String[]{"Manuel", "Amilcar"});
		System.out.println( PDSSerializer.fromObject(s) );
	}
}

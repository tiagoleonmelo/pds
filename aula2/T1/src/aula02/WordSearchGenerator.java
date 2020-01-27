package aula02;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class WordSearchGenerator {

	@SuppressWarnings("resource")
	static char[][] sopa;
	static List<String> palavras;
	static int tam = 0;

	public static void main(String[] args) {
		String txt = "";
		Scanner in;
		Scanner sc=new Scanner(System.in);
		if(args.length==0)
		{
			System.out.println("introduza o nome do ficheiro de palavras");
			txt=sc.nextLine();
		}
		palavras = new ArrayList<>();
		try {
			in = new Scanner(new FileReader(txt));

			while (in.hasNext()) {
				String input = in.next().replaceAll(",", "");
				palavras.add(input);
			}
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(palavras.toString());

		in = new Scanner(System.in);

		while (tam <= 0) {
			System.out.print("Introduzir tamanho da sopa de letras: ");
			tam = in.nextInt();
			if (tam == 0)
				System.out.println("Tamanho tem de ser maior que 0 (zero)");
			else
				System.out.println("Tamanho escolhido " + tam + "x" + tam);
		}

		sopa = new char[tam][tam];
		// Possivelmente primeiro preencher com palavras e depois com chars
		// random
		for (int i = 0; i < tam; i++) {
			for (int j = 0; j < tam; j++) {

				Random r = new Random();
				char c = (char) (r.nextInt(26) + 'a');

				sopa[i][j] = Character.toUpperCase(c);
			}
		}
		// debug random char
		printPuzzle(sopa);

		// Inserir palavras criar

		Random idx = new Random();
		int pX = idx.nextInt(tam);
		int pY = idx.nextInt(tam);
		// escolha random do posicionamento da palavra
		Random pos = new Random();
		int aux = 1 + pos.nextInt(6);
		/*for (int i = 0; i < palavras.size(); i++) {
			positionWord(aux, tam, palavras.get(i)); // posiciona a palavra na
														// aux(horizontal/vertical/...)
		}*/
		insertHorizontalinv(0, 4, palavras.get(0));
		insertHorizontal(1, 0, palavras.get(1));
		insertUp(8, 0, palavras.get(2));
		insertDown(4, 9, palavras.get(3));
		insertDownRight(0, 9, palavras.get(4));
		insertDown(1, 0,palavras.get(0));
		System.out.println();
		printPuzzle(sopa);

	}

	public static void positionWord(int p, int tam, String palavra) {
		Random rx = new Random();
		Random ry = new Random();

		int x = 1 + rx.nextInt(tam - 1);
		int y = 1 + ry.nextInt(tam - 1);
		switch (p) {
		case 1:// horizontal
		{
			insertHorizontal(x, y, palavra);
			break;
		}
		case 2:// horizontalInv
		{
			insertHorizontalinv(x,y,palavra);
			break;
		}
		case 3:// down
		{
			insertDown(x, y, palavra);
			break;
		}
		case 4:// up
		{
			insertUp(x, y, palavra);
			break;
		}
		case 5:// down Right
		{
			insertDownRight(x, y, palavra);
		}
		case 6:// down Left
		{
			insertDownLeft(x, y, palavra);
		}

		}
	}

	public static boolean insertHorizontal(int x, int y, String palavra) {//
		int l=0;
		boolean valid=false;
		if(tam>(y+palavra.length()-1))//verifica se é possivel adicionar a palavra no sitio aleatorio
		{
			valid=true;
			for (int j = y; j < palavra.length(); j++) {

				{
					sopa[x][j] = palavra.charAt(l);
					l++;
				}
			}
		}
		return valid;


	}

	public static boolean insertHorizontalinv(int x, int y, String palavra)//
	{
	int l=0;
	boolean valid=false;
	if((y-(palavra.length()-1))>=0)//verifica se é possivel adicionar a palavra no sitio aleatorio
	{
		for(int j=y;j>0;j--)
		{
			sopa[x][j]=palavra.charAt(l);
			l++;
		}
	}
	return valid;
}
public static boolean insertDown(int x, int y, String palavra) //
{
	boolean valid = false;
	int l = 0;
	if ((x + palavra.length() -1 ) < (sopa.length)) {

		valid = true;
		for (int i = x; i < palavra.length()+x; i++) {
			sopa[i][y] = palavra.charAt(l);
			l++;
		}
	}
	return valid;

}

public static void insertUp(int x, int y, String palavra) {
	int l = 0;
	if ((x - (palavra.length() - 1)) >= 0) {
		for (int i = x; i > palavra.length() -(tam-x) ; i--) {
			sopa[i][y] = palavra.charAt(l);
			l++;
		}
	}
}


	public static void insertDownLeft(int x, int y,String palavra)
	{
		for(int l=0;l<palavra.length();l++)
		{
			for(int i=x;i<tam;i++)
			{
				for(int j=y;j!=-1;j--)
				{
					sopa[i][j]=palavra.charAt(l);
				}
			}
		}
	}
	public static void insertDownRight(int x, int y, String palavra)
	{

	}
	public static void printPuzzle(char[][] puzzle)
	{
		for (int i = 0; i < tam; i++) {
			for (int j = 0; j < tam; j++) {
				System.out.print(puzzle[i][j]);
				if (j == tam - 1)
					System.out.println("");
			}
		}
	}

}

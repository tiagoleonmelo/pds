package aula01;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFile {

	List<String> list = new ArrayList<>(); // lista com todo o conteúdo do
											// ficheiro
	String palavras = ""; // string com todas as palavras(inclui espaços e
							// virgulas)
	int tam = 0;// tamanho da sopa de letras
	char[][] sopaChar; // array bidimensional para armazenar os carateres da
						// sopa de letras
	String[] strPalavras; // array de palavras

	public ReadFile(String nomeFile,String tipoRead) {
		Scanner in;
		try {
			in = new Scanner(new FileReader(nomeFile));

			list.add(in.next());
			tam = list.get(0).length();

			// ler o conteudo do ficheiro
			while (in.hasNext()) {
				list.add(in.next());
			}
			if(tipoRead.equals("puzzle"))
			{
			// buscar as palavras
			searchWords();
			}


		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void searchWords()
	{
		for (int j = tam; j < list.size(); j++) {
			palavras += list.get(j) + " ";
		}
		palavras = palavras.replaceAll(",", "");
		strPalavras = palavras.split(" ");
		sopaChar = new char[tam][tam];

	}

	public void PrintPuzzle() {
		for (int i = 0; i < tam; i++) {
			for (int j = 0; j < tam; j++) {
				sopaChar[i][j] = list.get(i).charAt(j);
				System.out.print(sopaChar[i][j]);
			}
			System.out.println();
		}

	}

	public void printPalavras() {

		for (int i = 0; i < strPalavras.length; i++) {
			System.out.println(strPalavras[i]);
		}
	}

	public char[][] getPuzzle() {
		return sopaChar;
	}

	public String[] getPalavras() {
		return strPalavras;
	}
	public List<String> getList()
	{
		return this.list;
	}

}
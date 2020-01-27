package aula01;
import java.util.ArrayList;
import java.util.List;

public class Solver {
	long timing;
	int tam = 0;
	public static List<String> result = new ArrayList<>();; // strings com os
															// prints dos
															// resultados sas
															// posições
	char[][] sopaChar;
	String[] strPalavras;

	public Solver(char[][] sopaChar, String[] strPalavras) {
		tam = strPalavras.length;
		this.sopaChar = sopaChar;
		this.strPalavras = strPalavras;
		long start = System.currentTimeMillis();

		for (int s = 0; s < tam; s++) {
			findHorizontalinv(sopaChar, strPalavras[s]);
			findHorizontal(sopaChar, strPalavras[s]);
			findDown(sopaChar, strPalavras[s]);
			findUp(sopaChar, strPalavras[s]);
			findDownRight(sopaChar, strPalavras[s]);
			findDownleft(sopaChar, strPalavras[s]);

		}

		long end = System.currentTimeMillis();
		timing = end - start;
	}

	public static void findHorizontalinv(char[][] sopa, String palavra) {
		palavra = palavra.toUpperCase();
		int[] position = new int[2];
		int x = 0;
		int posx = 0;
		int posy = 0;
		for (int l = 0; l < palavra.length(); l++) {
			for (int i = sopa.length - 1; i != -1; i--) {
				for (int j = sopa[i].length - 1; j != -1; j--) {
					if (palavra.charAt(0) == sopa[i][j]) {
						posx = i;
						posy = j;
					}
					if (palavra.charAt(x) == sopa[i][j]) {
						x++;
					} else {
						x = 0;
					}
					if (x == palavra.length()) {
						position[0] = posx + 1;
						position[1] = posy + 1;
						x = 0;
					}

				}
			}
		}
		if (!(position[0] == position[1] && position[0] == 0)) {

			result.add(" " + palavra + "     " + palavra.length() + "     " + position[0] + "," + position[1]
					+ "     left");

		}

	}

	public static void findHorizontal(char[][] sopa, String palavra) {
		palavra = palavra.toUpperCase();
		int[] position = new int[2];
		int posx = 0;
		int posy = 0;
		int x = 0;
		for (int l = 0; l < palavra.length(); l++) {
			for (int i = 0; i < sopa.length; i++) {
				for (int j = 0; j < sopa.length; j++) {
					if (palavra.charAt(0) == sopa[i][j]) {
						posx = i;
						posy = j;
					}
					if (palavra.charAt(x) == sopa[i][j]) {
						x++;
					} else {
						x = 0;
					}
					if (x == palavra.length()) {
						position[0] = posx;
						position[1] = posy;
						x = 0;
					}

				}
			}
		}
		if (!(position[0] == position[1] && position[0] == 0)) {

			result.add(" " + palavra + "     " + palavra.length() + "     " + position[0] + "," + position[1]
					+ "     right");

		}
	}

	public static void findDown(char[][] sopa, String palavra) {
		palavra = palavra.toUpperCase();
		int[] position = new int[2];
		int x = 0;
		int posx = 0;
		int posy = 0;
		for (int l = 0; l < palavra.length(); l++) {
			for (int j = 0; j < sopa.length; j++) {
				for (int i = 0; i < sopa.length; i++) {
					if (palavra.charAt(0) == sopa[i][j]) {
						posx = i;
						posy = j;
					}
					if (palavra.charAt(x) == sopa[i][j]) {
						x++;
					} else {
						x = 0;
					}
					if (x == palavra.length()) {
						position[0] = posx + 1;
						position[1] = posy + 1;
						x = 0;
					}

				}
			}
		}
		if (!(position[0] == position[1] && position[0] == 0)) {

			result.add(" " + palavra + "     " + palavra.length() + "     " + position[0] + "," + position[1]
					+ "     down");
		}

	}

	public static void findUp(char[][] sopa, String palavra) {
		palavra = palavra.toUpperCase();
		int[] position = new int[2];
		int x = 0;
		int posx = 0;
		int posy = 0;
		for (int l = 0; l < palavra.length(); l++) {
			for (int j = 0; j < sopa.length; j++) {
				for (int i = sopa.length - 1; i != -1; i--) {
					if (palavra.charAt(0) == sopa[i][j]) {
						posx = i;
						posy = j;
					}
					if (palavra.charAt(x) == sopa[i][j]) {
						x++;
					} else {
						x = 0;
					}
					if (x == palavra.length()) {
						position[0] = posx + 1;
						position[1] = posy + 1;
						x = 0;
					}

				}
			}
		}
		if (!(position[0] == position[1] && position[0] == 0)) {

			result.add(
					" " + palavra + "     " + palavra.length() + "     " + position[0] + "," + position[1] + "     up");
		}

	}

	public static void findDownRight(char[][] sopa, String palavra) {
		palavra = palavra.toUpperCase();
		int[] position = new int[2];
		int x = 0;
		int posx = 0;
		int posy = 0;
		for (int l = 0; l < palavra.length(); l++) {
			for (int j = 0; j < sopa.length; j++) {
				for (int i = 0; i < sopa.length; i++) {
					if (j == sopa.length) {
						break;
					}
					if (palavra.charAt(0) == sopa[i][j]) {
						posx = i;
						posy = j;
					}
					if (palavra.charAt(x) == sopa[i][j]) {
						x++;

						if (j < sopa.length) {
							j++;

						}

					} else {
						x = 0;

					}
					if (x == palavra.length()) {
						position[0] = posx + 1;
						position[1] = posy + 1;
						x = 0;
					}

				}
			}
		}
		if (!(position[0] == position[1] && position[0] == 0)) {

			result.add(" " + palavra + "     " + palavra.length() + "     " + position[0] + "," + position[1]
					+ "     downright");

		}

	}

	public static void findDownleft(char[][] sopa, String palavra) {
		palavra = palavra.toUpperCase();
		int[] position = new int[2];
		int x = 0;
		int posx = 0;
		int posy = 0;
		for (int l = 0; l < palavra.length(); l++) {
			for (int j = sopa.length - 1; j > -1; j--) {
				for (int i = 0; i < sopa.length; i++) {
					if (j == 0) {
						break;
					}
					if (palavra.charAt(0) == sopa[i][j]) {
						posx = i;
						posy = j;
					}
					if (palavra.charAt(x) == sopa[i][j]) {
						x++;
						if (j > 0) {
							j--;
						}

					} else {
						x = 0;
					}
					if (x == palavra.length()) {
						position[0] = posx + 1;
						position[1] = posy + 1;
						x = 0;
					}
				}
			}
		}
		if (!(position[0] == position[1] && position[0] == 0))
			result.add(" " + palavra + "     " + palavra.length() + "     " + position[0] + "," + position[1]
					+ "     downleft");
	}

	public void printResult() {
		for (int i = 0; i < tam; i++) {
			System.out.println(result.get(i));
		}

	}

	public void printTiming() {
		System.out.println("Elapsed time (secs):" + timing);
	}

	public List getResult() {

		return result;
	}
}
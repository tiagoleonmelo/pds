package a1pdsg45;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class WordSoup {

	private ArrayList<String> words2find, puzzle;

	public WordSoup(File file) throws FileNotFoundException { // constructor using file
		Scanner sc = new Scanner(file);
		String line;
		String[] palavrastemp;
		this.puzzle = new ArrayList<>();
		this.words2find = new ArrayList<>();

		while (sc.hasNextLine()) {
			line = sc.nextLine();
			if (!line.contains(",") && !line.contains(" ") && !line.contains(";") && !line.isEmpty()) {
				puzzle.add(line);
				// System.out.println(line);
			} else {
				palavrastemp = line.trim().split("\\W+");
				for (String p : palavrastemp) {
					if (!p.isEmpty()) {
						// System.out.println(p);
						words2find.add(p);
					}

				}
			}

		}

		sc.close();

		if (puzzle.size() > 60) {
			System.out.println("Tamanho invalido >60");
			System.exit(0);
		}

		for (int i = 0; i < puzzle.size(); i++) { // verificar se a matriz da sopa de letras obedece a todas as regras

			String linha = puzzle.get(i);

			if (linha.length() != puzzle.size()) {
				System.out
						.println("ERRO: O tamanho da linha " + (i + 1) + " nao tem a dimensao certa " + puzzle.size());
				System.exit(0);
			}

			if (!linha.toUpperCase().equals(linha)) {
				System.out.println("ERRO: Formato invalido de case das letras");
				System.exit(0);
			}

			if (!isAlpha(linha)) {
				System.out.println(
						"ERRO: A linha " + (i + 1) + " nao e composta unicamente por carateres unicamente alfabeticos");
				System.exit(0);
			}
		}

		for (int i = 0; i < words2find.size(); i++) { // verificar se a lista de palavras obedece a todas as regras

			String palavra = words2find.get(i);

			if (palavra.length() < 3) {
				System.out.println("ERRO: A palavra " + palavra + " tem menos que 3 caracteres");
				System.exit(0);
			}

			if (!isAlpha(palavra)) {
				System.out.println("ERRO: A palavra " + palavra
						+ " nao e composta unicamente por carateres unicamente alfabeticos");
				System.exit(0);
			}

			for (int j = i + 1; j < words2find.size(); j++) {
				if (palavra.contains(words2find.get(j)) || words2find.get(j).contains(palavra)) {
					System.out.print("ERRO: Uma palavra a encontrar nao pode estar contida noutra");
					System.exit(0);
				}
			}

		}

	}

	public ArrayList<Point> findPositions(String s) { // devolve todas as coordenadas de cada ocorrencia da inicial da
														// palavra s
		ArrayList<Point> pontos = new ArrayList<>();
		String line;
		String c = Character.toString(s.charAt(0)).toUpperCase();
		for (int i = 0; i < puzzle.size(); i++) {
			line = puzzle.get(i);
			int index = line.indexOf(c);
			while (index >= 0) {
				pontos.add(new Point(i, index));
				index = line.indexOf(c, index + 1);
			}
		}

		return pontos;
	}

	public String[] omniWordFinder(Point p, int length) { // devolve um array com todas as palavras q partem da letra na
															// posicao p
		int y = p.getX(); // posicao da palavra no arraylist (estao ao contrario pq o output tmb esta :/)
		int x = p.getY(); // posicao do char na palavra
		char[][] wordsInChars = new char[8][length];
		String[] words = new String[8];
		int i;

		// chave (useful when designing the array and fetching the direction in the
		// enum)
		/*
		 * posi 0 -> right posi 1 -> downright posi 2 -> down posi 3 -> downleft posi 4
		 * -> left posi 5 -> up left posi 6 -> up posi 7 -> upright
		 */

		for (i = 0; i < length; i++) { // construcao de todas as palavras que podem partir de um dado ponto em todas as
										// direcoes
			if (x + i < puzzle.size())
				wordsInChars[0][i] = this.puzzle.get(y).charAt(x + i);

			if (y + i < puzzle.size())
				wordsInChars[2][i] = this.puzzle.get(y + i).charAt(x);

			if (x - i >= 0)
				wordsInChars[4][i] = this.puzzle.get(y).charAt(x - i);

			if (y - i >= 0)
				wordsInChars[6][i] = this.puzzle.get(y - i).charAt(x);

			if (x + i < puzzle.size() && y + i < puzzle.size())
				wordsInChars[1][i] = this.puzzle.get(y + i).charAt(x + i);

			if (x - i >= 0 && y + i < puzzle.size())
				wordsInChars[3][i] = this.puzzle.get(y + i).charAt(x - i);

			if (x - i >= 0 && y - i >= 0)
				wordsInChars[5][i] = this.puzzle.get(y - i).charAt(x - i);

			if (x + i < puzzle.size() && y - i >= 0)
				wordsInChars[7][i] = this.puzzle.get(y - i).charAt(x + i);

			/* Making sure nothing goes over the Arrays Bounds */
		}

		for (i = 0; i < 8; i++) { // converter o array bidimensional para um array de strings
			words[i] = new String(wordsInChars[i]);
		}

		return words;
	}

	public ArrayList<Solution> solver() { // devolve o ponto inicial da palavra, a dire�ao e a palavra
		ArrayList<Point> pontos = new ArrayList<>();
		ArrayList<Solution> solutions = new ArrayList<>();

		for (String s : this.words2find) {
			pontos = findPositions(s);

			for (Point p : pontos) {
				String[] words = omniWordFinder(p, s.length());

				if (Arrays.asList(words).contains(s.toUpperCase())) { // check if any of the returned words matches the
																		// desired one, and only after enter the loop

					for (int j = 0; j < 8; j++) {
						if (words[j].equals(s.toUpperCase()))
							solutions.add(new Solution(p, Directions.values()[j], s));
					}
				}
			}
		}

		return solutions;
	}

	public void printsol(ArrayList<Solution> solutions) {
		for (Solution sol : solutions) {
			System.out.println(sol);
		}
		for (String pal : words2find) {
			int flag = 0;
			for (Solution sol : solutions) {
				if (pal.equals(sol.getName())) {
					flag++;
				}
			}
			if (flag == 0) {
				System.out.println("WARNING! Not all words were found! -> " + pal);
			}
			if (flag > 1) {
				System.out.println("WARNING! The puzzle had duplicate words -> " + pal);
			}
		}
	}

	public boolean isAlpha(String name) { // devolve se uma palavra e composta unicamente por caracteres alfabeticos ou
											// nao
		return name.matches("[a-zA-Z]+");
	}

	public String PuzzleGenerator() throws FileNotFoundException { // generates the puzzle
		Scanner sc = new Scanner(System.in);
		System.out.println("Tamanho do puzzle? <=60");
		int size = sc.nextInt();
		while (size < 0 || size > 60) {
			System.out.println("Tamanho errado");
			System.out.println("Tamanho do puzzle? <=60");
			size=sc.nextInt();
		}
		char[][] puzzle = new char[size][size];
		sc.close();
		for (String word : this.words2find) {
			int len = word.length();
			int flag = 1;
			int x=-1;
			int y=-1;
			int dir=-1;
			while (flag == 1) {
				flag = 0;
				x = ThreadLocalRandom.current().nextInt(0, size - 1 + 1);
				y = ThreadLocalRandom.current().nextInt(0, size - 1 + 1);
				dir = ThreadLocalRandom.current().nextInt(1, 8 + 1);

				if (puzzle[x][y] == 0) {
					switch (dir) {
					case 1: // right
						if (y + len <= size) {
							int l;
							for (l = 0; l < len; l++) {
								if (puzzle[x][y + l] != 0) {
									flag = 1;
								}
							}
							if (flag == 0) {
								for (l = 0; l < len; l++) {
									puzzle[x][y + l] = Character.toUpperCase(word.charAt(l));
								}
							}

						} else {
							flag = 1;
						}
						break;
					case 2: // down
						if (x + len <= size) {
							int l;
							for (l = 0; l < len; l++) {
								if (puzzle[x + l][y] != 0) {
									flag = 1;
								}
							}
							if (flag == 0) {
								for (l = 0; l < len; l++) {
									puzzle[x + l][y] = Character.toUpperCase(word.charAt(l));
								}
							}
						} else {
							flag = 1;
						}
						break;
					case 3: // left
						if (y - len >= -1) {
							int l;
							for (l = 0; l < len; l++) {
								if (puzzle[x][y - l] != 0) {
									flag = 1;
								}
							}
							if (flag == 0) {
								for (l = 0; l < len; l++) {
									puzzle[x][y - l] = Character.toUpperCase(word.charAt(l));
								}
							}
						} else {
							flag = 1;
						}
						break;
					case 4: // up
						if (x - len >= -1) {
							int l;
							for (l = 0; l < len; l++) {
								if (puzzle[x - l][y] != 0) {
									flag = 1;
								}
							}
							if (flag == 0) {
								for (l = 0; l < len; l++) {
									puzzle[x - l][y] = Character.toUpperCase(word.charAt(l));
								}
							}
						} else {
							flag = 1;
						}
						break;
					case 5: // downright
						if (y + len <= size && x + len <= size) {
							int l;
							for (l = 0; l < len; l++) {
								if (puzzle[x + l][y + l] != 0) {
									flag = 1;
								}
							}
							if (flag == 0) {
								for (l = 0; l < len; l++) {
									puzzle[x + l][y + l] = Character.toUpperCase(word.charAt(l));
								}
							}
						} else {
							flag = 1;
						}
						break;
					case 6: // downleft
						if (x + len <= size && y - len >= -1) {
							int l;
							for (l = 0; l < len; l++) {
								if (puzzle[x + l][y - l] != 0) {
									flag = 1;
								}
							}
							if (flag == 0) {
								for (l = 0; l < len; l++) {
									puzzle[x + l][y - l] = Character.toUpperCase(word.charAt(l));
								}
							}
						} else {
							flag = 1;
						}
						break;
					case 7: // upright
						if (y + len <= size && x - len >= -1) {
							int l;
							for (l = 0; l < len; l++) {
								if (puzzle[x - l][y + l] != 0) {
									flag = 1;
								}
							}
							if (flag == 0) {
								for (l = 0; l < len; l++) {
									puzzle[x - l][y + l] = Character.toUpperCase(word.charAt(l));
								}
							}
						} else {
							flag = 1;
						}
						break;
					case 8: // upleft
						if (y - len >= -1 && x - len >= -1) {
							int l;
							for (l = 0; l < len; l++) {
								if (puzzle[x - l][y - l] != 0) {
									flag = 1;
								}
							}
							if (flag == 0) {
								for (l = 0; l < len; l++) {
									puzzle[x - l][y - l] = Character.toUpperCase(word.charAt(l));
								}
							}
						} else {
							flag = 1;
						}
						break;
					default: // updog
						System.err.println("it's the end of the world as we know it");
						break;
					}
				} else {
					flag = 1;
				}
			}
			System.out.println(word+" "+x+" "+y+" "+dir);
		}
		int a, b;
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		for (a = 0; a < size; a++) {
			for (b = 0; b < size; b++) {
				if (puzzle[a][b] == 0) {
					int rand = ThreadLocalRandom.current().nextInt(0, 25 + 1);
					char letra = alphabet.charAt(rand);
					letra = Character.toUpperCase(letra);
					puzzle[a][b] = letra;
				}
			}
		}
		String newpuzzlefile="newpuzzle.txt";
		PrintWriter writer = new PrintWriter(newpuzzlefile); //escreve o novo puzzle num ficheiro
		for (char[] x : puzzle) {
			for (char y : x) {
				System.out.print(y + "");
				writer.print(y + "");
			}
			System.out.println();
			writer.println();
		}
		for (String s : this.words2find) {
			writer.print(s + ",");
		}
		writer.close();
		
		return newpuzzlefile;
	}

}

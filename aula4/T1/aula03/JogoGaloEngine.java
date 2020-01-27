import java.util.Arrays;

public class JogoGaloEngine implements JGaloInterface {
	private char[][] table;	//Matriz para guardar cada posicao do tabuleiro
	private int size;		//Tamnho do lado do tabuleiro
	private char player;	//Jogador atual
	private boolean draw;	//Empate ou nao

	public JogoGaloEngine(int size) {
		table = new char[size][size];
		
		for (char[] l : table)
			Arrays.fill(l, ' ');

		player = 'X';
		
		this.size = size;
	}

	public JogoGaloEngine(int size, char first) {
		table = new char[size][size];
		
		for (char[] l : table)
			Arrays.fill(l, ' ');

		if (Character.toUpperCase(first) == 'O')
			player = 'O';
		else
			player = 'X';
		
		this.size = size;
	}

	@Override
	public char getActualPlayer() {
		return player;
	}

	@Override
	public boolean setJogada(int lin, int col) {
		//Se existe um draw significa que o tabuleiro está todo cheio, logo não podem ser feitas jogadas
		assert (!draw);
		
		table[lin - 1][col - 1] = player;

		//Alternar entre os vários jogadores
		player = player == 'O' ? 'X' : 'O';
		return false;
	}

	@Override
	public boolean isFinished() {
		return checkLines() || checkColumns() || checkDiagonal1() || checkDiagonal2() || checkEmpate();
	}

	@Override
	public char checkResult() {
		if (draw)
			return ' ';
		// Quem ganhou foi quem jogou na jogada anterior
		else
			return player == 'X' ? 'O' : 'X';
	}
	
	/**
	 * Percorre as varias linhas e verifica se alguma linha esta toda preenchida com o mesmo caracter
	 * 	referente a um jogador
	 * @return
	 * <li> true: Exite um vencedor
	 * <li> false: Vencedor nao encontrado
	 */
	private boolean checkLines() {
		char first;
lines: 	for (int l = 0; l < size; l++) {
			first = table[l][0];
			if (first == ' ')
				continue;
			for (int c = 1; c < size; c++)
				if (first != table[l][c])
					continue lines;

			return true;
		}
		return false;
	}
	
	/**
	 * Percorre as varias colunas e verifica se alguma coluna esta toda preenchida com o mesmo caracter
	 * 	referente a um jogador
	 * @return
	 * <li> true: Exite um vencedor
	 * <li> false: Vencedor nao encontrado
	 */
	private boolean checkColumns() {
columns:for (int c = 0; c < size; c++) {
			if (table[0][c] == ' ')
				continue;
			for (int l = 1; l < size; l++)
				if (table[0][c] != table[l][c])
					continue columns;

			return true;
		}
		return false;
		
	}
	
	/**
	 * Percorre a diagonal \ e verifica se esta está toda preenchida com o mesmo caracter
	 * 	referente a um jogador
	 * @return
	 * <li> true: Exite um vencedor
	 * <li> false: Vencedor nao encontrado
	 */
	private boolean checkDiagonal1() {
		if (table[0][0] == ' ')
			return false;
		for (int x = 1; x < size; x++)
			if (table[0][0] != table[x][x])
				return false;

		return true;
	}
	
	/**
	 * Percorre a diagonal / e verifica se esta está toda preenchida com o mesmo caracter
	 * 	referente a um jogador
	 * @return
	 * <li> true: Exite um vencedor
	 * <li> false: Vencedor nao encontrado
	 */
	private boolean checkDiagonal2 () {
		if (table[size-1][0] == ' ')
			return false;
		for (int x = 1; x < size; x++)
			if (table[size-1][0] != table[(size-1) - x][x])
				return false;

		return true;
	}
	
	/**
	 * Verica se todo o tabuleiro esta preenchido
	 * @return
	 * <li> true: Todo o tabuleiro preenchido, logo empate
	 * <li> false: Existem lugares a preencher
	 */
	private boolean checkEmpate() {
		for (int l = 0; l < size; l++)
			for (int c = 0; c < size; c++)
				if (table[l][c] == ' ')
					return false;
		
		draw = true;
		return true;
	}

}

package aula3;

public class JogoDoGalo implements JGaloInterface{
	
	private boolean flag;
	private char[][] buttons = new char[3][3];
	private int counter;
	private boolean draw;
	
	public JogoDoGalo() {
	
		flag = true;
		counter = 0;

	}
	
	@Override
	public char getActualPlayer() {
		if(flag) {
			flag = false;
			return 'x';
		}else {
			flag = true;
			return 'o';
		}
	}

	@Override
	public void setJogada(int lin, int col) {
		if(flag)
			buttons[lin-1][col-1] = 'x';
		else
			buttons[lin-1][col-1] = 'o';
	}

	@Override
	public boolean isFinished() {
		// game is finished if the board is filled or there are three in a line	
		counter++;
		
		if(words()) {
			draw = false;
			return true;
		}
		
		if(counter == 9) {
			draw = true;
			return true;
		}				
		
		return false;
	}

	@Override
	public char checkResult() {
		if(!draw) {
			flag = !flag;
			return getActualPlayer();
		}
		
		return ' ';
	}
	
	public boolean words() {
		// returns words in all directions
		String wordVer = "";
		String wordHor = "";
		String wordDiag = "";
		
		for(int i = 0; i < 3; i++) {
						
			for(int j = 0; j < 3; j++) {
				
				wordVer+=buttons[i][j];
				wordHor+=buttons[j][i];
				
			}
			if(wordVer.equals("xxx") || wordHor.equals("xxx") || wordVer.equals("ooo") || wordHor.equals("ooo")) {
				return true;
			}
			wordDiag+=buttons[i][i];

		}
		
		if(wordDiag.equals("xxx") || wordDiag.equals("ooo")) {
			return true;
		}
		
		return false;
	}

}

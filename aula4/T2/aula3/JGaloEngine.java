package aula3;

public class JGaloEngine implements JGaloInterface {

	private char[][] board;
	private char actualPlayer;
	private int nPlays;
	
	
	public JGaloEngine()
	{
		this.board=new char[3][3];
		this.actualPlayer = 'X';
		this.nPlays = 0;
		
		for(int x = 0; x<board.length; x++)
		{
			for(int y = 0; y<board.length; y++)
			{
				board[x][y] = ' ';
			}
		}	
		
	}
	
	
	@Override
	public char getActualPlayer() {
		
		return actualPlayer;
	}

	@Override
	public boolean setJogada(int lin, int col) {
		
		if(!PositionFree(lin,col))
			return false;
		if(!ValidPosition(lin, col))
			return false;
		if(isFinished()) 
			return false;
		
		board[lin-1][col-1] = getActualPlayer();
		
		if(actualPlayer == 'X') actualPlayer='O';
		else if(actualPlayer == 'O') actualPlayer='X';
		
		nPlays++;
		
		return true;
	}

	@Override
	public boolean isFinished() {
		
		System.out.println(checkResult());
		return checkResult() == 'X' || checkResult() == 'O' || nPlays==9;
	}

	@Override
	public char checkResult() {
		
		for(int i=0; i<3;i++)
		{
			int lin = board[i][0]+board[i][1]+board[i][2];
			if(lin==(3*'X')) return 'X';
			if(lin==(3*'O')) return 'O';
		}
		for(int i=0; i<3; i++)
		{
			int lin = board[0][i]+board[1][i]+board[2][i];
			if(lin==(3*'X')) return 'X';
			if(lin==(3*'O')) return 'O';
		}
		
			int lin = board[0][0]+board[1][1]+board[2][2];
			if(lin==(3*'X')) return 'X';
			if(lin==(3*'O')) return 'O';
		
			int linn = board[2][0]+board[1][1]+board[0][2];
			if(linn==(3*'X')) return 'X';
			if(linn==(3*'O')) return 'O';
			
		
		return ' ';
	}
	public boolean PositionFree(int lin, int col)
	{
		assert ValidPosition(lin,col):"invalid position";
		
		return board[lin-1][col-1]== ' ';
	}
	public boolean ValidPosition(int lin, int col)
	{
		
		return lin >= 1 && lin <= 9 && col >= 1 && col <= 9 ;
	}
}

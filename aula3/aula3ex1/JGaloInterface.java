package aula3;

public interface JGaloInterface {
	public abstract char getActualPlayer();
	public abstract void setJogada(int lin, int col);
	public abstract boolean isFinished();
	public abstract char checkResult();	
}
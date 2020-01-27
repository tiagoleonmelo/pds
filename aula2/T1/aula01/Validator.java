package aula01;

import java.util.List;

public class Validator {
	char p[][];
	String[] palavras;
	Solver solver;

	public Validator(char[][] puzzle,String[] palavras) {
		p = puzzle;
		this.palavras=palavras;

	}

	public boolean valid() // verifica se o puzzle � valido
	{
		boolean v = false;
		if (validSize() && isCharacter() && isUppercase() && VerifWords() ) {
			v = true;
			return v;
		}
		return v;
	}

	public boolean validSize()// validar se o puzzle � quadrado e tem no maximo
								// 80x80
	{
		boolean valid = false;
		if (p.length <= 80 && p.length == p[0].length)
			// verificar se o tamanho do array é inferior a 80 e se é uma
				// matriz quadrada
		{
			valid = true;
		}
		return valid;
	}

	public boolean isCharacter() {
		boolean valid = true;

		for (int i = 0; i < p.length; i++) {
			for (int j = 0; j < p.length; j++) {
				if (!(p[i][j] >= 'A' && p[i][j] <= 'Z')) {
					valid = false;
				}

			}
		}
		return valid;
	}

	public boolean isUppercase() {
		boolean valid = false;
		for (int i = 0; i < p.length; i++) {
			for (int j = 0; j < p.length; j++) {
				if (Character.isUpperCase(p[i][j])) {
					valid = true;
				}
			}
		}

		return valid;
	}
	public boolean VerifWords()//verificar se as palavras aparecem todas no puzzle
	{
		boolean valid=false;
		solver=new Solver(p,palavras);
		
		if(solver.getResult().size()==palavras.length)
		{
			valid=true;
		}

		return valid;
	}
}
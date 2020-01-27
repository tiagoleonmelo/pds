package aula01;

import java.io.FileNotFoundException;

public class WSSolver {
	public static void main(String[] args) throws FileNotFoundException {

		String nomeFile;
		if(args.length>0)
		{
			nomeFile=args[0];
		}
		else
		{
			nomeFile = "/home/executioner/Documents/PDS/Pratica/Lab1/sdl_01.txt";
		}
		ReadFile in = new ReadFile(nomeFile,"puzzle");
		in.PrintPuzzle();
		in.printPalavras();
		Validator validator = new Validator(in.getPuzzle(),in.getPalavras());
		if (validator.valid()) {
			// validação do puzzle
			Solver s = new Solver(in.sopaChar, in.strPalavras );
			if(args.length==2)
			{
				 if(args[1].equals("-timing"))
					 s.printTiming();
			}

			s.printResult();

		}
		else
		{
			System.out.println("Puzzle is not valid");
		}

	}
}
package Guiao3_2;

import java.util.*;

public class main {
	
	
	public static void main(String[] args) {
		System.out.println("*********Itializing tracking program**********\n");
		//System.out.println("Qual das seguintes operacoes deseja realizar ?");
		System.out.println("Insira o nome do ficheiro que contenha os dados pretendidos, para que possa ser devidamente lido:");
		System.out.println("Serao executadas apenas as seguintes operacoes presentes no ficheiro...\n1-load file \n2-Map \n3-Add \n4-Remove \n5-List \n6-Lookup \n7-Clear \n8-Quit ");
		loadFile data = new loadFile ();
		data.read("commands2.txt");
		familia fam = new familia (data);
		System.out.println("asd");
		rua r = new rua (fam);
		ArrayList <String> commands = data.getCommands();
		String cmd = "";
		/**
		for (int i = 0; i < commands.size(); i++) {
			cmd = commands.get(i);
			System.out.println(cmd);
			switch (cmd) {
				case "map":
					break;
				case "remove":
					break;
				case "list":
					break;
				case "lookup":
					break;
				case "clear":
					break;
				case "quit":
					System.out.println("Programa terminado com sucesso");
					System.exit(0);
				default:
					System.err.println("Nao foi introduzida uma opcao viavel !");
					break;
			}
		}
	**/
	
	
	}
	
	
	
}

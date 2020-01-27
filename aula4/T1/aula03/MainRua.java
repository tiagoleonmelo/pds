
/**
 * @author p31	
 */

//package aula3_ex2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MainRua {
	static Rua rua;

	public static void main(String[] args) throws FileNotFoundException {

		if (args.length == 0) {
			Scanner sc = new Scanner(System.in);
			rua = new Rua();

			int loop = 0;

			while (loop == 0) {
				System.out
						.println("Comandos: Load||List||Remove||Lookup||Map||Add||Clear||Exit");
				String op = sc.next().toLowerCase();
				switch (op) {
				case "list":
					rua.list();
					System.out.println(rua.toString());
					break;
				case "load":
					System.out.print("Caminho para ficheiro : ");
					String f = sc.next();
					rua.loadFileName(f);
					
					break;
				case "remove":
					System.out.print("Membro a remover : ");
					String remove = sc.next();
					rua.removeMember(remove);
					break;
				case "lookup":
					System.out.print("Membro a pesquisar : ");
					String nome = sc.next();
					rua.lookUp(nome);
					break;
				case "map":
					rua.list();
					map(rua.getMember());
					break;
				case "add":
					System.out.println("Nome: ");
					String n = sc.next();
					System.out.println("Porta inicio: ");
					int x1 = sc.nextInt();
					System.out.println("Porta fim: ");
					int x2 = sc.nextInt();
					Member mem = new Member(n, x1, x2);
					rua.addMember(mem);
					break;
				case "clear":
					rua.clear();
					break;
				case "exit":
					System.exit(0);
				default:
					System.out.println("Comando Inválido!");
					break;
				}
			}
			sc.close();
		} else {
			Scanner in = new Scanner(new File(args[0]));
			rua = new Rua();

			while (in.hasNext()) {

				String linha = in.nextLine();
				String[] st = linha.split(" ");
				if (st.length == 1) {
					if (st[0].equalsIgnoreCase("list")) {
						rua.list();
						System.out.println(rua.toString());
					}
					if (st[0].equalsIgnoreCase("Map")) {
						rua.list();
						map(rua.getMember());
						

					}

					if (st[0].equalsIgnoreCase("clear")) {
						rua.clear();

					}
					if (st[0].equalsIgnoreCase("exit")) {
						System.exit(0);
						
					}

				}
				if (st.length == 2) {
					if (st[0].equalsIgnoreCase("remove")) {
						String remove = st[1];
						rua.removeMember(remove);

					}
					if (st[0].equalsIgnoreCase("lookup")) {
						String lookup = st[1];
						rua.lookUp(lookup);
						
					}
				}
				if (st.length == 4) {
					if ((st[0].equals("add"))) 
					{
						String nome = st[1];
						int x1 = Integer.parseInt(st[2]);
						int x2 = Integer.parseInt(st[3]);
						rua.addMember(new Member(nome, x1, x2));
			
					}
				}

			}

			in.close();
		}

	}

	public static void map(List<Member> list) {
		int numMax=0;
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i).getX2()>numMax)
			{
				numMax=list.get(i).getX2();
			}
		}
		

		Map<Integer,String> mapRua=new HashMap<Integer,String>();
		for(int i=0;i<list.size();i++)
		{
			for(int j=list.get(i).getX1();j<=list.get(i).getX2();j++)
			{
				if(mapRua.get(j)!=null)
				{
					mapRua.put(j,mapRua.get(j)+": "+list.get(i).getNome() );
				}
				else
				{
					mapRua.put(j,list.get(i).getNome() );

				}
			}

		}
		
		for(int i=1;i<numMax;i++)
		{
			if(mapRua.get(i)==null)
			{
				mapRua.put(i,"");
			}
			System.out.println(i+" : "+mapRua.get(i));
		}
	}
}

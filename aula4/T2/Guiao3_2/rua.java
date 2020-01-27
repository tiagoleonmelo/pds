package Guiao3_2;

import java.util.*;

public class rua {
	//imprime porta porta com as familias que la moram... separaçao por ":"
	private ArrayList <ArrayList <Person> > Rua = new ArrayList <>();  
	private TreeMap<ArrayList<Integer>, ArrayList<Person>> familias = new TreeMap <>();
	
	public rua (familia fam) {
		familias = fam.getPosition_fam();
		//fzr algoritmo para decidir qual o maior numero no primeiro array
		//for do menor ao numero maior e imprimir la a familia
		 int maior = 0;
		    for (ArrayList <Integer> posicoes: familias.keySet()) {
		        if(posicoes.get(1) > maior) {
		            maior = posicoes.get(1);		            
		        }
		    }
		 printRua(maior);
		
		
		
		
		
		
	}

	public void printRua (int maior) { //saber nº max das portas e apresentar devidas familias em cada um dos numeros
		StringBuilder sb = new StringBuilder();
			for (int i= 1 ; i <= maior; i++ ) {
				sb.append(i + " : " );
				for (ArrayList <Integer> posicoes: familias.keySet()) {
					for (int j = posicoes.get(0); j <= posicoes.get(1); j++) {
						if (j == i) {
							ArrayList <Person> memberFamilia = familias.get(posicoes);
							for (Person p : memberFamilia) {
								sb.append(p.toString() + " ");
							}
						}
					}
				}
				System.out.println(sb);
			}
		}
		
		
	}




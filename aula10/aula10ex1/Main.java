package aula10ex1;

public class Main {

	public static void main(String[] args) {
		
		Produto sub1 = new Produto("Old TV Controller", 15.00, STATE.Stock);
		Produto sub2 = new Produto("Red Mercedes", 7.30, STATE.Stock);
		Produto sub3 = new Produto("Half a Cookie", 21.00, STATE.Stock);
		Produto sub4 = new Produto("Head First into GRASP Patterns", 40.00, STATE.Stock);
		Produto sub5 = new Produto("Mouse Pad", 80.00, STATE.Stock);
		
		Cliente c1 = new Cliente("Tiago");
		Gestor g1 = new Gestor("Not Tiago", sub1);
		
		c1.makeBid(sub1, 19.00);
		
		sub1.setS(STATE.Leilao);
		sub2.setS(STATE.Leilao);
		sub3.setS(STATE.Leilao);
		sub4.setS(STATE.Leilao);
		
		
		c1.makeBid(sub1, 19.00);
		
		sub1.setS(STATE.Vendas);
		
		



	}

}

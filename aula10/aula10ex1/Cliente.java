package aula10ex1;

public class Cliente extends Observer{
	
	private String nome;
	
	public Cliente(String nome) {
		this.nome = nome;		
	}
	
	public void makeBid(Produto p, double bid) {
		if(p.getS().equals(STATE.Leilao)) {
			this.prod= p;
			this.prod.attach(this); // Observers register themselves
			p.setPrice(bid, this);
		}else {
			System.out.println("Product must be in leilao state to be eligible for bidding");
		}
	}

	@Override
	public void update() {
		System.out.println(nome + " saw " + this.prod + " going to " + this.prod.getPrice());	
	}

}

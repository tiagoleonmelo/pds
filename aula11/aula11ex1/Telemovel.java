package aula11ex1;

public class Telemovel implements Comparable<Telemovel>{
	
	private Comparable<Telemovel> c;
	private String processador;
	private Double price;
	private int memoria;
	private String camara;
	
	public Telemovel(String processador, Double price, int memoria, String camara) {
		this.processador = processador;
		this.price = price;
		this.memoria = memoria;
		this.camara = camara;
		this.c=new CompareByPrice(price);
	}
	
	public void setC(Attribute a) {
		switch(a) {
		case PRECO:
			this.c = new CompareByPrice(this.price);
			break;
		
		case MEMORIA:
			this.c = new CompareByMem(this.memoria);
			break;
		
		case CAMARA:
			this.c = new CompareByCam(this.camara);
			break;
		
		case CPU:
			this.c = new CompareByCPU(this.processador);
			break;
		}
	}

	@Override
	public int compareTo(Telemovel o) {
		return c.compareTo(o);
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public int getMem() {
		return this.memoria;
	}
	
	public String getCPU() {
		return this.processador;
	}
	
	public String getCam() {
		return this.camara;
	}
	
	public String toString() {
		return "Telemovel CPU: "+this.processador + "; Price: "+this.price+"; Camara: "+this.camara+"; Memoria: "+this.memoria;
	}

}

class CompareByPrice implements Comparable<Telemovel>{
	
	private double price;
	
	public CompareByPrice(double price) {
		this.price = price;
	}

	@Override
	public int compareTo(Telemovel o) {
		if(this.price > o.getPrice()) {
			return 1;
		}else if(this.price < o.getPrice()){
			return -1;
		}else {
			return 0;
		}
		
	}
		
}

class CompareByMem implements Comparable<Telemovel>{
	
	private int mem;
	
	public CompareByMem(int mem) {
		this.mem = mem;
	}

	@Override
	public int compareTo(Telemovel o) {
		if(this.mem > o.getMem()) {
			return 1;
		}else if(this.mem < o.getMem()){
			return -1;
		}else {
			return 0;
		}
		
	}
		
}

class CompareByCam implements Comparable<Telemovel>{
	
	private String cam;
	
	public CompareByCam(String cam) {
		this.cam = cam;
	}

	@Override
	public int compareTo(Telemovel o) {
		return this.cam.compareTo(o.getCam());
		
	}
		
}

class CompareByCPU implements Comparable<Telemovel>{
	
	private String cpu;
	
	public CompareByCPU(String cpu) {
		this.cpu = cpu;
	}

	@Override
	public int compareTo(Telemovel o) {
		return this.cpu.compareTo(o.getCPU());
		
	}
		
}

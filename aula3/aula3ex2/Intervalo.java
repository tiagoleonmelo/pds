package aula3;

public class Intervalo implements Comparable<Intervalo>{
	
	private int n1, n2;
	
	private Intervalo(int n1, int n2) {
		this.n1 = n1;
		this.n2 = n2;
	}
	
	public static Intervalo newIntervalo(int n1, int n2) {
		if(n1 > n2 || n1 < 1 || n2 < 1) {
			System.out.print("Intervalo invalido");
			return null;
		}else {
			return new Intervalo(n1, n2);
		}
		
	}
	
	public int length() {
		return this.n2-this.n1;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + n1;
		result = prime * result + n2;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Intervalo other = (Intervalo) obj;
		if (n1 != other.n1)
			return false;
		if (n2 != other.n2)
			return false;
		return true;
	}

	@Override
	public String toString() {
//		String ret = "";
//		for(int i = n1; i <= n2; i++) {
//			ret+=i + " ";
//		}
		return n1 + " " + n2;	// return ret if you want every door number
	}
	
	public boolean contains(int i) {
		if(i <= this.n2 && i >= this.n1) {
			return true;
		}
		
		return false;
	}

	@Override
	public int compareTo(Intervalo arg0) {
		
		if(this.length() > arg0.length()) {
			
			return -1;
			
		}else if(this.length() == arg0.length()){
			
			if(this.equals(arg0)) {
				return 0;
			}
			
		}
		
		return 1;
	}
	

	
	
	

}

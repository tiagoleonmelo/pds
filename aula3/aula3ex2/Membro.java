package aula3;

public class Membro implements Comparable<Membro>{
	
	private String nome;
	private Intervalo inter;
	
	private Membro(String nome, Intervalo inter) {
		this.nome = nome;
		this.inter = inter;
	}
	
	public static Membro newMembro(String nome, Intervalo inter) {
		
		if(nameIsValid(nome)) {	// conds iniciais
			System.out.println("ERRO: Nome inválido");
			System.exit(0);
			return null;
		}
		
		return new Membro(nome, inter);
		
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String name) {
		this.nome = name;
	}
	
	public Intervalo getInter() {
		return inter;
	}

	public void setInter(Intervalo inter) {
		this.inter = inter;
	}

	@Override
	public int compareTo(Membro o) {
		if(this.nome.equals(o.getNome())){
			return this.inter.compareTo(o.inter);
		}
		
		return this.nome.compareTo(o.getNome());	
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((inter == null) ? 0 : inter.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Membro other = (Membro) obj;
		if (this.nome.equals(other.nome))
			return true;
		if (inter == null) {
			if (other.inter != null)
				return false;
		} else if (!inter.equals(other.inter))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		
		return true;
	}
	
	public static boolean nameIsValid(String nome) {
		
		return (!nome.matches("[a-zA-Z0-9_.@]*") || (!(nome.charAt(0) >= 'a' && nome.charAt(0) <= 'z') && !(nome.charAt(0) >= 'A' && nome.charAt(0) <= 'Z')) || nome.endsWith("_")|| nome.endsWith(".")|| nome.endsWith("@") || nome.length() > 40);
	
	}
	
	public String toString() {
		return this.nome;
	}

	
	

}

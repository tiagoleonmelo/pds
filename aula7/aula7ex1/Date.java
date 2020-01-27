package lab7;

public class Date {
	private int dia, mes, ano;

	public Date(int dia, int mes, int ano) {
		super();
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}

	@Override
	public String toString() {
		return dia+"/"+mes+"/"+ano;
	}
	
	
}

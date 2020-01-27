//package aula3_ex2;


public class Member implements Comparable<Member> {
	

	private String nome;
	private int x1;
	private int x2;
	
	public Member(String nome,int x1, int x2){
		this.nome=nome;

		if(validName())
		{
			if(x1>0 && x2>x1)
			{
				this.x1=x1;
				this.x2=x2;
			}
		}
	}
	public Member(String nome,int x1){
		this.nome=nome;

		if(validName())
		{
			if(x1>0)
			{
				this.x1=this.x2=x1;
			}
		}
	}
	
	public boolean validDoors(int x1,int x2){
		if(x1>0&&x2>x1){
			return true;
		}
		return false;
	}
	

	public boolean startLetter(){
		char c = nome.charAt(0);
		if(Character.isLetter(c)){
			return true;
		}
		return false;
	}
	
	public boolean finishLetter(){
		
		char c = nome.charAt(nome.length()-1);
		
		if(Character.isLetter(c)||Character.isDigit(c)){
			return true;
		}
		return false;
	}
	
	public boolean validSymbol(){
		char [] valid = {'@','.','_'};
		char c;
		for(int i=0;i<nome.length();i++){
			c=nome.charAt(i);
			if(!Character.isLetter(c)){
				for (char element : valid) {
					if(c==element) return true;
					//else return false;
				}
			}
			
		}
		return true;
	}
	
	public boolean nameLenght(){
		return nome.length()<40;
	}
	
	public String getNome() {
		return nome;
	}
	

	public int getX1() {
		return x1;
	}
	public void setX1(int x1) {
		this.x1 = x1;
	}
	public int getX2() {
		return x2;
	}
	public void setX2(int x2) {
		this.x2 = x2;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public boolean validName(){
		
		if(startLetter() && finishLetter() && validSymbol() && nameLenght()){
			return true;
		}
		return false;
	}
	@Override
	public String toString()
	{
		return x1+"-"+x2+"-"+nome; 
	}
	@Override
	public int compareTo(Member mem) {
		if(this.x1>mem.getX1())
		{
			return -1;
		}
		else
		{
			return 1;
		}
	
	}

}

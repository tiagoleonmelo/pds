package aula7ex2;

public abstract class Decorator implements Reader{
	
	protected Reader tr;
	
	public Decorator(Reader tr) {
		this.tr=tr;
	}

	@Override
	public boolean hasNext() {
		return tr.hasNext();
	}

	@Override
	public String next() {
		return tr.next();
	}
	
	

}

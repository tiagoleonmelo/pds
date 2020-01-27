package aula9ex2;

public class DelElementCom<E> implements Command<E> {
	private GenericCollection<E> c;

	public DelElementCom(GenericCollection<E> c) {
		this.c = c;
	}

	@Override
	public void undo() {
		E el=c.getLastEl();
		if (el==null) {
			throw new NullPointerException("Error");
		}
		c.addEl(el);		
	}
	public void execute(E el) {
		c.delEl(el);
	}
	
	
	

}


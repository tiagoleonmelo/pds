package aula9ex2;

public class AddElementCom<E> implements Command<E> {
	private GenericCollection<E> c;

	public AddElementCom(GenericCollection<E> c) {
		this.c = c;
	}
	@Override
	public void undo() {
		E el=c.getLastEl();
		if (el==null) {
			throw new NullPointerException("Error");
		}
		c.delEl(el);		
	}
	@Override
	public void execute(E el) {
		c.addEl(el);
		
	}
	
	
	

}

package aula9ex2;

import java.util.*;

public class GenericCollection<E> {
	private Collection<E> c;
	
	private E lastEl;

	public GenericCollection(Collection<E> c) {
		this.c = c;
		this.lastEl=null;
	}
	public E getLastEl() {
		return lastEl;
	}

	public Collection<E> getC() {
		return c;
	}
	public void addEl(E el) {
		c.add(el);
		this.lastEl=el;
	}

	public void delEl(E el) {
		c.remove(el);
		this.lastEl=el;
	}
	
	
	

}

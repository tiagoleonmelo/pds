package aula9exercicio1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class VectorGeneric<T> {
	private T[] vec;
	private int nElem;
	private final static int ALLOC = 50;
	private int dimVec = ALLOC;
	
	@SuppressWarnings("unchecked")
	public VectorGeneric() {
		vec = (T[]) new Object[dimVec];
		nElem = 0;
	}
	
	public boolean addElem(T elem) {
		if (elem == null)
			return false;
		ensureSpace();
		vec[nElem++] = elem;
		return true;
	}
	
	private void ensureSpace() {
		if (nElem>=dimVec) {
			dimVec += ALLOC;
			@SuppressWarnings("unchecked")
			T[] newArray = (T[]) new Object[dimVec];
			System.arraycopy(vec, 0, newArray, 0, nElem );
			vec = newArray;
		}
	}
	
	public boolean removeElem(T elem) {
		for (int i = 0; i < nElem; i++) {
			if (vec[i].equals(elem)) {
				if (nElem-i-1 > 0) // not last element
					System.arraycopy(vec, i+1, vec, i, nElem-i-1 );
				vec[--nElem] = null; // libertar último objecto para o GC
				return true;
			}
		}
		return false;
	}
	
	public int totalElem() {
		return nElem;
	}
	
	public T getElem(int i) {
		return (T) vec[i];
	}
	
	public Iterator<T> Iterator(){ // Using an already implemented version of an Iterator :)
		@SuppressWarnings("unchecked")
		T[] copy =  (T[]) new Object[nElem];
		
		for(int i = 0; i < nElem; i++) {
			copy[i]=vec[i];
		}
		
		return Arrays.stream(copy).iterator();	
	}
	
	public ListIterator<T> listIterator(){
		Iterator<T> iter = Iterator();
		List<T> copy = new ArrayList<T>();
		while (iter.hasNext())
		    copy.add(iter.next());
		
		return copy.listIterator();	
	}
	
	public ListIterator<T> listIterator(int index){
		
		if(index > vec.length) {
			throw new IndexOutOfBoundsException("Invalid starting index");
		}
		
		Iterator<T> iter = Iterator();

		List<T> copy = new ArrayList<T>();
		T temp;
		
		for (int i=0; i<vec.length; i++){
			if(iter.hasNext()) {
			temp = iter.next();
			if(i >= index)
				copy.add(temp);
			}
		}
		
		return copy.listIterator();	
	}
}

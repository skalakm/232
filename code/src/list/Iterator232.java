package list;

public interface Iterator232<E> {

	public boolean hasNext();
	
	public E next();
	
	public boolean hasPrev();
	
	public E prev();
	
	public void insert(E item);
	
	public E remove();
	
	
}

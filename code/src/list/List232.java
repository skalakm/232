package list;

public interface List232<E> {
	
	
	
	public void add(E element );
	
	public E remove( int index) throws Exception;
	
	public E get( int index) throws Exception;
	
	public void set(int index, E element) throws Exception;
	
	public void insert(int index, E element) throws Exception;
	
	public int size();

	
}

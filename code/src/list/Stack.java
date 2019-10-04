package list;

public interface Stack<E> {
	
	public void push(E item);
	
	public E pop() throws Exception;
	
	public E peek() throws Exception;
	
	public int size();

}

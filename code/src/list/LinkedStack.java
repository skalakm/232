package list;

public class LinkedStack<E> extends LinkedList232<E> implements Stack<E>  {

	
	
	@Override
	public void push(E item) {
		
		try {
			this.insert(0, item);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public E pop() throws Exception {
		
		if(this.size() == 0) {
			throw new Exception();
		}
		
		E returnVal = this.get(0);
		this.remove(0);
		return returnVal;
		
	}

	@Override
	public E peek() throws Exception {
		if(this.size() == 0) {
			throw new Exception();
		}
		
		E returnVal = this.get(0);
		
		return returnVal;
	}

}

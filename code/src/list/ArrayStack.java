package list;

public class ArrayStack<E> extends ArrayList232<E> implements Stack<E> {


	@Override
	public void push(E item) {
		
		try {
			this.insert(size(), item);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public E pop() throws Exception {
		
		if(this.size() == 0) {
			throw new Exception();
		}
		
		E returnVal = this.get(size()-1);
		this.remove(size()-1);
		return returnVal;
		
	}

	@Override
	public E peek() throws Exception {
		if(this.size() == 0) {
			throw new Exception();
		}
		
		E returnVal = this.get(size()-1);
		
		return returnVal;
	}

}

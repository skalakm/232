package list;

public class LinkedStack<E> extends LinkedList232<E> implements Stack<E>  {

	
	public static void main(String[] args) {
		Stack<Integer> myStack = new LinkedStack<Integer>();
		
		for(int i = 0; i < 100; ++i) {
			myStack.push(i);
		}
		System.out.println(myStack.size());
		while( myStack.size() >0 ) {
			//System.out.println(myStack.size());
			try {
				System.out.println( myStack.pop());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
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

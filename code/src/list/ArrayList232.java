package list;

public class ArrayList232<E> implements List232<E> {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	E[] backingStore;
	int size;
	
	public ArrayList232 (){
		backingStore = (E[ ]) new Object[8];
		size=0;
	}

	@Override
	public void add(E element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E get(int index) {
		
		if(index < 0 || index >= size) {
			throw new Exception();
		}else {
			return backingStore[index];
		}
	}

	@Override
	public void set(int index, E element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(int index, E element) {
		// TODO Auto-generated method stub
		
	}

}

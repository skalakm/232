package list;

public class ArrayList232<E> implements List232<E> {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	E[] backingStore;
	int size;

	public ArrayList232() {
		backingStore = (E[]) new Object[8];
		size = 0;
	}

	@Override
	public void add(E element) {
		
		if( backingStore.length >= size +1) {
			backingStore[size] = element;
			size++;
		}else {
			makeArrayDoubleSize();
			backingStore[size] = element;
			size++;
		}

	}
	
	private void makeArrayOneBigger() {
		E[] newArray = (E[]) new Object[backingStore.length+1];
		for( int i =0; i < backingStore.length; ++i) {
			newArray[i] = backingStore[i];
		}
		backingStore= newArray;
	}
	
	private void makeArrayDoubleSize() {
		E[] newArray = (E[]) new Object[backingStore.length*2];
		for( int i =0; i < backingStore.length; ++i) {
			newArray[i] = backingStore[i];
		}
		backingStore= newArray;
	}

	@Override
	public E remove(int index) throws Exception {
		// get element to remove
		E removedElement = get(index);
		
		// move elements down
		for(int i = index+1; i < size; ++i) {
			set(i, get(i+1));
		}
		
		//reduce size
		size--;
		
		return removedElement;
	}

	@Override
	public E get(int index) throws Exception {

		if (index < 0 || index >= size) {
			throw new Exception();
		} else {
			return backingStore[index];
		}
	}

	@Override
	public void set(int index, E element) throws Exception {
		if (index < 0 || index >= size) {
			throw new Exception();
		} else {
			backingStore[index] = element;
		}

	}

	@Override
	public void insert(int index, E element) throws Exception {

		//check if index is valid
		if(index <0 || index > size) {
			throw new Exception();
		}
		
		// check if array needs more space
		if( size == backingStore.length) {
			makeArrayDoubleSize();
		}
		
		// copy elements down
		for(int i = index; i < size; ++i) {
			backingStore[i] = backingStore[i+1];
		}
		
		
		// add new element
		backingStore[index] = element;
		size++;
		
		
		
		
	}
	@Override
	public int size() {
		return size;
	}

}

package list;

public class LinkedList232<E> implements List232<E> {

	
	public static void main(String[] args) throws Exception {
		LinkedList232<Double> linked = new LinkedList232<Double>();
		
		for(int i = 0; i < 100000; ++i) {
			linked.add(i+1.3);
		}
		
		for(int i = 0; i < 100000; ++i) {
			System.out.println(linked.get(i));
		}
		
		List232<Double> arr = new ArrayList232<Double>();
		
		for(int i = 0; i < 100000; ++i) {
			arr.add(i+1.3);
		}
		
		for(int i = 0; i < 100000; ++i) {
			System.out.println(arr.get(i));
		}
		
	}
	private int size;
	
	private DLLNode head;
	private DLLNode tail;
	
	public LinkedList232 () {
		
		size = 0;
		head = new DLLNode();
		tail = new DLLNode();
		head.next =tail;
		tail.prev = head;
		
		
	}
	
	
	@Override
	public void add(E element) {
		
		DLLNode newNode = new DLLNode();
		DLLNode prevNode = tail.prev;
		
		// attach prevNode to new Node
		prevNode.next = newNode;
		newNode.prev = prevNode;
		
		// attach newNode to tail
		newNode.next = tail;
		tail.prev = newNode;
		
		// fix size
		size++;
		
		//set element
		newNode.element = element;
		
	}



	@Override
	public E get(int index) throws Exception {
	
		return getNode(index).element;
	}
	
	private DLLNode getNode(int index) throws Exception {
		if(index < 0 || index >=size) {
			throw new Exception();
		}

		int curIndex = 0;
		DLLNode curNode = head.next;
		
		//traverse list
		while(curIndex != index) {
			curIndex++;
			curNode = curNode.next;
		}
		
		return curNode;
	}

	@Override
	public void set(int index, E element) throws Exception {
		
		DLLNode theNode = getNode(index);
		theNode.element = element;
	}

	@Override
	public void insert(int index, E element) throws Exception {
		
		DLLNode theNode = getNode(index);
		DLLNode prevNode = theNode.prev;
		
		DLLNode newNode = new DLLNode();
		newNode.element = element;
		
		theNode.prev = newNode;
		newNode.next = theNode;
		
		prevNode.next = newNode;
		newNode.prev  = prevNode;
	}
	
	@Override
	public E remove(int index) throws Exception {
		
		DLLNode toRemove = getNode(index);
		
		DLLNode prevNode = toRemove.prev;
		DLLNode nextNode = toRemove.next;
		
		prevNode.next = nextNode;
		nextNode.prev = prevNode;
		return toRemove.element;
	}
	
	private class DLLNode{
		DLLNode next;
		DLLNode prev;
		E element;
		
	}

}

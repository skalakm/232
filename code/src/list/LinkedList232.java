package list;

public class LinkedList232<E> implements List232<E>, Iterable232<E> {

	
	public static void main(String[] args) throws Exception {
		LinkedList232<Double> linked = new LinkedList232<Double>();
		
		Iterable232<Double> linkedIter = linked;
		
		List232<Double> arr = new ArrayList232<Double>();
		
		
		for(int i = 0; i < 1000000; ++i) {
			linked.add(.0+i);
			arr.add(.0+i);
		}
		ListAlgorithms.slowPrintAll(linked);
		
		//ListAlgorithms.slowPrintAll(arr);
		
		ListAlgorithms.iterPrintAll(linked.getIterator());
		
		
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
		if(index < 0 || index >size) {
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
		size++;
	}
	
	@Override
	public E remove(int index) throws Exception {
		
		DLLNode toRemove = getNode(index);
		
		DLLNode prevNode = toRemove.prev;
		DLLNode nextNode = toRemove.next;
		
		prevNode.next = nextNode;
		nextNode.prev = prevNode;
		size--;
		return toRemove.element;
	}
	
	class DLLNode{
		DLLNode next;
		DLLNode prev;
		E element;
		
	}

	@Override
	public int size() {
		return size;
	}


	@Override
	public Iterator232<E> getIterator() {
		
		return new LinkedIterator();
	}
	
	private class LinkedIterator implements Iterator232<E>{

		DLLNode cur;
		public LinkedIterator() {
			cur = head;
		}
		@Override
		public boolean hasNext() {
			
			return cur!=tail.prev;
		}

		@Override
		public E next() {
			
			DLLNode node = cur.next;
			cur = cur.next;
			return node.element;
		}

		@Override
		public boolean hasPrev() {
			
			return cur!=head;
		}

		@Override
		public E prev() {
			DLLNode node = cur;
			cur = cur.prev;
			return node.element;
		}

		@Override
		public void insert(E item) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public E remove() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}

}

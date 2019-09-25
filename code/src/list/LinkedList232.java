package list;

public class LinkedList232<E> implements List232<E> {

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
	public E remove(int index) throws Exception {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(int index, E element) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	private class DLLNode{
		DLLNode next;
		DLLNode prev;
		E element;
		
	}

}

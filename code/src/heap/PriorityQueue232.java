package heap;

import java.util.ArrayList;

public class PriorityQueue232< Key extends Comparable<Key>, Value> {

	ArrayList< HeapNode<Key, Value> > tree;
	
	public PriorityQueue232() {
		tree = new ArrayList<HeapNode<Key, Value >> ();
	}
	
	public PriorityQueue232( Key[] keys, Value[] values) {
		for(int i = 0; i < keys.length; ++i) {
			tree.add( new HeapNode<Key, Value>(keys[i], values[i]));
		}
	}
	
	private boolean checkHeapProperty() {
		return checkHeapProperty(0);
	}
	
	private boolean checkHeapProperty(int curIndex) {
		if( haveLeftChild(curIndex)) { // cur index has left child
		
			Key curKey = tree.get(curIndex).key;
			Key leftChildKey = tree.get(getLeftChild(curIndex)).key;
			if(leftChildKey.compareTo( curKey) <0) {
				return false;
			}
			
			if(haveRightChild(curIndex)) {
				Key rightChildKey = tree.get(getRightChild(curIndex)).key;
				if(rightChildKey.compareTo(curKey)<0) {
					return false;
				}
				if( !checkHeapProperty(getRightChild(curIndex))) {
					return false;
				}
			}
			
			return checkHeapProperty(getLeftChild(curIndex));
			
			
		}else {
			return true;
		}
		
	}
	
	
	private int getLeftChild(int cur) {
		return cur*2+1;
	}
	
	private int getRightChild(int cur) {
		return cur*2+2;
	}
	
	private boolean haveLeftChild(int cur) {
		return getLeftChild(cur) < tree.size();
	}
	
	private boolean haveRightChild(int cur) {
		return getRightChild(cur) < tree.size();
	}
	
	private static class HeapNode< Key, Value> {
		public Key key;
		public Value value;
		
		public HeapNode(Key k, Value v) {
			this.key=k;
			this.value = v;
		}
	}
}

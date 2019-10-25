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
	
	public Value remove() {
		
		
		// size 1 tree
		if( tree.size() == 1) {
			Value v = tree.get(0).value;
			tree.remove(0);
			return v;
		}
		
		// get node to remove
		HeapNode< Key, Value > node = tree.get(0);
		
		
		// swap it to last leaf leaf
		swap(0, tree.size()-1);
		
		
		// remove it from tree
		tree.remove(tree.size()-1);
		
		
		//fix heap property 
		
			// trickle down from the root
		trickleDown(0);
		return node.value;
		
		
	}
	
	public void swap(int index0, int index2) {
		HeapNode<Key, Value> temp = tree.get(index0);
		
		tree.set(index0, tree.get(index2));
		tree.set( index2, temp);
		
	}
	
	public void trickleDown(int index) {
		
		if(!isLeaf(index)) {
			// find smaller child
			int indexOfSmallerChild = getIndexOfSmallerChild(index);
			
			HeapNode<Key, Value> smallerChild = tree.get(indexOfSmallerChild);
			
			// if smaller child is less than current
			if( smallerChild.key.compareTo( tree.get(index).key) < 0) {
				//swap
				swap(index, indexOfSmallerChild);
				
				// call trickle down recursively
				trickleDown(indexOfSmallerChild);
			}
				
			
			
		}
	}
	
	private int getIndexOfSmallerChild(int index) {
		int leftChildIndex = getLeftChild(index);
		
		//default is that left child is smaller
		int smallerIndex = leftChildIndex;
		
		// if there is a right child
		if(haveRightChild(index)) {
			//check if right child is smaller
			HeapNode<Key, Value> rightChild = tree.get(getRightChild(index));
			HeapNode<Key, Value> leftChild = tree.get(leftChildIndex);
			if( rightChild.key.compareTo(leftChild.key) < 0) {
				smallerIndex = getRightChild(index);
			}
			
		}
		return smallerIndex;
		
	}
	
	public boolean isLeaf(int index) {
		return haveLeftChild(index) || haveRightChild(index);
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

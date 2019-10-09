package binaryTree;

import java.util.ArrayDeque;
import java.util.Queue;

public class LinkedBinaryTree< Key, Val> implements BinaryTree<Key, Val>{
	
	BTNode<Key, Val> root;
	int size;
	
	
	
	
	class BTNode< G, H>{
		G key;
		H val;
		
		BTNode<G,H> parent;
		
		BTNode<G, H> left;
		
		BTNode<G, H> right;
		
		
	}




	@Override
	public int size() {
		
		return size;
	}




	@Override
	public Val get(Key k) {
		
		BTNode<Key, Val> node = getNode(k);
		if(node !=null) {
			return node.val;
		}else {
			return null;
		}
	}
	

	
	private BTNode<Key, Val> getNode(Key k){
		return getNodeHelper(root, k);
	}
	
	private BTNode<Key, Val> getNodeHelper(BTNode<Key, Val> cur, Key k){
		if(cur == null) {
			return null;
		}
		if(cur.key.equals(k)) {
			return cur;
		}
		BTNode<Key, Val> leftResult = getNodeHelper(cur.left, k);
		
		if(leftResult!= null) {
			return leftResult;
		}
		
		return getNodeHelper(cur.right, k);
	}




	@Override
	public void set(Key k, Val v) throws Exception {
		BTNode<Key, Val> node = getNode(k);
		if(node==null) {
			throw new Exception();
		}
		
		node.val = v;
		
	}




	@Override
	public Val remove(Key k) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public void add(Key k, Val v) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public boolean containsKey(Key k) {
		// TODO Auto-generated method stub
		return false;
	}




	@Override
	public void visitLevelOrder(Visitor<Key, Val> v) {
		Queue< BTNode<Key, Val> > theQueue = new ArrayDeque<BTNode<Key, Val>>();
		theQueue.add( root);
		
		while(!theQueue.isEmpty()) {
			BTNode<Key, Val> cur = theQueue.poll();
			v.visit(cur.key, cur.val);
			if(cur.left!=null) {
				theQueue.add(cur.left);
			}
			if(cur.right!=null) {
				theQueue.add(cur.right);
			}
		}
	}




	@Override
	public void visitPreOrder(Visitor<Key, Val> v) {
		
		visitPreOrderHelper(root, v);
	}
	
	private void visitPreOrderHelper(BTNode<Key, Val> cur, Visitor<Key, Val> v) {
		
		if(cur == null) {
			return;
		}
		v.visit(cur.key, cur.val);
		visitPreOrderHelper(cur.left, v);
		visitPreOrderHelper(cur.right, v);
		
		
	}




	@Override
	public void visitInOrder(Visitor<Key, Val> v) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void visitPostOrder(Visitor<Key, Val> v) {
		// TODO Auto-generated method stub
		
	}

}

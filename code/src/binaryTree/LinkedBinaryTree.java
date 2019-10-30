package binaryTree;

import java.util.ArrayDeque;
import java.util.Queue;

public class LinkedBinaryTree< Key, Val> implements BinaryTree<Key, Val>{
	
	BTNode<Key, Val> root;
	int size;
	
	
	
	
	protected class BTNode< G, H>{
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
		BTNode<Key, Val> nodeToRemove = getNode(k);
		if(nodeToRemove == null) {
			return null;
		}
		
		int childrenCount = 0;
		if(nodeToRemove.right != null) {
			childrenCount++;
		}
		if(nodeToRemove.left != null) {
			childrenCount++;
			
		}
		
		if( childrenCount == 0) {
			if(nodeToRemove.parent.left == nodeToRemove) {
				nodeToRemove.parent.left = null;
				
			}else {
				nodeToRemove.parent.right = null;
				
			}
		}else if(childrenCount == 1) {
			if(nodeToRemove.left != null) {
				if(nodeToRemove.parent.left== nodeToRemove) {// node is a left child and has a left child
					nodeToRemove.parent.left = nodeToRemove.left;
					nodeToRemove.left.parent = nodeToRemove.parent;
				}else { //node is left child and has right child
					nodeToRemove.parent.left = nodeToRemove.right;
					nodeToRemove.right.parent = nodeToRemove.parent;
				}
			}else {
				if(nodeToRemove.parent.right== nodeToRemove) {// node is a right child and has a right child
					nodeToRemove.parent.right = nodeToRemove.right;
					nodeToRemove.right.parent = nodeToRemove.parent;
				}else { //node is right child and has left child
					nodeToRemove.parent.right = nodeToRemove.left;
					nodeToRemove.left.parent = nodeToRemove.parent;
				}
			}
			
		}else {
			
			BTNode< Key, Val > easyNode = nodeToRemove;
			while(easyNode.right != null) {
				easyNode = easyNode.right;
			}
			Key temp = nodeToRemove.key;
			Val tempVal = nodeToRemove.val;
			nodeToRemove.key = easyNode.key;
			nodeToRemove.val = easyNode.val;
			easyNode.key = temp;
			easyNode.val = tempVal;
			
			return remove(k);
		}
		size--;
		return nodeToRemove.val;
		
		
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

package binaryTree;

public class BinarySearchTree<Key extends Comparable<Key>, Value> 
	extends LinkedBinaryTree<Key, Value> {

	
	
	
	public boolean contains( Key k) {
		
		return getNode(root, k) != null;
	}
	
	
	

	public Value get( Key k) {
		
		BTNode<Key, Value> node = getNode(root, k);
		if(node == null) {
			return null;
		}else {
			return node.val;
			
		}
	}
	
	
	
	private BTNode< Key, Value> getNode( BTNode<Key, Value> cur, Key k){
		if(cur.key.equals(k)) {
			return cur;
		}
		
		
		// check which side to search
		if(cur.key.compareTo( k) < 0) {
			//make sure that side exists
			if(cur.right == null) {
				return null;
			}else {

				//recursive call
				return getNode(cur.right, k);
			}
		}else {
			//make sure that side exists
			if(cur.left == null) {
				return null;
			}else {

				//recursive call
				return getNode(cur.left, k);
			}
		}
	}
	
	public Value remove(Key k) {
		
		// find the node to remove
		BTNode<Key, Value> nodeToRemove = getNode(root, k);
		
		//if it doesnt exist, return null
		if(nodeToRemove == null) {
			return null;
		}
		
		
		// if it does, check how many children it has
		boolean isRoot = (nodeToRemove==root);
		boolean isRightChild = (!isRoot && nodeToRemove.parent.right == nodeToRemove);
		
		// if it has 0, just remove it;
		if( nodeToRemove.right == null && nodeToRemove.left == null) {
			if(!isRoot ) {
				if(isRightChild) {
					nodeToRemove.parent.right= null;
				}
				else {
					nodeToRemove.parent.left =null;
				}
			}
			return nodeToRemove.val;
		}
		
		// if has 1, remove it and promote child
		
		// if it has 2, 
			//find next node
			// swap with cur node
			// remove next node
		
		// return the value
		
		
		
		
		
	}
	
}

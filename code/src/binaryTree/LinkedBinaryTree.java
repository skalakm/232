package binaryTree;

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
		
		return getHelper(k, root);
	}
	
	public Val getHelper(Key k, BTNode<Key, Val> cur) {
		if(cur == null) {
			return null;
		}
		if(cur.key.equals(k)) {
			return cur.val;
		}
		
		Val v = getHelper(k, cur.left);
		if(v!=null) {
			return v;
		}
		
		v = getHelper(k, cur.right);
		if(v!=null) {
			return v;
		}
		
		return null;
		
	}




	@Override
	public void set(Key k, Val v) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
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

package binaryTree;

public interface BinaryTree<Key, Value> {
	
	public int size();
	
	public Value get(Key k);
	
	public void set(Key k, Value v) throws Exception;
	
	public Value remove(Key k);
	
	public void add(Key k, Value v);
	
	public boolean containsKey(Key k);
	
	
	public void visitLevelOrder( Visitor<Key, Value> v);
	

	public void visitPreOrder( Visitor<Key, Value> v);


	public void visitInOrder( Visitor<Key, Value> v);

	public void visitPostOrder( Visitor<Key, Value> v);
}

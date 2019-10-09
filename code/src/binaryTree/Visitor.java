package binaryTree;

public interface Visitor<K,V> {

	public void visit(K key, V value);
	
}

package binaryTree;

public class PrintVisitor<K,V> implements Visitor< K,V> {

	@Override
	public void visit(K key, V value) {
		
		System.out.println("Key : " + key + " Value: " + value);
		
	}
	

}

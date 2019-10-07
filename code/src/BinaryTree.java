
public interface BinaryTree<Key, Value> {
	
	public int size();
	
	public Value get(Key k);
	
	public void set(Key k, Value v);
	
	public Value remove(Key k);
	
	public void add(Key k, Value v);
	
	public boolean containsKey(Key k);
	


}

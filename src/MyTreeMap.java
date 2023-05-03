@SuppressWarnings("unused")
public class MyTreeMap<K extends Comparable<K>, V> {
	Node<K, V> root = null;
	
	private static class Node<K extends Comparable<K>, V> {
		K key;
	    V value;
	    Node<K, V> left, right;
	    
		Node(K key, V value) {
			this.key = key;
			this.value = value; 
		}
	}
	public MyTreeMap() {
	}
	private Node<K, V> node(Node<K, V> current, K key) {
		if(current == null) {
			return current;
		}
		if(key.compareTo(current.key) > 0) {
			return node(current.right, key);
		}
		else if(key.compareTo(current.key) < 0) {
			return node(current.left, key);
		}
		else {
			return current;
		}
	}
	private Node<K, V> put(Node<K, V> current, K key, V value) {
		if(current == null || key == current.key) {
			return new Node<>(key, value);
		}
		if(key.compareTo(current.key) > 0) {
			current.right = put(current.right, key, value);
		}
		else if(key.compareTo(current.key) < 0) {
			current.left = put(current.left, key, value);
		}
		return current;
	}
	private Node<K, V> remove(Node<K, V> current, K key) {
		if(current == null) {
			return null;
		}
		if(key == current.key) {
			if(current.left == null && current.right == null) {
				return null;
			}
			if(current.left == null) {
				return current.right;
			}
			if(current.right == null) {
				return current.left;
			}
			Node<K, V> smallest = findSmallest(current.right);
			current = smallest;
			current.right = remove(current.right, current.key);
			return current;
		}
		if(key.compareTo(current.key) < 0) {
			current.left = remove(current.left, key);
			return current;
		}
		current.right = remove(current.right, key);
		return current;
	}
	private Node<K, V> findSmallest(Node<K, V> current) {
		return current.left == null ? current : findSmallest(current.left);
	}
	public V get(K key) {
		if(node(root, key) != null)
			return node(root, key).value;
		else return null;
	}
	public void put(K key, V value) {
		if(root == null) {
			root = new Node<>(key, value);
		}
		put(root, key, value);
	}
	public void remove(K key) {
		if(key == root.key)
			root = null;
		remove(root, key);
	}
}  

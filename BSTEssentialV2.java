//Jayden Godbold 
package algs4;

import algs4.Queue;
import algs4.StdDraw;

/*
 * This is a simplified version of the BST class
 * from the algs4 package.  This is used as part of
 * an assignment for writing a tree traversal method.
 *
 */

public class BSTEssentialV2<K extends Comparable<? super K>, V> {

	private Node<K,V> root;             // root of BST
	private int size;

	private static class Node<K extends Comparable<? super K>,V> {
		public K key;       			// sorted by key
		public V val;             		// associated data
		public Node<K,V> left, right;  	// left and right subtrees

		public Node(K key, V val) {
			this.key = key;
			this.val = val;
		}
	}

	public BSTEssentialV2() {
		this.root = null;
		this.size = 0;
	}

	/* *********************************************************************
	 * Return the number of key-values pairs in the BST.
	 ***********************************************************************/
	public int size() { return this.size; }

	/* *********************************************************************
	 * Does there exist a key-value pair with given key?
	 ***********************************************************************/
	public boolean contains(K key) {
		return get(key) != null;
	}

	/* *********************************************************************
	 *  Search BST for given key, and return associated value if found,
	 *  return null if not found
	 ***********************************************************************/
	public V get(K key) { return get(root, key); }

	private V get(Node<K,V> x, K key) {
		if (x == null) return null;
		int cmp = key.compareTo(x.key);
		if      (cmp < 0) return get(x.left, key);
		else if (cmp > 0) return get(x.right, key);
		else              return x.val;
	}

	/* *********************************************************************
	 *  Insert key-value pair into BST
	 *  If key already exists, update with new value
	 ***********************************************************************/
	public void put(K key, V val) {
		if (val == null) { delete(key); return; }
		root = put(root, key, val);
	}

	private Node<K,V> put(Node<K,V> x, K key, V val) {
		if (x == null) {
			this.size++;
			return new Node<>(key, val);
		}
		int cmp = key.compareTo(x.key);
		if      (cmp < 0)
			x.left  = put(x.left,  key, val);
		else if (cmp > 0)
			x.right = put(x.right, key, val);
		else
			x.val   = val;
		return x;
	}

	/* *********************************************************************
	 *  Delete a key-value pair, given the key.
	 ***********************************************************************/

	public void delete(K key) {
		root = delete(root, key);
	}

	private Node<K,V> delete(Node<K,V> x, K key) {
		if (x == null) return null;
		int cmp = key.compareTo(x.key);
		if      (cmp < 0) x.left  = delete(x.left,  key);
		else if (cmp > 0) x.right = delete(x.right, key);
		else {
			this.size--;
			// x is the node to be deleted.
			// The value returned in each of these cases below
			// becomes the value of the child reference from
			// the parent of x.  Returning a null makes that
			// reference a null and so cuts x off, causing its
			// automatic deletion.

			// Determine how many children x has.
			if (x.right == null && x.left == null){
				// This is a leaf node.  Change its
				// reference from its parent to null.
				return null;
			} else if (x.right == null) {
				// One child, to the left.  Make that
				// the new child of x's parent.
				return x.left;
			} else if (x.left == null) {
				// One child, to the right.  Make that
				// the new child of x's parent.
				return x.right;
			} else {
				// Node x has two children.
				// Find the node in x's left subtree with
				// the maximum key.
				Node<K,V> leftTreeMaxNode = findMax(x.left);
				// Copy the key and value from that maximum
				// key node to x, thereby overwriting x's
				// original key and value.
				x.key = leftTreeMaxNode.key;
				x.val = leftTreeMaxNode.val;
				// Delete the node copied from.
				x.left = delete(x.left, leftTreeMaxNode.key);
			}
		}
		return x;
	}

	private Node<K,V> findMax(Node<K,V> x) {
		Node<K,V> temp = x;
		// Follow right children until you get to
		// a node with no right child.  That node
		// has the maximum key in the tree rooted at x.
		while (temp.right != null) {
			temp = temp.right;
		}
		return temp;
	}

	public Iterable<K> keys() {
		Queue<K> q = new Queue<>();
		inOrder(root, q);
		return q;
	}

	// This is an in-order traversal: visit left, visit x, visit right
	// Pre-order: visit x, visit left, visit right
	// Post-order: visit left, visit right, visit x
	private void inOrder(Node<K,V> x, Queue<K> q) {
		if (x == null) return;
		inOrder(x.left, q);
		q.enqueue(x.key);
		inOrder(x.right, q);
	}

	/*
	 * Place your definition of the public non-recursive countValue here.
	 */
	public int countValue(V value) {
		return countValue(root, value);
	}
	/*
	 * Place your definition of the private recursive countValue here.
	 */
	private int countValue(Node<K,V>x, V value) {
		if (x==null) {
			return 0;
		}
		int countLeft = countValue(x.left, value);
		int countRight = countValue(x.right, value);
		int count = countLeft + countRight;
		if (x.val.equals(value)) {
			count++;
		}
		return count;
	}
	
	public int height() {
		return height(root);
	}

	private int height(Node<K,V> x) {
		if (x == null) return -1;
		return 1+Math.max(height(x.left), height(x.right));
	}

	/* ***************************************************************************
	 *  Visualization
	 *****************************************************************************/

	public void drawTree() {
		if (root != null) {
			StdDraw.setPenColor (StdDraw.BLACK);
			StdDraw.setCanvasSize(1200,700);
			drawTree(root, .5, 0.95, .25, 0);
		}
	}
	private void drawTree (Node<K,V> n, double x, double y, double range, int depth) {
		int CUTOFF = 10;
		StdDraw.text (x, y, n.key.toString()+":"+n.val.toString());
		StdDraw.setPenRadius (.007);
		if (n.left != null && depth != CUTOFF) {
			StdDraw.line (x-range, y-.08, x-.01, y-.01);
			drawTree (n.left, x-range, y-.1, range*.5, depth+1);
		}
		if (n.right != null && depth != CUTOFF) {
			StdDraw.line (x+range, y-.08, x+.01, y-.01);
			drawTree (n.right, x+range, y-.1, range*.5, depth+1);
		}
	}
}

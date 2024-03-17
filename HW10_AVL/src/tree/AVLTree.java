// Name: Zhiyuan Chang
// Computing ID: vgs3qt
// Homework Name: HomeWork10 - AVL

package tree;

/**
 * Self-balancing AVL Tree
 * @author CS 2100 Team
 *
 * @param <T>
 */

public class AVLTree<T extends Comparable<T>> extends BinarySearchTree<T>{
	
	@Override
	public void insert(T data) {
		this.root = insert(data, this.root);
	}

	protected TreeNode<T> insert(T data, TreeNode<T> curNode) {
		// TODO: Implement this method
		// BST's insert method doesn't work, because height need update everytime to all node.
		// and the balance method need run everytime. So cannot use super.insert()
		if(curNode == null){ // If the tree is empty, make the inserted the root.
			TreeNode<T> temp = new TreeNode<>(data);
			curNode = temp;
			curNode.height = 1; // Make the height one since there is only on node now.
			return curNode;
		}
		int compare = curNode.data.compareTo(data); // Compare two data, give -1, 1, or 0.
		if(compare > 0){ // Data in curNode is larger, so the new data should be put in left side.
				curNode.left = insert(data, curNode.left);
		}
		else if(compare < 0) { // Data in curNode is smaller, so the new data should be put in right side.
				curNode.right = insert(data, curNode.right);
			}
		else{
			return curNode; // When the inserted is the same.
		}
		// Update height everytime.
		curNode.height = 1 + Math.max(height(curNode.left), height(curNode.right));
		// Check if it is balanced. If it is not balance, balance method will make it balance
		// If not balanced, curNode will be changed by the balance method
		// If balanced, balance method return the same input curNode so nothing change
		curNode = this.balance(curNode);
		return curNode;
	}

	@Override
	public void remove(T data) {
		/* Call remove starting at the root of the tree */
		this.root = remove(data, this.root);
	}

	protected TreeNode<T> remove(T data, TreeNode<T> curNode) {
		/* Call BST remove before balancing, use “super” to achieve this */
		curNode = super.remove(data,  curNode);
		/* Handle the case when remove returns null */
		if(curNode == null) return null;
		/* update the height of this node if necessary (if no change, that’s OK) */
		curNode.height = Math.max(height(curNode.left), height(curNode.right))+1;
		/* rotate if necessary (call balance() method to balance the node) */
		curNode = this.balance(curNode);
		return curNode;
	}

	/**
	 * Balances the given node. Assumes it is the lowest unbalanced node if unbalanced
	 * @param curNode
	 * @return
	 */

	private TreeNode<T> balance(TreeNode<T> curNode) {
		// TODO: Implement this method
		// If null, return null
		if(curNode == null){
			return null;
		}
		// Call balanceFactor method to check the balance
		int compare = balanceFactor(curNode);
		if(compare < -1 ){ // If the right side is "longer". Rotate it
			if(balanceFactor(curNode.right) > 0){
				// If there will be some node going to be out of place, rotate them first
				curNode.right = rotateRight(curNode.right);
			}
			curNode = rotateLeft(curNode);
		}
		else if(compare > 1){ // If the left side is "longer". Rotate it
			if (balanceFactor(curNode.left) < 0){
				// If there will be some node going to be out of place, rotate them first
				curNode.left = rotateLeft(curNode.left);
			}
			curNode = rotateRight(curNode);
		}
		return curNode;
	}

	private TreeNode<T> rotateRight(TreeNode<T> curNode) {
		// TODO: Implement this method
		TreeNode<T> tempNode = new TreeNode<T>(null);
		// Remember the curNode's left one.
		TreeNode<T> new_cur = curNode.left;
		// Remember the curNode's left's right one.
		tempNode = new_cur.right;
		// Switch positions.
		new_cur.right = curNode;
		curNode.left = tempNode;
		// Update the height recorded in each node after then change position.
		curNode.height = Math.max(height(curNode.left), height(curNode.right)) + 1;
		new_cur.height = Math.max(height(new_cur.left), height(new_cur.right)) + 1;
		return new_cur;
	}
	
	private TreeNode<T> rotateLeft(TreeNode<T> curNode){
		// TODO: Implement this method
		TreeNode<T> tempNode = new TreeNode<T>(null);
		// Remember the curNode's right one.
		TreeNode<T> new_cur = curNode.right;
		// Remember the curNode's right's left one.
		tempNode = new_cur.left;
		// Switch positions.
		new_cur.left = curNode;
		curNode.right = tempNode;
		// Update the height recorded in each node after then change position.
		curNode.height = Math.max(height(curNode.left), height(curNode.right)) + 1;
		new_cur.height = Math.max(height(new_cur.left), height(new_cur.right)) + 1;
		return new_cur;
	}
	
	private int balanceFactor(TreeNode<T> node) {
		// TODO: Implement this method
		// A function that checks the difference between height on both sides
		return height(node.left) - height(node.right);
	}

}
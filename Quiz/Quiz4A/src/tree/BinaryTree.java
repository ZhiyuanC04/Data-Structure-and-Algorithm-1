package tree;

public class BinaryTree<T> {

	protected TreeNode<T> root = null;
	
	/* Print methods */
	public String getInOrder() {
		return getInOrder(root);
	}
	private String getInOrder(TreeNode<T> curNode) {
		if(curNode != null) {			
			return getInOrder(curNode.left)
					+ curNode.data.toString() + " "
					+ getInOrder(curNode.right);
		}
		return "";
	}
	
	public String getPreOrder() {
		return getPreOrder(root);
	}
	private String getPreOrder(TreeNode<T> curNode) {
		if(curNode != null) {			
			return curNode.data.toString() + " "
					+ getPreOrder(curNode.left)
					+ getPreOrder(curNode.right);
		}
		return "";
	}
	
	public String getPostOrder() {
		return getPostOrder(root);
	}
	private String getPostOrder(TreeNode<T> curNode) {
		if(curNode != null) {			
			return getPostOrder(curNode.left)
					+ getPostOrder(curNode.right)
					+ curNode.data.toString() + " ";
		}
		return "";
	}
	
	/* A somewhat more pretty print method for debugging */
	public void printTree() {
		printTree(this.root, 0);
		System.out.println("\n\n");
	}
	private void printTree(TreeNode<T> curNode, int indentLev) {
		if(curNode == null) return;
		for(int i=0; i<indentLev; i++) {
			if(i == indentLev - 1) System.out.print("|-----");
			else System.out.print("      ");
		}
		System.out.println(curNode.data);
		printTree(curNode.left, indentLev+1);
		printTree(curNode.right, indentLev+1);
	}
	
	public String toString() {
		String result = treeToString(this.root);
		return result.trim().replaceAll("\\s+\\)", ")"); // remove extra spaces in the result
	}
	
	protected String treeToString(TreeNode<T> curNode) {
		if (curNode == null) {
			return "null ";
		}
		if (curNode.left == null && curNode.right == null) {
			return curNode.data + " ";
		}
		String res = "(" + curNode.data + " " + treeToString(curNode.left) + treeToString(curNode.right) + ") ";
		return res;
	}


	public int height() {
		return height(root);
	}
	
	/* Computes the height of the tree on the fly */
	protected int height(TreeNode<T> node) {
		if(node == null) return -1;
		return 1+ Math.max(height(node.left), height(node.right));
	}

	public boolean twoTree() { return twoTree(root); }
	/* Determines if tree is a two-tree meaning every node has either 0 or 2 children */
	// Name: Zhiyuan Chang
	// Computing ID: vgs3qt
	// Homework Name: Quiz4A
	protected boolean twoTree(TreeNode<T> node) {
		// Give true if the root is null.
		if(node == null){
			return true;
		}
		// Both side is null, true.
		if(node.right == null && node.left == null){
			return true;
		}
		// Both side has value, continue to check.
		if(node.left != null && node.right != null){
			return (twoTree(node.left) && twoTree(node.right));
		}
		// One side has value while the other side don't, return false.
		else{
			return false;
		}
	}
}

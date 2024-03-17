// Name: Zhiyuan Chang
// Computing ID: vgs3qt
// Homework Name: HomeWork9 - BST

package tree;
public class BinaryTree<T> {
    protected TreeNode<T> root = null;

    /* Tree Traversal methods */
    //HINT for three traversal methods: you can call toString() on the node's
    //     data when you are executing the "root" command on a given node
    //     (e.g. curNode.data.toString() + " ";) // Note the space added at the end

    public String getInOrder() {
        return getInOrder(root); // call getInOrder starting at the root!
    }
    private String getInOrder(TreeNode<T> curNode) {
        //TODO: return the in order traversal of this tree, space separated
        String result = "";
        if(curNode == null){ // Empty tree
            return result;
        }
        if(curNode.left != null){ // Check left first becasue we start from the left bottom.
            result += getInOrder(curNode.left);
        }
        // When no node is on the left, we start to add the value to result.
        result += curNode.data.toString() + " "; // Add the curNode data into the string. One space.
        // Check if there are node on the right, and add their value to the result.
        if(curNode.right != null){ // Go to right bottom and add them to result.
            result += getInOrder(curNode.right);
        }
        return result;
    }

    public String getPreOrder() {
        return getPreOrder(root); // call getPreOrder starting at the root!
    }
    private String getPreOrder(TreeNode<T> curNode) {
        //TODO: return the pre order traversal of this tree, space separated
        String result = ""; // Empty String at first
        if(curNode == null){ // Empty tree
            return result;
        }
        result += curNode.data.toString() + " "; // Add the curNode data into the string. One space.
        if(curNode.left != null){
            result += getPreOrder(curNode.left); // Add the node left to it into the string.
            // No space needed since they have space added already.
            // And the method will return a value with the space added
        }
        if(curNode.right != null){
            result += getPreOrder(curNode.right); // Add the node right to it into the string.
        }
        return result; // Final result
    }

    public String getPostOrder() {
        return getPostOrder(root);  // call getPostOrder starting at the root!
    }
    private String getPostOrder(TreeNode<T> curNode) {
        //TODO: return the post order traversal of this tree, space separated
        String result = "";
        if(curNode == null){ // Empty tree
            return result;
        }
        if(curNode.left != null) { // Go to left bottom first.
            result += getPostOrder(curNode.left);
        }
        if(curNode.right != null){ // Check if there are node at right.
            // If there are node at right, go to right and add their value first.
            result += getPostOrder(curNode.right);
        }
        result += curNode.data.toString() + " "; // Add the value to Result.
        return result;
    }

    //------------------------------------------------------------------------
    //EVERYTHING BELOW THIS POINT IS IMPLEMENTED FOR YOU
    //YOU SHOULD STILL LOOK AT THIS CODE
    //------------------------------------------------------------------------

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

    //TODO: Look at these methods and think about how they might be useful for this assignment
    public int height() {
        return height(root);
    }
    /* Computes the height of the tree on the fly */
    protected int height(TreeNode<T> node) {
        if(node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

}
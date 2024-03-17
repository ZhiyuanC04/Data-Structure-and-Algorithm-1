// Name: Zhiyuan Chang
// Computing ID: vgs3qt
// Homework Name: HomeWork10 - AVL

package tree;
public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T> implements Tree<T>{

    @Override
    public void insert(T data) {
        this.root = insert(data, root);
    }
    /**
     * Helper method for inserting recursively
     * @param data
     * @param curNode
     * @return a reference to the new root of the subtree
     */
    protected TreeNode<T> insert(T data, TreeNode<T> curNode) {
//        System.out.println("insert run");
        //TODO: Implement this method
        if(curNode == null){ // If the tree is empty, make the inserted the root.
            TreeNode<T> temp = new TreeNode<>(data);
            curNode = temp;
            curNode.height = 0;
            return curNode;
        }
        int compare = curNode.data.compareTo(data); // Compare two data, give -1, 1, or 0.
        if(compare == 0){ // Two data are the same.
            return curNode;
        }
        else if(compare < 0) { // Data in curNode is smaller, so the new data should be put in right side.
            if (curNode.right == null) { // If the position is empty. Add.
                TreeNode<T> temp = new TreeNode<>(data);
                curNode.right = temp;
            }
            else { // If not empty, find the empty one on its right side.
                insert(data, curNode.right);
            }
        }
        else{ // Data in curNode is larger, so the new data should be put in left side.
            if(curNode.left == null) {
                TreeNode<T> temp = new TreeNode<>(data);
                curNode.left = temp;
            }
            else {
                insert(data, curNode.left);
            }
        }
        curNode.height = 1 + Math.max(height(curNode.left), height(curNode.right));
        return curNode;
    }

    @Override
    public boolean find(T data) {
        return find(data, root);
    }
    /**
     * Returns a boolean (true of false) if the element was found in a BST
     */
    private boolean find(T data, TreeNode<T> curNode) {
        // Helper method
        //TODO: Implement this method
        Boolean value_found = false;
        if(curNode == null){
            return false; // Empty tree.
        }
        if(curNode.data.equals(data)){ // If we found the matched value.
            value_found = true;
            return value_found;
        }
        if(curNode.left != null){ // Check the left side.
            value_found = find(data, curNode.left);
        }
        if(value_found){ // Because it's all if, so have to check if the value is found in left side.
            return value_found;
        }
        if(curNode.right != null){ // Check the right side.
            value_found = find(data, curNode.right);
        }
        return value_found;
    }

    public T findMax() {
        return findMax(this.root);
    }
    /**
     * Returns the max item in the given subtree
     */
    private T findMax(TreeNode<T> curNode) {
        // Helper method
        //TODO: Implement this method
        if(curNode.right != null){ // If right side has more node, meaning they are greater than curNode.
            return findMax(curNode.right); // Find the max value.
        }
        return curNode.data;
    }

    //-----------------------------------------------------------------------------
    //EVERYTHING BELOW THIS POINT IS IMPLEMENTED FOR YOU: (Don't change anything!)
    //WE HAVE IMPLEMENTED THE REMOVE METHOD FOR YOU
    //YOU SHOULD STILL LOOK AT THIS CODE AND TRY YOUR BEST TO UNDERSTAND IT
    //-----------------------------------------------------------------------------

    @Override
    public void remove(T data) {
        this.root = remove(data, root); // Call remove at the root of the tree
    }
    protected TreeNode<T> remove(T data, TreeNode<T> curNode) {
        /* Note the use of compareTo() in the solution! */
        if(curNode == null) return curNode;
            // if item I want to remove is smaller than the data of the current node...
        else if (data.compareTo(curNode.data) < 0) {
            curNode.left = remove(data, curNode.left); // recursively call remove on LEFT subtree
        }
        // if item I want to remove is larger than the data of the current node...
        else if (data.compareTo(curNode.data) > 0) {
            curNode.right = remove(data, curNode.right); // recursively call remove on RIGHT subtree
        }
        else { /* Found it, time to remove */
            if(curNode.left == null && curNode.right == null)		return null;
            else if(curNode.left != null && curNode.right == null)	return curNode.left;
            else if(curNode.left == null && curNode.right != null)	return curNode.right;
            else {
                T toDel = findMax(curNode.left);
                curNode.data = toDel;
                curNode.left = remove(toDel, curNode.left);
                return curNode;
            }
        }
        return curNode;
    }

}
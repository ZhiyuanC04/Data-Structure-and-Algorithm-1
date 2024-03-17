package tester;

import tree.AVLTree;
import tree.BinarySearchTree;

public class AVLTreeTester {

	public static void main(String[] args) {
		
		/* Here are two test cases for your implementations. */
		/* You SHOULD create more */
		
		/*
		 * 	Correct output:		  	
		 *	AVL Pre: 4 2 1 3 8 6 5 7 9 
		 *	AVL In: 1 2 3 4 5 6 7 8 9 
		 *	AVL Post: 1 3 2 5 7 6 9 8 4 
		 */
		AVLTree<Integer> avl = new AVLTree<Integer>();
		
		
		int[] toInsert = {5,4,3,2,1,9,8,7,6};
		
		for(int i : toInsert) {
			avl.insert(i);
			System.out.println("insert:"+i);
			System.out.print("AVL Pre: " + avl.getPreOrder());
			System.out.print("----\n");
		}
		
		/* Print out pre, in, and post-order */		
		System.out.print("AVL Pre: " + avl.getPreOrder());
		System.out.print("AVL In: " + avl.getInOrder());
		System.out.print("AVL Post: " + avl.getPostOrder());
		
	}
}

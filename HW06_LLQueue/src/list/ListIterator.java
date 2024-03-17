// Name: Zhiyuan Chang
// Computing ID: vgs3qt
// Homework Name: HW 6 - LLQueue

package list;
public class ListIterator<T> {
	// Current node (of type ListNode)
	protected ListNode<T> curNode; 

	public ListIterator(ListNode<T> currentNode) {
		// ListIterator constructor. Accepts the current node.
		this.curNode = currentNode;
	}

	public boolean isPastEnd() {
		// These two methods tell us if the iterator has run off the list on either side
		// head and tail have null in its data.
		if(curNode.getData() == null) {
			return true;
		}
		return false;
	}
	
	public boolean isPastBeginning() {
		// These two methods tell us if the iterator has run off the list on either side
		// head and tail have null in its data.
		if(curNode.getData() == null) {
			return true;
		}
		return false;
	}

	public T value() {
		//  Get the data at the current iterator position
		//	Return the data if appropriate, otherwise return null
		if(curNode.getData() == null)
			return null;
		return curNode.getData();
	}

	public void moveForward() {
		// These two methods move the cursor of the iterator
		// forward / backward one position
		// Remember to check IF you can move backwards before you do!
		if(!(isPastBeginning())) {
			curNode = curNode.prev;
		}
	}
	
	public void moveBackward() {
		// These two methods move the cursor of the iterator
		// forward / backward one position
		// Remember to check IF you can move backwards before you do!
		if(!(isPastEnd())){
			curNode = curNode.next;
		}
	}
}



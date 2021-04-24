package ADTPackage;

/**
   A class that implements a queue of objects by using
   a chain of linked nodes that has both head and tail references.
 
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public final class LinkedQueue<T> implements QueueInterface<T>
{
   private Node<T> firstNode; // References node at front of queue
   private Node<T> lastNode;  // References node at back of queue
  	
	public LinkedQueue()
	{
		firstNode = null;
		lastNode = null;
	} // end default constructor

//  < Implementations of the queue operations go here. >
//  . . .
	public void enqueue(T newEntry) {
		Node<T> newNode = new Node<T>(newEntry, null);
		if (isEmpty())
			firstNode = newNode;
		else
			lastNode.setNextNode(newNode);
		lastNode = newNode; //Check this later
	}

	public T dequeue() {
		T front = null;
		if (!isEmpty()) {
			front = firstNode.getData();
			firstNode = firstNode.getNextNode();
			if (firstNode == null)
				lastNode = null;
		}//end if
		return front;
	}

	public T getFront() {
		T front = null;
		if (!isEmpty())
			front = firstNode.getData();
		return front;
	}

	public boolean isEmpty() {
		return ((firstNode == null) && (lastNode == null));
	}//end isEmpty()

	public void clear() {
		firstNode = null;
		lastNode = null;
	}

	private class Node<T>
	{
		private T    data; // Entry in queue
		private Node<T> next; // Link to next node
      
		private Node(T dataPortion)
		{
			data = dataPortion;
			next = null;
		} // end constructor
		
		private Node(T dataPortion, Node<T> linkPortion)
		{
			data = dataPortion;
			next = linkPortion;
		} // end constructor
      
		private T getData()
		{
			return data;
		} // end getData
      
		private void setData(T newData)
		{
			data = newData;
		} // end setData
      
		private Node<T> getNextNode()
		{
			return next;
		} // end getNextNode
		
		private void setNextNode(Node<T> nextNode)
		{
			next = nextNode;
		} // end setNextNode
	} // end Node
} // end LinkedQueue

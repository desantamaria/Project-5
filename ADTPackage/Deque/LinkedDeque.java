package ADTPackage.Deque;

/**
   A class that implements the a deque of objects by using 
   a chain of doubly linked nodes.
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public final class LinkedDeque<T> implements DequeInterface<T>
{
   private DLNode firstNode; // References node at front of deque
   private DLNode lastNode;  // References node at back of deque
	
	public LinkedDeque()
	{
		firstNode = null;
		lastNode = null;
	} // end default constructor
  
//  < Implementations of the deque operations go here. >
//  . . .
  
   private class DLNode
   {
		private T      data;  	 // Deque entry
		private DLNode next;  	 // Link to next node
		private DLNode previous; // Link to previous node
    
//    < Constructors and the methods getData, setData, getNextNode, setNextNode, 
//      getPreviousNode, and setPreviousNode are here. >
//    . . .
    
  } // end DLNode

   @Override
   public void addToFront(T newEntry) {
      // TODO Auto-generated method stub
      
   }

   @Override
   public void addToBack(T newEntry) {
      // TODO Auto-generated method stub
      
   }

   @Override
   public T removeFront() {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public T removeBack() {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public T getFront() {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public T getBack() {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public boolean isEmpty() {
      // TODO Auto-generated method stub
      return false;
   }

   @Override
   public void clear() {
      // TODO Auto-generated method stub
      
   }
} // end LinkedDeque

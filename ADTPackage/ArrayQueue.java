package ADTPackage.Queue;

/**
   A class that implements a queue of objects by using an array.
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public final class ArrayQueue<T> implements QueueInterface<T>
{
   private T[] queue; // Circular array of queue entries and one unused element
   private int frontIndex;
   private int backIndex;
   private boolean integrityOK;
   private static final int DEFAULT_CAPACITY = 50;
	private static final int MAX_CAPACITY = 10000;
   
   public ArrayQueue()
   {
      this(DEFAULT_CAPACITY);
   } // end default constructor
   
   public ArrayQueue(int initialCapacity)
   {
      integrityOK = false;
      //checkCapacity(initialCapacity);
      
      // The cast is safe because the new array contains null entries
      @SuppressWarnings("unchecked")
      T[] tempQueue = (T[]) new Object[initialCapacity + 1];
      queue = tempQueue;
      frontIndex = 0;
      backIndex = initialCapacity;
      integrityOK = true;
   } // end constructor

	public void enqueue(T newEntry) {
		ensureCapacity();
		backIndex = (backIndex + 1) % queue.length;
		queue[backIndex] = newEntry;
	}//end enqueue

	public T dequeue() {
		T front = null;
		if (!isEmpty()) {
			front = queue[frontIndex];
			queue[frontIndex] = null;
			frontIndex = (frontIndex + 1) % queue.length;
		}
		return front;
	}

	public T getFront() {
		T front = null;
		if (!isEmpty())
			front = queue[frontIndex];
		return front;
	}

	public boolean isEmpty() {
		return frontIndex == ((backIndex +1) % queue.length);
	}

	public void clear() {
		while (!isEmpty()) {
			dequeue();
		}
		frontIndex = 0;
		backIndex = queue.length - 1;
	}
	
	// Doubles the size of Array queue if it's full.
	private void ensureCapacity() {
		T[] oldQueue = queue;
		int oldSize = oldQueue.length;
		
		// The case is safe because the new array contains null entries.
		@SuppressWarnings("unchecked")
		T[] tempQueue = (T[]) new Object[2 * oldSize];
		queue = tempQueue;
		for (int index = 0; index < oldSize -1; index++) {
			queue[index] = oldQueue[frontIndex];
			frontIndex = (frontIndex + 1) % oldSize;
		}//end for
		frontIndex = 0;
		backIndex = oldSize - 2;
	}
//  < Implementations of the queue operations go here. >
//  . . .
  
} // end ArrayQueue

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

   @Override
   public void enqueue(T newEntry) {
      // TODO Auto-generated method stub
      
   }

   @Override
   public T dequeue() {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public T getFront() {
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

//  < Implementations of the queue operations go here. >
//  . . .
  
} // end ArrayQueue

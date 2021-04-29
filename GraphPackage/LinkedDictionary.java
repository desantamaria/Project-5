package GraphPackage;
import java.util.Iterator;

public class LinkedDictionary<K, V> implements DictionaryInterface<K, V>
{

    private int numberOfEntries;

    private Node<K,V> firstNode;

    
    public LinkedDictionary() {
        this.firstNode = new Node<K,V>(null,null);
        
        this.firstNode.next = null;
    } // LinkedDictionary
  
	public LinkedDictionary(K input) {
        this.firstNode = new Node<K,V>(null,null);
        
        this.firstNode.next = null;
    } // LinkedDictionary
    

    private class Node<K, V>
	{
		private K    data;
        private V    value;
		private Node<K, V> next; // Link to next node
      
		private Node(K searchKey, V dataValue)
		{
			data = searchKey;
			value = dataValue;
            next = null;
		} // end constructor
		
		private Node(K searchKey, V dataValue, Node<K, V> nextNode)
		{
			data = searchKey;
            value = dataValue;
			next = nextNode;
		} // end constructor
      
		private K getData()
		{
			return data;
		} // end getData
      
		private void setData(K newData)
		{
			data = newData;
		} // end setData
      
		private Node<K,V> getNextNode()
		{
			return next;
		} // end getNextNode
		
		private void setNextNode(Node<K, V> nextNode)
		{
			next = nextNode;
		} // end setNextNode
	} // end Node


	@Override
	public V add(K key, V value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V remove(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V getValue(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(K key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<K> getKeyIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<V> getValueIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
}
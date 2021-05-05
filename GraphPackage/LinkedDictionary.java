package GraphPackage;
import java.util.Iterator;

import javax.naming.directory.SearchResult;

public class LinkedDictionary<K, V> implements DictionaryInterface<K, V>
{
	private Node firstNode;
    private int numberOfEntries;
    
    public LinkedDictionary() {
        this.firstNode = new Node(null,null);
        
        this.firstNode.next = null;
    } // LinkedDictionary
  
	public LinkedDictionary(K input) {
        this.firstNode = new Node(null,null);
        
        this.firstNode.next = null;
    } // LinkedDictionary
    

	public void add(K key, V value) {
		//checkIntegrity()
		//checkParamters()
		SearchResult sr = locatekey(key);
		if(sr.found) {
			sr.node.value = value;
		}
		else {
			if(node == null) 
				Node node = new Node(key, value, firstNode.nextNode);
			else
				Node node = new Node(key, value, sr.priorNode.nextNode);
		}
	}

	public V remove(K key) {

		V result = null;
		SearchResult sr = locate(key);
		if(sr.found) {
			result = sr.node;
		}
	}


	public V getValue(K key) {

		return null;
	}


	public boolean contains(K key) {
		try {
            // If find succeeds, the key is there.
            //find(key);
            return true;
        } catch (Exception e) {
            // If find doesn't succed, the key is not there.
            return false;
        } // try/catch
	}


	public Iterator<K> getKeyIterator() {

		return null;
	}


	public Iterator<V> getValueIterator() {

		return null;
	}


	public boolean isEmpty() {

		return false;
	}


	public int getSize() {

		return numberOfEntries;
	}


	public void clear() {
		firstNode = null;
		numberOfEntries = 0;
	}


    private class Node
	{
		private K    data;
        private V    value;
		private Node next; // Link to next node
      
		private Node(K searchKey, V dataValue)
		{
			data = searchKey;
			value = dataValue;
            next = null;
		} // end constructor
		
		private Node(K searchKey, V dataValue, Node nextNode)
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

		private V getValue() 
		{
			return value;
		}

		private void setValue(V newValue) 
		{
			value = newValue;
		}
      
		private Node getNextNode()
		{
			return next;
		} // end getNextNode
		
		private void setNextNode(Node nextNode)
		{
			next = nextNode;
		} // end setNextNode
	} // end Node


	
}
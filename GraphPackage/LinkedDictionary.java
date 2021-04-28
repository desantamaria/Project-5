package GraphPackage;
import java.util.Iterator;

public class LinkedDictionary<T, K, V> {

    private int numberOfEntries;

    private Node<K,V> firstNode;

    
    public LinkedDictionary() {
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
}
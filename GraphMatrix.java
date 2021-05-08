import java.util.Iterator;

import ADTPackage.Dictionary.DictionaryInterface;
import ADTPackage.Dictionary.UnsortedLinkedDictionary;
import ADTPackage.Queue.LinkedQueue;
import ADTPackage.Queue.QueueInterface;
import ADTPackage.Stack.ResizeableArrayStack;
import ADTPackage.Stack.StackInterface;
import GraphPackage.GraphInterface;
import GraphPackage.Vertex;
import GraphPackage.VertexInterface;

public final class GraphMatrix<T> implements GraphInterface<T> {
    
    private DictionaryInterface<T, VertexInterface<T>> vertices;
    private int edgeCount;

    public GraphMatrix()
    {
        vertices = new UnsortedLinkedDictionary<>();
        edgeCount = 0;
    }

       /** Adds a given vertex to this graph.
       @param vertexLabel  An object that labels the new vertex and is
                           distinct from the labels of current vertices.
       @return  True if the vertex is added, or false if not. */
   public boolean addVertex(T vertexLabel)
   {
        VertexInterface<T> addOutcome = vertices.add(vertexLabel, new Vertex<>(vertexLabel));
        return addOutcome == null; // Was addition to dictionary successful?
   }

   /** Adds a weighted edge between two given distinct vertices that 
       are currently in this graph. The desired edge must not already 
       be in the graph. In a directed graph, the edge points toward
       the second vertex given.
       @param begin  An object that labels the origin vertex of the edge.
       @param end    An object, distinct from begin, that labels the end
                     vertex of the edge.
       @param edgeWeight  The real value of the edge's weight.
       @return  True if the edge is added, or false if not. */
   public boolean addEdge(T begin, T end, double edgeWeight)
   {
        boolean result = false;
        VertexInterface<T> beginVertex = vertices.getValue(begin);
        VertexInterface<T> endVertex = vertices.getValue(end);
        if ( (beginVertex != null) && (endVertex != null) )
            result = beginVertex.connect(endVertex, edgeWeight);
        if (result)
            edgeCount++;
        return result;
   }

   /** Adds an unweighted edge between two given distinct vertices 
       that are currently in this graph. The desired edge must not
       already be in the graph. In a directed graph, the edge points 
       toward the second vertex given.
       @param begin  An object that labels the origin vertex of the edge.
       @param end    An object, distinct from begin, that labels the end
                     vertex of the edge.
       @return  True if the edge is added, or false if not. */
   public boolean addEdge(T begin, T end)
   {
        return addEdge(begin, end, 0);
   }

   /** Sees whether an edge exists between two given vertices.
       @param begin  An object that labels the origin vertex of the edge.
       @param end    An object that labels the end vertex of the edge.
       @return  True if an edge exists. */
   public boolean hasEdge(T begin, T end)
   {
        boolean found = false;
        VertexInterface<T> beginVertex = vertices.getValue(begin);
        VertexInterface<T> endVertex = vertices.getValue(end);
        if ( (beginVertex != null) && (endVertex != null) )
        {
        Iterator<VertexInterface<T>> neighbors = beginVertex.getNeighborIterator();
        while (!found && neighbors.hasNext())
        {
            VertexInterface<T> nextNeighbor = neighbors.next();
            if (endVertex.equals(nextNeighbor))
                found = true;
        } // end while
        } // end if
        return found;
   }

   /** Sees whether this graph is empty.
       @return  True if the graph is empty. */
   public boolean isEmpty()
   {
        return vertices.isEmpty();
   }

   /** Gets the number of vertices in this graph.
       @return  The number of vertices in the graph. */
   public int getNumberOfVertices()
   {
        return vertices.getSize();
   }

   /** Gets the number of edges in this graph.
      @return  The number of edges in the graph. */
   public int getNumberOfEdges()
   {
        return edgeCount;
   }

   /** Removes all vertices and edges from this graph resulting in an empty graph. */
   public void clear()
   {
        vertices.clear();
        edgeCount = 0;
   }

   protected void resetVertices()
    {
        Iterator<VertexInterface<T>> vertexIterator = vertices.getValueIterator();
        while (vertexIterator.hasNext())
        {
            VertexInterface<T> nextVertex = vertexIterator.next();
            nextVertex.unvisit();
            nextVertex.setPredecessor(null);
        } // end while
    } // end resetVertices

   public QueueInterface<T> getBreadthFirstTraversal(T origin)
    {
        resetVertices();
        QueueInterface<T> traversalOrder = new LinkedQueue<>();
        QueueInterface<VertexInterface<T>> vertexQueue = new LinkedQueue<>();
        VertexInterface<T> originVertex = vertices.getValue(origin);
        originVertex.visit();
        traversalOrder.enqueue(origin); // Enqueue vertex label
        vertexQueue.enqueue(originVertex); // Enqueue vertex
        while (!vertexQueue.isEmpty())
        {
            VertexInterface<T> frontVertex = vertexQueue.dequeue();
            Iterator<VertexInterface<T>> neighbors = frontVertex.getNeighborIterator();
            while (neighbors.hasNext())
            {
                VertexInterface<T> nextNeighbor = neighbors.next();
                if (!nextNeighbor.isVisited())
                {
                    nextNeighbor.visit();
                    traversalOrder.enqueue(nextNeighbor.getLabel());
                    vertexQueue.enqueue(nextNeighbor);
                } // end if
            } // end while
        } // end while
        return traversalOrder;
    } // end getBreadthFirstTraversal

    public QueueInterface<T> getDepthFirstTraversal(T origin) {
        resetVertices();
        QueueInterface<T> traversalOrder = new LinkedQueue<>();
        StackInterface<VertexInterface<T>> vertexStack = new ResizeableArrayStack<>();
        
        VertexInterface<T> originVertex = vertices.getValue(origin);
        originVertex.visit();
        
        traversalOrder.enqueue(origin); // Enqueue vertex
        vertexStack.push(originVertex); // push vertex
            
        
        while (!vertexStack.isEmpty())
        {
            VertexInterface<T> topVertex = vertexStack.peek();
            VertexInterface<T> nextNeighbor = topVertex.getUnvisitedNeighbor();
                
            if (nextNeighbor != null)
            {
                nextNeighbor.visit();

                traversalOrder.enqueue(nextNeighbor.getLabel());
                vertexStack.push(nextNeighbor);
            } // end if
            else 
            {
                vertexStack.pop();
            } // end else
        } // end while
            return traversalOrder;
    } // end getDepthFirstTraversal
}
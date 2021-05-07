import ADTPackage.Queue.*;
import GraphPackage.*;

public class TestFile {
    public static void main(String[] args)
    {
        GraphInterface<Character> Matrix1 = new GraphMatrix<>();

        //Add vertices to the graph
        Matrix1.addVertex('A');
        Matrix1.addVertex('B');
        Matrix1.addVertex('C');
        Matrix1.addVertex('D');
        Matrix1.addVertex('E');
        Matrix1.addVertex('F');
        Matrix1.addVertex('G');
        Matrix1.addVertex('H');
        Matrix1.addVertex('I');

        //Connect the vertices
        Matrix1.addEdge('A', 'B');
        Matrix1.addEdge('A', 'E');
        Matrix1.addEdge('A', 'D');
        Matrix1.addEdge('B', 'E');
        Matrix1.addEdge('D', 'G');
        Matrix1.addEdge('E', 'F');
        Matrix1.addEdge('E', 'H');
        Matrix1.addEdge('G', 'H');
        Matrix1.addEdge('H', 'I');
        Matrix1.addEdge('F', 'H');
        Matrix1.addEdge('F', 'C');
        Matrix1.addEdge('C', 'B');

        QueueInterface<Character> breadthFirstTravel = Matrix1.getBreadthFirstTraversal('A');
        System.out.print("Breadth First Travel: ");
        while(!breadthFirstTravel.isEmpty())
        {
            System.out.print(breadthFirstTravel.dequeue() + ", ");
        }

        QueueInterface<Character> depthFirstTravel = Matrix1.getBreadthFirstTraversal('A');
        System.out.print("Depth First Travel: ");
        while(!depthFirstTravel.isEmpty())
        {
            System.out.print(depthFirstTravel.dequeue() + ", ");
        }
    }
}

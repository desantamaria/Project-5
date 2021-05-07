public class DriverBT {
    public static void main(String[] args) {
        GraphMatrix<Integer> g = new GraphMatrix<>();
 
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
 
        System.out.println("Following is Breadth First Traversal "+
                           "(starting from vertex 2)");
 
        g.getBreadthFirstTraversal(2);


    }
    
}

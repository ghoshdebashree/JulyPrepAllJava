import java.util.*;

public class BFStraversalGRAPH {
    public static void main(String[] args){
        // Define the graph as an adjacency list
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(1, 2));
        graph.put(1, Arrays.asList(2));
        graph.put(2, Arrays.asList(1, 3));
        graph.put(3, Arrays.asList(0));

        // Define the source vertex
        int source = 2;

        // Perform DFS traversal
        List<Integer> traversalOrder = dfsTraversal(graph, source);

        // Print the result
        System.out.println(traversalOrder);  // Output should be the DFS traversal order starting from vertex 2
    }

    private static List dfsTraversal(Map<Integer,List<Integer>> graph, int source) {
        Stack<Integer> stack = new Stack<>();
        stack.push(source);
        Set<Integer> visited = new HashSet<>();
        visited.add(source);
        List<Integer> result = new ArrayList<>();
        while(!stack.isEmpty()){
            int vertex = stack.pop();
            result.add(vertex);
            List<Integer> neighbors = graph.getOrDefault(vertex, new ArrayList<>());
            for(int neighbor : neighbors){
                if(!visited.contains(neighbor)){
                    visited.add(neighbor);
                    stack.push(neighbor);
                }
            }
        }
        return result;
    }


}

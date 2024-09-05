import java.util.Arrays;

public class TravellingSalesManGRAPH {
    public static final int INF = Integer.MAX_VALUE / 2;
    public static void main(String[] args){
        int[][] graph = {
                { 0, 10, 15, 20 },
                { 10, 0, 35, 25 },
                { 15, 35, 0, 30 },
                { 20, 25, 30, 0 }
        };
        int result = tsp(graph);
        System.out.println("The shortest path has distance: " + result);
    }

    private static int tsp(int[][] graph) {

        int n = graph.length;
        int[][] dp = new int[n][1 << n];

        // Initialize DP table with INF (infinity)
        for (int[] row : dp) {
            Arrays.fill(row, INF);
        }

        // Start at the first city (index 0) with a visit state of only the first city being visited
        dp[0][1] = 0;

        // Iterate over all possible visited states
        for (int visited = 1; visited < (1 << n); visited++) {
            for (int last = 0; last < n; last++) {
                if ((visited & (1 << last)) != 0) { // If the 'last' city is in the current visited set
                    for (int next = 0; next < n; next++) {
                        if ((visited & (1 << next)) == 0) { // If the 'next' city is not in the visited set
                            int newVisited = visited | (1 << next);
                            dp[next][newVisited] = Math.min(dp[next][newVisited],
                                    dp[last][visited] + graph[last][next]);
                        }
                    }
                }
            }
        }

        // Find the minimum cost to return to the starting city
        int minCost = INF;
        for (int last = 1; last < n; last++) {
            minCost = Math.min(minCost, dp[last][(1 << n) - 1] + graph[last][0]);
        }

        return minCost;
    }
}

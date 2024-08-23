public class IslandProblemDFS {
    public static void main(String[] args){
    char[][] grid1 = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
    };

    // Calculate the number of islands
    int numIslands = numIslands(grid1);

    // Output the result
        System.out.println("Number of islands: " + numIslands);
    }

    private static int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        if(grid == null || grid.length == 0){
            return 0;
        }
        for(int i = 0; i < rows ; i++){
            for(int j = 0; j < cols ; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private static void dfs(char[][] grid, int r, int c) {
        if(r  < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == '0'){
            return;
        }
        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c +1);
    }
}

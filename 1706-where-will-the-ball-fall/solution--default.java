class Solution {
    public int[] findBall(int[][] grid) {
        if (grid[0].length == 1) return new int[] {-1};
        
        int[] result = new int[grid[0].length];
        
        for (int j = 0; j < grid[0].length; j++) {
            result[j] = drop(grid, 0, j);
        }
        
        return result;
    }
    
    private static int drop(int[][] grid, int i, int j) {
        if (grid[i][j] == 1 && j < grid[i].length - 1 && grid[i][j + 1] == -1) return -1;
        if (grid[i][j] == 1 && j == grid[i].length - 1) return -1;
        
        if (grid[i][j] == -1 && j > 0 && grid[i][j - 1] == 1) return -1;
        if (grid[i][j] == -1 && j == 0) return -1;
        
        if (i == grid.length - 1) return j + grid[i][j];
        
        if (grid[i][j] == 1 && j < grid[i].length - 1) return drop(grid, ++i, ++j);
        if (grid[i][j] == -1 && j > 0) return drop(grid, ++i, --j);
        
        return -1;
    }
}
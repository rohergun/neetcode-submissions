class Solution {
    public int orangesRotting(int[][] grid) {
        Deque<int[]> q = new ArrayDeque<>();
        int fresh = 0, time = 0;
        
        for (int i=0;i<grid.length; i++) {
            for (int j=0;j<grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                }
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                }
            }
        }

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        while (!q.isEmpty() && fresh > 0) {
            int len = q.size();
            for (int k=0; k<len; k++) {
                int[] cur = q.poll();
                int i = cur[0], j = cur[1];

                for (int[] dir: directions) {
                    int row = i + dir[0];
                    int col = j + dir[1];

                    if (row >= 0 && row < grid.length && 
                        col >= 0 && col < grid[0].length &&
                        grid[row][col] == 1) {
                        
                        grid[row][col] = 2;
                        q.offer(new int[]{row, col});
                        fresh--;
                    }
                }
            }
            time++;
        }
        if (fresh == 0) {
            return time;
        }
        return -1;
    }
}

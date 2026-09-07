class Solution {
    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][] pac = new boolean[heights.length][heights[0].length];
        boolean[][] atl = new boolean[heights.length][heights[0].length];

        for (int j=0; j<heights[0].length; j++) {
            dfs(0, j, pac, heights);
            dfs(heights.length - 1, j, atl, heights);
        }

        for (int i=0; i<heights.length; i++) {
            dfs(i, 0, pac, heights);
            dfs(i, heights[0].length - 1, atl, heights);
        }

        List<List<Integer>> res = new ArrayList<>();

        for (int i=0; i<heights.length; i++) {
            for (int j=0; j<heights[0].length; j++) {
                if (pac[i][j] && atl[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    private void dfs(int i, int j, boolean[][] ocean, int[][] heights) {
        ocean[i][j] = true;
        for (int[] d: directions) {
            int ni = i + d[0], nj = j + d[1];
            
            if (ni >= 0 && ni < heights.length && nj >= 0 && nj < heights[0].length &&
                !ocean[ni][nj] && heights[ni][nj] >= heights[i][j]) {
                
                dfs(ni, nj, ocean, heights);
            }
        }
    }
}






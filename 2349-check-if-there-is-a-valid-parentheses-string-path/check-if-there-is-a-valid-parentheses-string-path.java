class Solution {
    private Boolean[][][] memo;
    private int m, n, maxBal;

    public boolean hasValidPath(char[][] grid) {
        m = grid.length;
        n = grid[0].length;

        // Path length must be even to form valid balanced parentheses
        if ((m + n - 1) % 2 != 0) {
            return false;
        }

        // Must start with '(' and end with ')'
        if (grid[0][0] == ')' || grid[m - 1][n - 1] == '(') {
            return false;
        }

        maxBal = (m + n) / 2;
        memo = new Boolean[m][n][maxBal + 1];

        return dfs(grid, 0, 0, 0);
    }

    private boolean dfs(char[][] grid, int r, int c, int bal) {
        // Update balance for current cell
        bal += (grid[r][c] == '(') ? 1 : -1;

        // Balance cannot be negative or exceed the maximum possible balance for a valid path
        if (bal < 0 || bal > maxBal) {
            return false;
        }

        // Reached destination
        if (r == m - 1 && c == n - 1) {
            return bal == 0;
        }

        // Check memoization cache
        if (memo[r][c][bal] != null) {
            return memo[r][c][bal];
        }

        boolean found = false;

        // Move Down
        if (r + 1 < m) {
            found = dfs(grid, r + 1, c, bal);
        }

        // Move Right
        if (!found && c + 1 < n) {
            found = dfs(grid, r, c + 1, bal);
        }

        return memo[r][c][bal] = found;
    }
}
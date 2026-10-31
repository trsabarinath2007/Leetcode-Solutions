class Solution {
    public int uniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int MOD = 1_000_000_007;

        // go[i][j][0] stores the final (r, c) landing spot if trying to move RIGHT from (i, j)
        // go[i][j][1] stores the final (r, c) landing spot if trying to move DOWN from (i, j)
        int[][][][] go = new int[m][n][2][2];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Precompute for direction 0 (Trying to go Right)
                {
                    int r = i, c = j + 1;
                    int dir = 0; // 0: right, 1: down
                    boolean valid = true;
                    while (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == 1) {
                        if (dir == 0) {
                            // Entered while moving right -> turns down
                            dir = 1;
                            r += 1;
                        } else {
                            // Entered while moving down -> turns right
                            dir = 0;
                            c += 1;
                        }
                    }
                    if (r < 0 || r >= m || c < 0 || c >= n) {
                        go[i][j][0][0] = -1;
                        go[i][j][0][1] = -1;
                    } else {
                        go[i][j][0][0] = r;
                        go[i][j][0][1] = c;
                    }
                }

                // Precompute for direction 1 (Trying to go Down)
                {
                    int r = i + 1, c = j;
                    int dir = 1;
                    while (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == 1) {
                        if (dir == 0) {
                            dir = 1;
                            r += 1;
                        } else {
                            dir = 0;
                            c += 1;
                        }
                    }
                    if (r < 0 || r >= m || c < 0 || c >= n) {
                        go[i][j][1][0] = -1;
                        go[i][j][1][1] = -1;
                    } else {
                        go[i][j][1][0] = r;
                        go[i][j][1][1] = c;
                    }
                }
            }
        }

        long[][] dp = new long[m][n];
        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == 0) continue;

                // Try moving Right (Mapped to go[i][j][0])
                int nextR = go[i][j][0][0];
                int nextC = go[i][j][0][1];
                if (nextR != -1) {
                    dp[nextR][nextC] = (dp[nextR][nextC] + dp[i][j]) % MOD;
                }

                // Try moving Down (Mapped to go[i][j][1])
                nextR = go[i][j][1][0];
                nextC = go[i][j][1][1];
                if (nextR != -1) {
                    dp[nextR][nextC] = (dp[nextR][nextC] + dp[i][j]) % MOD;
                }
            }
        }

        return (int) dp[m - 1][n - 1];
    }
}
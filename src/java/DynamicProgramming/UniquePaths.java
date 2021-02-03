package DynamicProgramming;
// 62
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] states = new int[m+1][n+1];
        for (int i = 0; i <= m; i ++) {
            states[i][0] = 0;
        }
        for (int j = 0; j <= n; j ++) {
            states[0][j] = 0;
        }
        states[0][1] = 1;

        for (int i = 1; i <= m; i ++) {
            for (int j = 1; j <= n; j ++) {
                states[i][j] = states[i-1][j] + states[i][j-1];
            }
        }
        return states[m][n];
    }
}

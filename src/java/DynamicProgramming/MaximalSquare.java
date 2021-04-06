package DynamicProgramming;
//221
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int[][] states = new int[matrix.length][matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix.length; i ++) {
            for (int j = 0; j < matrix[0].length; j ++) {
                if (i == 0 || j == 0) {
                    states[i][j] = matrix[i][j] - '0';
                }else if(matrix[i][j] == '1'){
                    states[i][j] = Math.min(states[i][j], Math.min(states[i][j-1], states[i-1][j])) + 1;
                }else {
                    states[i][j] = 0;
                }
                max = Math.max(max, states[i][j]);
            }
        }
        return max * max;
    }
}

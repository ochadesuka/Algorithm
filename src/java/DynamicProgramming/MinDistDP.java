package DynamicProgramming;

public class MinDistDP {
    public static int getValue(int[][] matrix, int n) {
        int[][] states = new int[n][n];
        states[0][0] = matrix[0][0];
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                if (i == 0 && j > 0) {
                    states[i][j] = states[i][j-1] + matrix[i][j];
                } else if (i > 0 && j == 0) {
                    states[i][j] = states[i-1][j] + matrix[i][j];
                }else if (i > 0 && j > 0) {
                    states[i][j] = Math.min(states[i-1][j]+matrix[i][j], states[i][j-1]+matrix[i][j]);
                }
            }
        }
        return states[n-1][n-1];
    }
    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,9},{2,1,3,4},{5,2,6,7},{6,8,4,3}};
        System.out.println(MinDistDP.getValue(matrix, 4));
    }
}

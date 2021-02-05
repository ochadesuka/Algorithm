package AlgorithmArray;

public class Rotate {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if( n == 1) {
            return;
        }
        for (int i = 0; i < n; i ++) {
            for (int j = i; j < n-1-i; j ++) {
                int tmp = matrix[j][n-1-i];
                matrix[j][n-1-i] = matrix[i][j];
                int tmp1 = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = tmp;
                tmp = matrix[n-1-j][i];
                matrix[n-1-j][i] = tmp1;
                matrix[i][j] = tmp;
            }
        }
    }
}

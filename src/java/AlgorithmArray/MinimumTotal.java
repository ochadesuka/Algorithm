package AlgorithmArray;

import java.util.List;

//给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
//相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
public class MinimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] f = new int[n][n];
        f[0][0] = triangle.get(0).get(0);
        for (int i = 1;i < n; i ++) {
            f[i][0] = f[i-1][0] + triangle.get(i).get(0);
            for (int j = 1;j < i; j ++) {
                f[i][j] = Math.min(f[i-1][j-1], f[i-1][j]) + triangle.get(i).get(j);
            }
            f[i][i] = f[i-1][i-1] + triangle.get(i).get(i);
        }
        int min = f[n-1][0];
        for (int i = 1; i < n; i++) {
            if (f[n-1][i] < min) {
                min = f[n-1][i];
            }
        }
        return min;
    }
}

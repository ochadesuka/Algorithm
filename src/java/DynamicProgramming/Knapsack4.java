package DynamicProgramming;
//假设我们有几种不同币值的硬币 v1，v2，……，vn（单位是元）。
// 如果我们要支付 w 元，求最少需要多少个硬币。
// 比如，我们有 3 种不同的硬币，1 元、3 元、5 元，我们要支付 9 元，最少需要 3 个硬币（3 个 3 元的硬币）
public class Knapsack4 {
    public static int getValue(int[] values, int v) {
        boolean[][] states = new boolean[v][v+1];
        int count;
        for(int i = 0; i < values.length; i ++) {
            if (values[i] <= v) {
                states[0][values[i]] = true;
            }
        }
        for (int i = 1; i < v; i ++) {
            for (int j = 0; j < v+1; j ++) {
                if (states[i-1][j]) {
                    for (int z = 0; z < values.length; z ++) {
                        if (j + values[z] <= v) {
                            states[i][j+values[z]] = true;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < v; i ++) {
            if (states[i][v]) {
                return i+1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] value = {1,3,5};
        System.out.println(Knapsack4.getValue(value, 9));
    }
}

package DynamicProgramming;
/*
* 01
* {2,2,4,6,3}
 */
public class Knapsack2 {
    public static int getMaxWeight(int[] weight, int n, int w) {
        boolean[][] states = new boolean[n][w+1];
        if (weight[0] <= w) {
            states[0][weight[0]] = true;
        }
        for(int i = 1;i < n; i ++) {
            for(int j = 0;j < w+1; j ++) {
                //don't put
                if (states[i-1][j]) {
                    states[i][j] = true;
                    if (j+weight[i] <= w) {
                        states[i][j+weight[i]] = true;
                    }
                }
            }
        }
        for (int j = w;j >= 0; j--) {
            if (states[n-1][j]) {
                return j;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] weight = {2,2,4,6,3};
        System.out.println(Knapsack2.getMaxWeight(weight, 5, 9));
    }

}

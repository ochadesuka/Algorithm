package DynamicProgramming;
/*
* 01
* {2,2,4,6,3}
 */
public class Knapsack {
    public static int getMaxWeight(int[] weight, int n, int w) {
        int[][] states = new int[n][w+1];
        if (weight[0] <= w) {
            states[0][weight[0]] = 1;
        }
        for(int i = 1;i < n; i ++) {
            for(int j = 0;j < w+1; j ++) {
                //don't put
                if (states[i-1][j] > 0) {
                    states[i][j] = 1;
                    if (j+weight[i] <= w) {
                        states[i][j+weight[i]] = 1;
                    }
                }
            }
        }
        for (int i = 0; i < n;i ++) {
            System.out.print("[ ");
            for (int j = 0;j < w+1; j ++){
                System.out.print(Integer.toString(states[i][j] ) + ", ");
            }
            System.out.print("]" + "\n");
        }
        for (int j = w;j >= 0; j--) {
            if (states[n-1][j] > 0) {
                return j;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] weight = {2,2,4,6,3};
        System.out.println(Knapsack.getMaxWeight(weight, 5, 9));
    }

}

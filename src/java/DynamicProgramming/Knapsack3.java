package DynamicProgramming;
//{2,2,4,6,3}
//{3,4,8,9,6}
public class Knapsack3 {
    public static int getMaxValue(int[] weight, int[] value, int n, int w) {
        int[][] states = new int[n][w+1];
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < w+1; j ++){
                states[i][j] = -1;
            }
        }
        if (weight[0] <= w) {
            states[0][0] = 0;
            states[0][weight[0]] = value[0];
        }
        for (int i = 1; i < n; i ++) {
            for (int j = 0; j < w + 1; j ++) {
                if (states[i-1][j] >= 0) {
                    states[i][j] = Math.max(states[i-1][j], states[i][j]);
                    //fang
                    if (j + weight[i] <= w) {
                        states[i][j + weight[i]] = Math.max(states[i][j + weight[i]], states[i-1][j] + value[i]);
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

        for (int i = w; i >= 0; i --) {
            if (states[n-1][i] > 0) {
                return states[n-1][i];
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        int[] weight = {2,2,4,6,3};
        int[] value = {3,4,8,9,6};
        System.out.println(Knapsack3.getMaxValue(weight, value,5, 9));
    }
}

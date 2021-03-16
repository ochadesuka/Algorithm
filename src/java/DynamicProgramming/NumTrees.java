package DynamicProgramming;
//96
public class NumTrees {
    public int numTrees(int n) {
        int[] states = new int[n+1];
        states[1] = 1;
        for (int i = 2; i <= n; i ++) {
            states[i] = states[i-1] * 2;
            for (int j = 1; j < i-1; j ++) {
                states[i] = states[i] + states[j] * states[i-1-j];
            }
        }
        return states[n];
    }
}

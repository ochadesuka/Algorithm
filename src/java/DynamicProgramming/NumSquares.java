package DynamicProgramming;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

//279
public class NumSquares {
    public int numSquares(int n) {
        int[] states = new int[n+1];
        Arrays.fill(states, Integer.MAX_VALUE);
        states[0] = 0;

        int max_sq_index = (int)Math.sqrt(n) + 1;
        int[] sq = new int[max_sq_index];
        for (int i = 1; i < max_sq_index; i ++) {
            sq[i] = i * i;
        }

        for (int i = 1; i <= n; i ++) {
            for (int s = 1; s < max_sq_index; s ++) {
                if (i < sq[s]) {
                    break;
                }
                states[i] = Math.min(states[i], states[i - sq[s]] + 1);
            }
        }
        return states[n];
    }
}

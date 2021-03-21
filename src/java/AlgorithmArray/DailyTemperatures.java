package AlgorithmArray;

import java.util.ArrayDeque;
import java.util.Deque;

//739
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        for (int i = 0; i < T.length; i ++) {
            for (int j = i + 1; j < T.length; j ++) {
                if (T[j] > T[i]) {
                    res[i] = j - i;
                    break;
                }
            }
        }
        return res;
    }

    public int[] dailyTemperatures2(int[] T) {
        int[] res = new int[T.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < T.length; i ++) {
            while (!stack.isEmpty()) {
                if (T[i] > T[stack.peek()]) {
                    res[stack.peek()] = i - stack.pop();
                }
            }
            stack.push(i);
        }
        return res;
    }
}

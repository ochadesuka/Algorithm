package DynamicProgramming;

import java.util.Stack;
//32
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        char[] cs = s.toCharArray();
        if (cs.length == 0) {
            return 0;
        }
        int[] states = new int[s.length()+1];
        states[0] = 0;
        states[1] = 0;
        for(int i = 2; i < states.length; i ++) {
            if (cs[i-1] == '(') {
                states[i] = 0;
            }else if(cs[i-1] == ')') {
                if (cs[i-2] == '(') {
                    states[i] = states[i-2] + 2;
                }else if(cs[i-2] == ')' && i-2-states[i-1] >= 0 && cs[i-2-states[i-1]] == '(') {
                    states[i] = states[i-1] + 2 + states[i-2-states[i-1]];
                }else {
                    states[i] = 0;
                }
            }
        }
        int max = 0;
        for (int i = states.length-1; i >= 0; i --) {
            max = Math.max(max, states[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        LongestValidParentheses l = new LongestValidParentheses();
        System.out.println(l.longestValidParentheses("()"));
    }
}

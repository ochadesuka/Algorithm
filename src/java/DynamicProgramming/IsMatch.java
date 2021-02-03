package DynamicProgramming;

import java.util.Stack;

public class IsMatch {
    private boolean match = false;
    public boolean isMatch(String s, String p) {
        int sl = s.length();
        int pl = p.length();

        boolean[][] states = new boolean[sl+1][pl+1];
        states[0][0] = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && states[0][i - 1]) {
                states[0][i + 1] = true;
            }
        }

        for (int i = 0; i < sl; i ++) {
            for (int j = 0; j < pl; j ++) {
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                    states[i+1][j+1] = states[i][j];
                }else if(p.charAt(j) == '*') {
                    states[i+1][j+1] = states[i+1][j-1];
                    if (p.charAt(j-1) == s.charAt(i) || p.charAt(j-1) == '.') {
                        states[i+1][j+1] = states[i][j+1] || states[i+1][j];
                    }
                }

            }
        }
        return states[sl][pl];
    }



    public static void main(String[] args) {
        IsMatch match = new IsMatch();
        System.out.println(match.isMatch("ab", "c*a*b*"));
    }
}

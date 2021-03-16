package DynamicProgramming;
import java.util.Arrays;
//5
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        boolean[][] states = new boolean[s.length()][s.length()];
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i ++) {
            states[i][i] = true;
        }
        int begin = 0;
        int max = 1;
        for(int j = 1; j < cs.length; j ++) {
            for(int i = 0; i < j; i ++) {
                if (cs[i] != cs[j]) {
                    states[i][j] = false;
                    continue;
                }
                if (j - i < 3) {
                    states[i][j] = true;
                }else {
                    states[i][j] = states[i+1][j-1];
                }

                if (states[i][j] && j - i + 1 > max) {
                    begin = i;
                    max = j - i + 1;
                }
            }
        }
        return s.substring(begin, begin+max);
    }

    public static void main(String[] args) {
        LongestPalindrome l = new LongestPalindrome();
        System.out.println(l.longestPalindrome("babad"));
    }
}

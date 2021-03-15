package DynamicProgramming;

import java.util.Arrays;

//5
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        String res = "";
        int max = 0;
        char[] cs = s.toCharArray();
        for (int i = 0; i < s.length(); i ++) {
            for (int j = s.length()-1; j >= i; j --) {
                char[] css = Arrays.copyOfRange(cs, i, j+1);
                if (isPalindrome(css) && css.length > max ) {
                    max = css.length;
                    res = String.valueOf(css);
                }
            }
        }
        return res;
    }

    public boolean isPalindrome(char[] cs) {
        int l = 0, r = cs.length-1;
        while(l < r) {
            if (cs[l] != cs[r]) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        LongestPalindrome l = new LongestPalindrome();
        System.out.println(l.longestPalindrome("babad"));
    }
}

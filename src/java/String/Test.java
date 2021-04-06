package String;

import java.util.HashSet;
import java.util.Set;

public class Test {
    public static int longestSubString(String str) {
        Set<Character> set = new HashSet<>();
        int res = 0, i = 0, j = 0;
        while(i < str.length() && j < str.length()) {
            if (!set.contains(str.charAt(j))) {
                set.add(str.charAt(j));
                j++;
                res = Math.max(res, j - i);
            }else {
                set.remove(str.charAt(i));
                i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(longestSubString("abcabcbb"));
    }
}

package TwoPoint;

import java.util.HashSet;
import java.util.Set;

// 3
public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        int l = s.length();
        int ans = 0;
        for (int i = 0; i < l; i ++) {
            Set<Character> set = new HashSet<>();
            int r = 0;
            if (i != 0) {
                set.remove(s.charAt(i-1));
            }

            while(r  + i < l && !set.contains(s.charAt(i + r ))) {
                set.add(s.charAt(i + r));
                r ++;
            }
            ans = Math.max(ans, r);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(LengthOfLongestSubstring.lengthOfLongestSubstring("dvdf"));
    }
}

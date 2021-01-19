package Recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//395
public class LongestSubstring {
    public static int longestSubstring(String s, int k) {

        int[] counts = new int[26];
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < s.length(); i ++) {
            counts[s.charAt(i) - 'a'] ++;
        }

        for (int i = 0; i < s.length(); i ++) {
            if (counts[s.charAt(i) - 'a'] < k) {
                list.add(i);
            }
        }

        if (list.isEmpty()) {
            return s.length();
        }

        int ans = 0, tmp = 0;
        list.add(s.length());
        for (Integer i : list) {
            ans = i > tmp? Math.max(ans, longestSubstring(s.substring(tmp, i), k)) : ans;
            tmp = i + 1;
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "ababbc";
        System.out.println(LongestSubstring.longestSubstring(s, 2));
    }
}

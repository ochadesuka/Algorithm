package String;

import java.util.*;

//30
public class FindSubstring {
    public List<Integer> findSubstring(String s, String[] words){
        List<Integer> res = new ArrayList<>();
        int wn = words.length;
        if (wn == 0) {
            return res;
        }
        Map<String, Integer> map1 = new HashMap<>();
        for (int i = 0; i < wn; i ++) {
            int v = map1.getOrDefault(words[i], 0);
            map1.put(words[i], v+1);
        }
        int wl = words[0].length();
        for (int i = 0; i < s.length() - wn * wl + 1 ; i ++) {
            String sub = s.substring(i, i + wn * wl);
            Map<String, Integer> map2 = new HashMap<>();
            int j = 0;
            while(j < sub.length()) {
                String ss = sub.substring(j, j+wl);
                if (map1.containsKey(ss)) {
                    int v = map2.getOrDefault(ss, 0);
                    map2.put(ss, v+1);
                    if (map2.get(ss) > map1.get(ss)) {
                        break;
                    }
                }else {
                    break;
                }
                j += wl;
            }
            if (j == wn * wl) {
                res.add(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FindSubstring f = new FindSubstring();
        System.out.println(f.findSubstring("barfoothefoobarman", new String[]{"bar", "foo"}).toString());
    }
}

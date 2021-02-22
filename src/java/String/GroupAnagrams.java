package String;

import java.util.*;

//49
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String str:strs) {
            char[] chs = str.toCharArray();
            Arrays.sort(chs);
            String str1 = String.valueOf(chs);
            if (map.containsKey(str1)) {
                res.get(map.get(str1)).add(str);
            }else {
                List<String> list = new ArrayList<>();
                list.add(str);
                res.add(list);
                map.put(str1, res.size()-1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        GroupAnagrams g = new GroupAnagrams();
        System.out.println(g.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}

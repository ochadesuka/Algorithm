package String;

import java.util.HashSet;
import java.util.List;

//139
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> word = new HashSet<>(wordDict);
        boolean[] states = new boolean[s.length()+1];
        states[0] = true;
        for (int i = 1; i < s.length(); i ++) {
            for (int j = 0; j < i; j ++) {
                if (states[j] && word.contains(s.substring(j, i))) {
                    states[i] = true;
                }
            }
        }
        return states[s.length()];
    }
}

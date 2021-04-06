package String;
//647
public class CountSubstrings {
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i ++) {
            for (int j = i + 1; j < s.length(); j ++) {
                if (isPalindromic(s.substring(i, j))) {
                    count++;
                }
            }
        }
        return count;
    }

    public int countSubstrings2(String s) {
        int count = 0, n = s.length();
        for (int i = 0;i < 2 * n - 1; i ++) {
            int l = i, r = i / 2 + i % 2;
            while (l >= 0 && r <= n - 1 && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
                count++;
            }
        }
        return count;
    }

    public boolean isPalindromic(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}

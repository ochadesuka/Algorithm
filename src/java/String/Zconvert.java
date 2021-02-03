package String;
//6
public class Zconvert {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder ss = new StringBuilder();
        int cycle = 2 * numRows - 2;
        for (int i = 0; i < numRows; i ++) {
            for (int j = 0; j + i < s.length(); j += cycle) {
                ss.append(s.charAt(j + i));
                if (i > 0 && i < numRows-1 && j + cycle - i < s.length()) {
                    ss.append(s.charAt(j + cycle - i));
                }
            }
        }
        return ss.toString();
    }
}

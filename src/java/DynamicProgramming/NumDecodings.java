package DynamicProgramming;

public class NumDecodings {
    public int numDecodings(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int[] states = new int[s.length()];
        if (s.charAt(0) == '0') {
            return 0;
        }
        states[0] = 1;
        if (s.length() > 1) {
            int p = Integer.parseInt(s.substring(0, 2));
            if (p > 10 && p <= 26 && p != 20) {
                states[1] = 2;
            }else if (s.charAt(1) == '0' && (s.charAt(0) > '2' || s.charAt(0) == '0')){
                return 0;
            }else {
                states[1] = 1;
            }
        }
         for (int i = 2; i < s.length(); i ++) {
             int p = Integer.parseInt(s.substring(i-1, i+1));
             if (p > 10 && p <= 26 && p != 20) {
                 states[i] = states[i-1] + states[i-2];
             }else if(s.charAt(i) == '0' && (s.charAt(i-1) > '2' || s.charAt(i-1) == '0')) {
                 return 0;
             }else if (s.charAt(i) == '0' && s.charAt(i-1) <= '2' && s.charAt(i-1) > '0'){
                 states[i] = states[i-2];
             }else {
                 states[i] = states[i-1];
             }
         }
         return states[s.length()-1];
    }

    public static void main(String[] args) {
        NumDecodings n = new NumDecodings();
        System.out.println(n.numDecodings("10"));
    }
}

package String;
//8
public class Atoi {
    public int myAtoi(String s) {
        s = s.trim();
        if (s.length() == 0) {
            return 0;
        }
        int signed = isSigned(s);
        if(signed == -1) {
            return 0;
        }
        if (s.charAt(0) == '-' || s.charAt(0) == '+') {
            s = s.substring(1, s.length());
        }
        long res = 0;
        for (char c:s.toCharArray()) {
            if (isNumber(c)) {
                res = c - '0' + res * 10;
                res = signed == 0 ? Math.min(res, -(long)Integer.MIN_VALUE) : Math.min(res, (long)Integer.MAX_VALUE);
            }else {
                break;
            }
        }

        return signed == 0 ? (int)-res:(int)res;
    }

    public int isSigned(String s) {
        if ('-' == s.charAt(0)) {
            return 0;
        }else if('+' == s.charAt(0) || isNumber(s.charAt(0))) {
            return 1;
        }
        return -1;
    }

    public boolean isNumber(char c) {
        if (c - '0' >= 0 && c - '0' <= 9) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Atoi atoi = new Atoi();
        System.out.println(atoi.myAtoi("+0 123"));
    }
}

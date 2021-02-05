package String;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;

//43
public class Multiply {
    public String multiply(String num1, String num2) {
        if (num1.length() == 0 || num2.length() == 0 || num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        String res = "0";
        for (int i = num2.length()-1; i >= 0; i --) {
            int n1 = num2.charAt(i) - '0';
            StringBuilder sb = new StringBuilder();
            int p = 0;
            for (int j = num2.length()-1; j > i; j --) {
                sb.append(0);
            }
            for (int j = num1.length()-1; j >= 0; j --) {
                int n2 = num1.charAt(j) - '0';
                int pp = n1 * n2 + p;
                sb.append(pp % 10);
                p = pp / 10;
            }
            if (p != 0) {
                sb.append(p);
            }
            res = add(res, sb.reverse().toString());

        }
        return res;

    }

    public String add(String str1, String str2) {
        int i = str1.length() - 1, j = str2.length() - 1, p = 0;
        StringBuilder sb = new StringBuilder();
        while(i >= 0 || j >= 0 || p != 0) {
            int num1 = i >= 0?str1.charAt(i) - '0':0;
            int num2 = j >= 0?str2.charAt(j) - '0':0;
            int res = num1 + num2 + p;
            sb.append(res % 10);
            p = res / 10;
            i--;
            j--;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Multiply m = new Multiply();
        System.out.println(m.multiply("2", "3"));
    }
}

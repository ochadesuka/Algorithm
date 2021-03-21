package Recursion;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

//394
public class DecodeString {
    public String decodeString(String s) {
        LinkedList<String> stack = new LinkedList<>();
        int i = 0;
        while (i < s.length()) {
            if (Character.isDigit(s.charAt(i))) {
                StringBuffer digit = new StringBuffer();
                while (Character.isDigit(s.charAt(i))) {
                    digit.append(s.charAt(i++));
                }
                stack.push(digit.toString());
            }else if (Character.isLetter(s.charAt(i)) || s.charAt(i) == '[') {
                stack.push(String.valueOf(s.charAt(i)));
                i++;
            }else {
                i++;
                LinkedList<String> strs = new LinkedList<>();
                while (!stack.peek().equals("[")) {
                    strs.push(stack.pop());
                }
                stack.pop();
//                Collections.reverse(strs);
                int count = Integer.valueOf(stack.pop());
                StringBuffer sb1 = new StringBuffer();
                while (!strs.isEmpty()) {
                    sb1.append(strs.pop());
                }
                StringBuffer sb =  new StringBuffer();
                while (count > 0) {
                    sb.append(sb1.toString());
                    count--;
                }
                stack.push(sb.toString());
            }
        }
        StringBuffer sb = new StringBuffer();
        Collections.reverse(stack);
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        DecodeString ds = new DecodeString();
        System.out.println(ds.decodeString("2[a2[bc]]"));
    }
}

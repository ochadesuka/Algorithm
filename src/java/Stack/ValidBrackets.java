package Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidBrackets {
    public static boolean isValid(String s) {
        Map<Character, Character> pair = new HashMap<>();
        pair.put(')', '(');
        pair.put(']','[');
        pair.put('}','{');

        Stack<Character> stack = new Stack<>();
        char[] c = s.toCharArray();
        if (c.length == 0) {
            return true;
        }
        for (char cc : c) {
            if (pair.containsKey(cc)) {
                if (stack.isEmpty() || pair.get(cc) != stack.peek()) {
                    return false;
                }
                stack.pop();
            }else {
                stack.push(cc);
            }
        }

        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }

    public static boolean isLeft(char c) {
        if (c == '(' || c == '[' || c == '{') {
            return true;
        }
        return false;
    }

    public static boolean isRight(char c) {
        if (c == ')' || c == ']' || c == '}') {
            return true;
        }
        return false;
    }
}

package Stack;

import java.util.Stack;
//
public class EvalRPN {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> nums = new Stack<>();

        for(String token : tokens) {
            switch (token) {
                case "+":
                    int i1 = nums.pop();
                    nums.push(i1 + nums.pop());
                    break;
                case "-":
                    int i2 = nums.pop();
                    nums.push(nums.pop() - i2);
                    break;
                case "*":
                    int i3 = nums.pop();
                    nums.push(nums.pop() * i3);
                    break;
                case "/":
                    int i4 = nums.pop();
                     nums.push(nums.pop() / i4);
                     break;
                default:
                    nums.push(Integer.valueOf(token));
                    break;
            }
        }

        return nums.pop();

    }

    public static void main(String[] args) {
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(EvalRPN.evalRPN(tokens));
    }
}





































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































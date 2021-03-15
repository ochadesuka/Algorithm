package Queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

//225 用队列实现栈
public class MyStack {
    Queue<Integer>  q1;
    Queue<Integer> q2;
    /** Initialize your data structure here. */
    public MyStack() {
        q1 = new ArrayDeque<>();
        q2 = new ArrayDeque<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        while(!q1.isEmpty()) {
            q2.add(q1.remove());
        }
        q1.add(x);
        while(!q2.isEmpty()) {
            q1.add(q2.remove());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return q1.remove();
    }

    /** Get the top element. */
    public int top() {
        return q1.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }
}

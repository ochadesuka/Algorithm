package List;

import java.util.List;
import java.util.Stack;

//234
public class IsPalindrome {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode half = endOfHalf(head);
        ListNode half2Start = reverseList(half.next);
        ListNode p1 = head;
        ListNode p2 = half2Start;
        boolean res = true;
        while(res && p2 != null) {
            if (p1.val != p2.val) {
                res = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return res;
    }

    private ListNode endOfHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}

package List;

import java.util.HashSet;
import java.util.Set;

public class HasCycleList2 {
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return false;
        }
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode head2 = new ListNode(2);
        head.next = head2;
        ListNode head3 = new ListNode(0);
        head2.next = head3;
        ListNode head4 = new ListNode(4);
        head3.next = head4;
        head4.next = head2;
        System.out.println(HasCycleList2.hasCycle(head));
    }
}

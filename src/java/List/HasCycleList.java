package List;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//leetcode 141
public class HasCycleList {
    public static boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
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
        System.out.println(HasCycleList.hasCycle(head));
    }
}

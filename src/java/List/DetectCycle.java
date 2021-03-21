package List;
//142
public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        int fc = 0;
        int sc = 0;
        while(fast != null) {
            slow = slow.next;
            sc++;
            if (fast.next != null) {
                fast = fast.next.next;
                fc += 2;
            }else {
                return null;
            }
            if (slow == fast) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }
}

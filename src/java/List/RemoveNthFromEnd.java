package List;
// 19
public class RemoveNthFromEnd {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tmp = new ListNode(0);
        tmp.next = head;
        ListNode fast = head;
        ListNode slow = tmp;
        for (int i = 0; i < n; i ++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return tmp.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode n = RemoveNthFromEnd.removeNthFromEnd(head, 1);
        while (n != null) {
            System.out.print(n.val + ",");
            n = n.next;
        }
    }
}

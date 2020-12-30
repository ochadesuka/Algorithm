package List;

import java.util.Stack;

class ListNode {
     int val;
     ListNode next;
     ListNode(int val){this.val = val;}
 }

public class ReverseList {
    public static ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode curNext = cur.next;
            cur.next = pre;
            pre = cur;
            cur = curNext;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head2 = new ListNode(2);
        head.next = head2;
        ListNode head3 = new ListNode(3);
        head2.next = head3;
        ListNode head4 = new ListNode(4);
        head3.next = head4;
        ListNode head5 = new ListNode(5);
        head4.next = head5;

        ListNode res = ReverseList.reverse(head);
        while(res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}

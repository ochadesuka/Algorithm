package List;
//25
public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        int length = 0;
        ListNode head2 = head;
        if (k <= 1) {
            return head;
        }
        while(head2 != null) {
            length++;
            head2 = head2.next;
        }

        ListNode d = new ListNode(-1);
        d.next = head;
        ListNode res = d;
        ListNode pre = head;
        ListNode pcur = pre.next;
        int curIndex = 0;
        while (length - curIndex + 1 > k) {
            int i = k -1;
            while(i > 0) {
                pre.next = pcur.next;
                pcur.next = d.next;
                d.next = pcur;
                pcur = pre.next;
                curIndex++;
                i--;
            }
            curIndex++;
            d = pre;
            pre = pcur;
            if (pcur != null) {
                pcur = pcur.next;
            }
        }

       return res.next;
    }

    public ListNode reverseKGroup2(ListNode head, int k) {
        ListNode d = new ListNode(-1);
        d.next = head;
        ListNode pre = d;
        while(head != null) {
            ListNode tail = pre;
            for (int i = 0;i < k; i ++) {
                tail = tail.next;
                if(tail == null) {
                    return d.next;
                }
            }
            ListNode next = tail.next;
            ListNode[] re = reverse(head, tail);
            head = re[0];
            tail = re[1];
            pre.next = head;
            tail.next = next;
            pre = tail;
            head = tail.next;
        }
        return d.next;
    }

    public ListNode[] reverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next;
        ListNode p = head;
        while(prev != tail) {
            ListNode next = p.next;
            p.next = prev;
            prev = p;
            p = next;
        }
        return new ListNode[]{tail, head};
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        l1.next = l2;
        ListNode l3 = new ListNode(3);
        l2.next = l3;

        ListNode l4 = new ListNode(4);
        l3.next = l4;
        ListNode l5 = new ListNode(5);
        l4.next = l5;

        ReverseKGroup k = new ReverseKGroup();
        ListNode res = k.reverseKGroup(l1, 5);
        while (res != null) {
            System.out.print(res.val + ",");
            res = res.next;
        }
    }
}

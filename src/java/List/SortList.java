package List;
//148
public class SortList {
    public ListNode sortList(ListNode head) {
        ListNode head1 = head;
        int n = 0;
        while(head1 != null) {
            n++;
            head1 = head1.next;
        }

        ListNode head2 = new ListNode(0);
        head2.next = head;
        for (int i = 0; i < n; i ++) {
            ListNode pre = head2;
            ListNode cur = pre.next;
            ListNode nxt = cur.next;
            while (nxt != null) {
                if (nxt.val < cur.val) {
                    cur.next = nxt.next;
                    nxt.next = cur;
                    pre.next = nxt;
                    pre = nxt;
                    nxt = cur.next;
                }else {
                    pre = cur;
                    cur = nxt;
                    nxt = nxt.next;
                }
            }
        }

        return head2.next;
    }

    public ListNode sortList2(ListNode head) {
        return recursion(head, null);
    }

    public ListNode recursion(ListNode head, ListNode tail) {
        if (head == tail) {
            return head;
        }

        if (head.next == tail) {
            head.next = null;
            return head;
        }

        ListNode slow = head, fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode list1 = recursion(head, mid);
        ListNode list2 = recursion(mid, tail);
        ListNode sorted = merge(list1, list2);
        return sorted;
    }

    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode mergeHead = new ListNode(0);
        ListNode tmp = mergeHead, tmp1 = list1, tmp2 = list2;
        while (tmp1 != null && tmp2 != null) {
            if (tmp1.val <= tmp2.val) {
                tmp.next = tmp1;
                tmp1 = tmp1.next;
            }else {
                tmp.next = tmp2;
                tmp2 = tmp2.next;
            }
            tmp = tmp.next;
        }

        if (tmp1 != null) {
            tmp.next = tmp1;
        }else if (tmp2 != null) {
            tmp.next = tmp2;
        }

        return mergeHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(-1);
        head.next = new ListNode(5);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(0);
        SortList s = new SortList();
        s.sortList2(head);
    }
}

package List;

import java.util.List;
import java.util.PriorityQueue;

public class MergeKLists1 {
    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((x,y) -> (x.val - y.val));
        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }
        ListNode l3 = new ListNode(0);
        ListNode res = l3;

        while(!queue.isEmpty()) {
            l3.next = queue.poll();
            l3 = l3.next;
            if (l3.next != null) {
                queue.add(l3.next);
            }
        }
        return res.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l11 = new ListNode(4);
        l1.next = l11;
        ListNode l12 = new ListNode(5);
        l11.next = l12;

        ListNode l2 = new ListNode(1);
        ListNode l21 = new ListNode(3);
        l2.next = l21;
        ListNode l22 = new ListNode(4);
        l21.next = l22;

        ListNode l3 = new ListNode(2);
        ListNode l33 = new ListNode(6);
        l3.next = l33;

        ListNode[] p = {l1, l2, l3};

        ListNode res = MergeKLists1.mergeKLists(p);
        while (res != null) {
            System.out.print(res.val + ",");
            res = res.next;
        }
    }
}

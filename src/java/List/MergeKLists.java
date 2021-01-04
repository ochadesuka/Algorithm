package List;
// 23
public class MergeKLists {
    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode l3 = new ListNode(0);
        ListNode res = l3;
        int minIndex = 0;

        while(true) {
            boolean isEmpty = true;
            int min = 10001;
            for (int i = 0; i < lists.length; i ++) {
                if (lists[i] == null) {
                    isEmpty = isEmpty && true;
                }else {
                    isEmpty = isEmpty && false;
                }
            }
            if (isEmpty) {
                return res.next;
            }

            for (int i = 0; i < lists.length; i ++) {
                if (lists[i] != null) {
                    if (lists[i].val <= min) {
                        min = lists[i].val;
                        minIndex = i;
                    }
                }
            }

            l3.next = lists[minIndex];
            l3 = l3.next;
            if (lists[minIndex] != null) {
                lists[minIndex] = lists[minIndex].next;
            }

        }
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

        ListNode res = MergeKLists.mergeKLists(p);
        while (res != null) {
            System.out.print(res.val + ",");
            res = res.next;
        }
    }
}

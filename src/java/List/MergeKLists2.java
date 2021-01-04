package List;
//
public class MergeKLists2 {
    public static ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length-1);
    }

    public static ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }

        if (l > r) {
            return null;
        }

        int mid = (l + r) / 2;
        return mergeTwoLists(merge(lists, l, mid), merge(lists, mid+1, r));

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode res = l3;

        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    l3.next = l1;
                    l1 = l1.next;
                }else {
                    l3.next = l2;
                    l2 = l2.next;
                }
            }else if (l1 != null) {
                l3.next = l1;
                l1 = l1.next;
            }else if (l2 != null) {
                l3.next = l2;
                l2 = l2.next;
            }
            l3 = l3.next;
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

        ListNode res = MergeKLists2.mergeKLists(p);
        while (res != null) {
            System.out.print(res.val + ",");
            res = res.next;
        }
    }
}
